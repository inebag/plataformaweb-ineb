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

import com.plataformawebproygraduacion.umg.app.entities.AsignacionUsuarioDoc;

import com.plataformawebproygraduacion.umg.app.entities.Docente;

import com.plataformawebproygraduacion.umg.app.entities.Usuario;
import com.plataformawebproygraduacion.umg.app.repositories.AsignacionUsuarioDocReposirtory;

import com.plataformawebproygraduacion.umg.app.service.AsignacionUsuariosService;
import com.plataformawebproygraduacion.umg.app.service.DocenteService;

import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class AsignacionUsuarioDoController {
	
	@Autowired
	private AsignacionUsuarioDocReposirtory asignacionUsuarioDocReposirtory ;

	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private AsignacionUsuariosService asignacionUsuariosService;
	

	@RequestMapping(value = "/detalle-asignacion-usuario-docente/{id}", method = RequestMethod.GET)
	public String detalleAsignacionUsuarioDo(@PathVariable(value = "id") Long id, Model model) {
		
		AsignacionUsuarioDoc AsignacionUsuarioDoc = asignacionUsuarioDocReposirtory.findById(id).get();
		
		if(AsignacionUsuarioDoc == null) {
			return "redirect:/listar-asignaciones-usuarios-docentes";			
		}
		
		model.addAttribute("titulo", "Detalle Asignación Usuario Docente: " + AsignacionUsuarioDoc.getId());
		model.addAttribute("AsignacionUsuarioDoc", AsignacionUsuarioDoc);
		return "AsignacionUsuarioDo/detalle-asignacion-do-form"; 
	}
	
	@RequestMapping(value = "/listar-asignaciones-usuarios-docentes", method = RequestMethod.GET)
	public String listarAsignacionUsuarioDo(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<AsignacionUsuarioDoc> asignacionUsuarioDocs = asignacionUsuarioDocReposirtory.findAll(pageRequest);
		
		PageRender<AsignacionUsuarioDoc> pageRender = new PageRender<AsignacionUsuarioDoc>("/listar-asignaciones-usuarios-docentes", asignacionUsuarioDocs);
		model.addAttribute("titulo", "Listado de Asignación de Usuarios Docentes");
		model.addAttribute("asignacionUsuarioDocs", asignacionUsuarioDocs);
		model.addAttribute("page", pageRender);
		return "AsignacionUsuarioDo/asignaciones-usuarios-docs";
	}
	
	@RequestMapping(value = "/nueva-asignacion-usuario-docente", method = RequestMethod.GET)
	public String nuevaAsignacionUsuarioDo(Model model) {
		AsignacionUsuarioDoc asignacionUsuarioDoc = new AsignacionUsuarioDoc();
		
		List<Docente> listaDocentes = docenteService.listaDocentes();
		List<Usuario> listaUsuarios= asignacionUsuariosService.listaUsuarios();
		
		model.addAttribute("titulo", "Nueva Asignación Usuario Docente");
		model.addAttribute("asignacionUsuarioDoc", asignacionUsuarioDoc);
		model.addAttribute("docentes", listaDocentes);
		model.addAttribute("usuarios", listaUsuarios);
		return "AsignacionUsuarioDo/form-asignacion-usuario-do";
    }
	
	@RequestMapping(value = "/nueva-asignacion-usuario-docente", method = RequestMethod.POST)
	public String guardarAsignacionUsuarioDo(AsignacionUsuarioDoc asignacionUsuarioDoc) {
	
		asignacionUsuarioDocReposirtory.save(asignacionUsuarioDoc);
		return "redirect:/listar-asignaciones-usuarios-docentes";
	}
	
	@RequestMapping(value = "/editar-asignacion-usuario-doncete/{id}", method = RequestMethod.GET)
	public String editarAsignacionUsuarioDo(@PathVariable(value="id") Long id, Model model) {
		AsignacionUsuarioDoc asignacionUsuarioDoc = null;

		List<Docente> listaDocentes = docenteService.listaDocentes();
		List<Usuario> listaUsuarios= asignacionUsuariosService.listaUsuarios();
	
		
		if (id>0) {
			asignacionUsuarioDoc = asignacionUsuarioDocReposirtory.findById(id).get();
		}else {
			return "redirect:/listar-asignaciones-usuarios-docentes";
		}
		model.addAttribute("titulo", "Editar Asignación Usuario Docente");
		model.addAttribute("asignacionUsuarioDoc", asignacionUsuarioDoc);
		model.addAttribute("docentes", listaDocentes);
		model.addAttribute("usuarios", listaUsuarios);
		return "AsignacionUsuarioDo/form-asignacion-usuario-do";
	}
	
	
	@RequestMapping(value = "/eliminar-asignacion-usuario-docente/{id}", method = RequestMethod.GET)
	public String eliminarAsignacionUsuarioDo(@PathVariable(value="id") Long id, Model model) {
		AsignacionUsuarioDoc asignacionUsuarioDoc = null;
		if (id>0) {
			asignacionUsuarioDoc = asignacionUsuarioDocReposirtory.findById(id).get();
			asignacionUsuarioDocReposirtory.delete(asignacionUsuarioDoc);
		}else {
			return "redirect:/listar-asignaciones-usuarios-docentes";
		}
		
		return "redirect:/listar-asignaciones-usuarios-docentes";
	}


}
