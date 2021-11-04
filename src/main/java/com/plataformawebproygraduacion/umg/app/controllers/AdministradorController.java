package com.plataformawebproygraduacion.umg.app.controllers;

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
import com.plataformawebproygraduacion.umg.app.entities.Genero;
import com.plataformawebproygraduacion.umg.app.repositories.AdministradorRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class AdministradorController {
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@RequestMapping(value = "/detalle-administrador/{id}", method = RequestMethod.GET)
	public String detalleAdmin(@PathVariable(value = "id") Long id, Model model) {
		
		Administrador administrador = administradorRepository.findById(id).get();
		if(administrador == null) {
			return "redirect:/listar-administradores";			
		}
		
		model.addAttribute("titulo", "Detalle Administrador: " + administrador.getNombres()+" "+ administrador.getApellidos());
		model.addAttribute("administrador", administrador);
		return "Administrador/detalle-administrador-form"; 
	}
	
	@RequestMapping(value = "/listar-administradores", method = RequestMethod.GET)
	public String listarAdministradores(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Administrador> administradores = administradorRepository.findAll(pageRequest);
		
		PageRender<Administrador> pageRender = new PageRender<Administrador>("/listar-administradores", administradores);
		model.addAttribute("titulo", "Listado de Administradores");
		model.addAttribute("administradores", administradores);
		model.addAttribute("page", pageRender);
		return "Administrador/administradores";
	}
	
	@RequestMapping(value = "/nuevo-administrador", method = RequestMethod.GET)
	public String nuevoAdministrador(Model model) {
		Administrador administrador = new Administrador();
		model.addAttribute("titulo", "Nuevo Administrador");
		model.addAttribute("administrador", administrador);
		return "Administrador/form-administrador";
    }
	
	@RequestMapping(value = "/nuevo-administrador", method = RequestMethod.POST)
	public String guardarAdministrador(Administrador administrador) {
		administradorRepository.save(administrador);
		return "redirect:/listar-administradores";
	}
	
	
	@RequestMapping(value = "/editar-administrador/{id}", method = RequestMethod.GET)
	public String editarAdministrador(@PathVariable(value="id") Long id, Model model) {
		Administrador administrador = null;
		if (id>0) {
			administrador = administradorRepository.findById(id).get();
		}else {
			return "redirect:/listar-administradores";
		}
		model.addAttribute("titulo", "Editar Administrador");
		model.addAttribute("administrador", administrador);
		return "Administrador/form-administrador";
	}
	
	@RequestMapping(value = "/eliminar-administrador/{id}", method = RequestMethod.GET)
	public String eliminarAdministrador(@PathVariable(value="id") Long id, Model model) {
		Administrador administrador = null;
		if (id>0) {
			administrador = administradorRepository.findById(id).get();
			administradorRepository.delete(administrador);
		}else {
			return "redirect:/listar-administradores";
		}
		
		return "redirect:/listar-administradores";
	}

}
