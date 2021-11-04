package com.plataformawebproygraduacion.umg.app.controllers;

import java.text.Bidi;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.plataformawebproygraduacion.umg.app.dto.ChangePasswordForm;
import com.plataformawebproygraduacion.umg.app.entities.Usuario;
import com.plataformawebproygraduacion.umg.app.repositories.RoleRepository;
import com.plataformawebproygraduacion.umg.app.repositories.UsuarioRepository;
import com.plataformawebproygraduacion.umg.app.servb.UsuarioService;
import com.plataformawebproygraduacion.umg.app.service.UsuarioServiceImpl;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	
	@Autowired 
	UsuarioService usuarioService;
	
	

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}

	@GetMapping("/userForm")
	public String userForm(Model model) {
		model.addAttribute("userForm", new Usuario());
		model.addAttribute("userList", usuarioService.getAllUsuarios());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("listTab","active");
		return "user-form/user-view";
	}
	
	@PostMapping("/userForm")
	public String createUsuario(@ModelAttribute("userForm")Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
		}else {
			try {
				usuarioService.createUser(user);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab","active");

			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("userList", usuarioService.getAllUsuarios());
				model.addAttribute("roles",roleRepository.findAll());
			}
		}

		model.addAttribute("userList", usuarioService.getAllUsuarios());
		model.addAttribute("roles",roleRepository.findAll());
		return "user-form/user-view";
	}

	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Usuario userToEdit = usuarioService.getUserById(id);

		model.addAttribute("userForm", userToEdit);
		model.addAttribute("userList", usuarioService.getAllUsuarios());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new ChangePasswordForm(id));
		return "user-form/user-view";
	}

	@PostMapping("/editUser")
	public String postEditUserForm(@ModelAttribute("userForm")Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
		}else {
			try {
				usuarioService.updateUser(user);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("userList", usuarioService.getAllUsuarios());
				model.addAttribute("roles",roleRepository.findAll());
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
			}
		}

		model.addAttribute("userList", usuarioService.getAllUsuarios());
		model.addAttribute("roles",roleRepository.findAll());
		return "user-form/user-view"; 

	}

	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}
	
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id") Long id) {
		try {
			usuarioService.deleteUser(id);
		} catch (Exception e) {
			model.addAttribute("deleteError","The user could not be deleted.");
		}
		return userForm(model);
	}
	
	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			if( errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

				throw new Exception(result);
			}
			usuarioService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}
	


}
