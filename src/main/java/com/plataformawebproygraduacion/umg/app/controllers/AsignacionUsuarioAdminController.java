package com.plataformawebproygraduacion.umg.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.plataformawebproygraduacion.umg.app.entities.Administrador;
import com.plataformawebproygraduacion.umg.app.entities.AsignacionUsuarioAdmin;
import com.plataformawebproygraduacion.umg.app.entities.Usuario;
import com.plataformawebproygraduacion.umg.app.repositories.AsignacionUsuarioAdRepository;
import com.plataformawebproygraduacion.umg.app.service.AsignacionUsuariosService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class AsignacionUsuarioAdminController {
	
	@Autowired
	private AsignacionUsuarioAdRepository asignacionUsuarioAdRepository;

	@Autowired
	private AsignacionUsuariosService asignacionUsuariosService;
	

	@RequestMapping(value = "/detalle-asignacion-usuario-administrador/{id}", method = RequestMethod.GET)
	public String detalleAsignacionUsuarioAdmin(@PathVariable(value = "id") Long id, Model model) {
		
		AsignacionUsuarioAdmin asignacionUsuarioAdmin = asignacionUsuarioAdRepository.findById(id).get();
		
		if(asignacionUsuarioAdmin == null) {
			return "redirect:/listar-asignaciones-usuarios-administradores";			
		}
		
		model.addAttribute("titulo", "Detalle Asignación Usuario administrador: " + asignacionUsuarioAdmin.getId());
		model.addAttribute("asignacionUsuarioAdmin", asignacionUsuarioAdmin);
		return "AsignacionUsuarioAdmin/detalle-asignacion-admin-form"; 
	}

	@RequestMapping(value = "/listar-asignaciones-usuarios-administradores", method = RequestMethod.GET)
	public String listarAsignacionUsuarioAdmin(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<AsignacionUsuarioAdmin> asignacionUsuarioAdmins = asignacionUsuarioAdRepository.findAll(pageRequest);
		
		PageRender<AsignacionUsuarioAdmin> pageRender = new PageRender<AsignacionUsuarioAdmin>("/listar-asignaciones-usuarios-administradores", asignacionUsuarioAdmins);
		model.addAttribute("titulo", "Listado de Asignación de Usuarios Administrador");
		model.addAttribute("asignacionUsuarioAdmins", asignacionUsuarioAdmins);
		model.addAttribute("page", pageRender);
		return "AsignacionUsuarioAdmin/asignaciones-usuarios-admins";
	}
	
	
	
	@RequestMapping(value = "/nueva-asignacion-usuario-admin", method = RequestMethod.GET)
	public String nuevaAsignacionUsuarioAdmin(Model model) {
		AsignacionUsuarioAdmin asignacionUsuarioAdmin = new AsignacionUsuarioAdmin();
		
		List<Administrador> listaAdministradores = asignacionUsuariosService.listaAdministradores();
		List<Usuario> listaUsuarios= asignacionUsuariosService.listaUsuarios();
		
		model.addAttribute("titulo", "Nueva Asignación Usuario Administrador");
		model.addAttribute("asignacionUsuarioAdmin", asignacionUsuarioAdmin);
		model.addAttribute("admins", listaAdministradores);
		model.addAttribute("usuarios", listaUsuarios);
		return "AsignacionUsuarioAdmin/form-asignacion-usuario-admin";
    }
	
	@RequestMapping(value = "/nueva-asignacion-usuario-admin", method = RequestMethod.POST)
	public String guardarAsignacionUsuarioAdmin(AsignacionUsuarioAdmin asignacionUsuarioAdmin) {
	
		asignacionUsuarioAdRepository.save(asignacionUsuarioAdmin);
		return "redirect:/listar-asignaciones-usuarios-administradores";
	}

	@RequestMapping(value = "/editar-asignacion-usuario-administrador/{id}", method = RequestMethod.GET)
	public String editarAsignacionUsuarioAdmin(@PathVariable(value="id") Long id, Model model) {
		AsignacionUsuarioAdmin asignacionUsuarioAdmin = null;

		List<Administrador> listaAdministradores = asignacionUsuariosService.listaAdministradores();
		List<Usuario> listaUsuarios= asignacionUsuariosService.listaUsuarios();
	
		
		if (id>0) {
			asignacionUsuarioAdmin = asignacionUsuarioAdRepository.findById(id).get();
		}else {
			return "redirect:/listar-asignaciones-usuarios-administradores";
		}
		model.addAttribute("titulo", "Editar Asignación Usuario Administrador");
		model.addAttribute("asignacionUsuarioAdmin", asignacionUsuarioAdmin);
		model.addAttribute("admins", listaAdministradores);
		model.addAttribute("usuarios", listaUsuarios);
		return "AsignacionUsuarioAdmin/form-asignacion-usuario-admin";
	}

	@RequestMapping(value = "/eliminar-asignacion-usuario-administrador/{id}", method = RequestMethod.GET)
	public String eliminarAsignacionUsuarioAdmin(@PathVariable(value="id") Long id, Model model) {
		AsignacionUsuarioAdmin asignacionUsuarioAdmin = null;
		if (id>0) {
			asignacionUsuarioAdmin = asignacionUsuarioAdRepository.findById(id).get();
			asignacionUsuarioAdRepository.delete(asignacionUsuarioAdmin);
		}else {
			return "redirect:/listar-asignaciones-usuarios-administradores";
		}
		
		return "redirect:/listar-asignaciones-usuarios-administradores";
	}

}
