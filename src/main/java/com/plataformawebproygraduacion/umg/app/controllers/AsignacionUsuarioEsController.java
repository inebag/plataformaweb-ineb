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

import com.plataformawebproygraduacion.umg.app.entities.AsignacionUsuarioEs;
import com.plataformawebproygraduacion.umg.app.entities.Estudiante;
import com.plataformawebproygraduacion.umg.app.entities.Usuario;

import com.plataformawebproygraduacion.umg.app.repositories.AsignacionUsuarioEsRepository;
import com.plataformawebproygraduacion.umg.app.service.AsignacionUsuariosService;
import com.plataformawebproygraduacion.umg.app.service.EstudianteService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class AsignacionUsuarioEsController {
	
	@Autowired
	private AsignacionUsuarioEsRepository asignacionUsuarioEsRepository ;

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private AsignacionUsuariosService asignacionUsuariosService;
	

	@RequestMapping(value = "/detalle-asignacion-usuario-estudiante/{id}", method = RequestMethod.GET)
	public String detalleAsignacionUsuarioEs(@PathVariable(value = "id") Long id, Model model) {
		
		AsignacionUsuarioEs asignacionUsuarioEs = asignacionUsuarioEsRepository.findById(id).get();
		
		if(asignacionUsuarioEs == null) {
			return "redirect:/listar-asignaciones-usuarios-estudiantes";			
		}
		
		model.addAttribute("titulo", "Detalle Asignación Usuario Estudiante: " + asignacionUsuarioEs.getId());
		model.addAttribute("asignacionUsuarioEs", asignacionUsuarioEs);
		return "AsignacionUsuarioEs/detalle-asignacion-es-form"; 
	}
	
	@RequestMapping(value = "/listar-asignaciones-usuarios-estudiantes", method = RequestMethod.GET)
	public String listarAsignacionUsuarioEs(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<AsignacionUsuarioEs> asignacionUsuarioEst = asignacionUsuarioEsRepository.findAll(pageRequest);
		
		PageRender<AsignacionUsuarioEs> pageRender = new PageRender<AsignacionUsuarioEs>("/listar-asignaciones-usuarios-estudiantes", asignacionUsuarioEst);
		model.addAttribute("titulo", "Listado de Asignación de Usuarios Estudiantes");
		model.addAttribute("asignacionUsuarioEst", asignacionUsuarioEst);
		model.addAttribute("page", pageRender);
		return "AsignacionUsuarioEs/asignaciones-usuarios-est";
	}
	
	@RequestMapping(value = "/nueva-asignacion-usuario-estudiante", method = RequestMethod.GET)
	public String nuevaAsignacionUsuarioEs(Model model) {
		AsignacionUsuarioEs asignacionUsuarioEs = new AsignacionUsuarioEs();
		
		List<Estudiante> listaEstudiantes = estudianteService.listaEstudiantes();
		List<Usuario> listaUsuarios= asignacionUsuariosService.listaUsuarios();
		
		model.addAttribute("titulo", "Nueva Asignación Usuario Estudiante");
		model.addAttribute("asignacionUsuarioEs", asignacionUsuarioEs);
		model.addAttribute("estudiantes", listaEstudiantes);
		model.addAttribute("usuarios", listaUsuarios);
		return "AsignacionUsuarioEs/form-asignacion-usuario-es";
    }
	
	@RequestMapping(value = "/nueva-asignacion-usuario-estudiante", method = RequestMethod.POST)
	public String guardarAsignacionUsuarioEs(AsignacionUsuarioEs asignacionUsuarioEs) {
	
		asignacionUsuarioEsRepository.save(asignacionUsuarioEs);
		return "redirect:/listar-asignaciones-usuarios-estudiantes";
	}
	
	@RequestMapping(value = "/editar-asignacion-usuario-estudiante/{id}", method = RequestMethod.GET)
	public String editarAsignacionUsuarioEs(@PathVariable(value="id") Long id, Model model) {
		AsignacionUsuarioEs asignacionUsuarioEs = null;

		List<Estudiante> listaEstudiantes = estudianteService.listaEstudiantes();
		List<Usuario> listaUsuarios= asignacionUsuariosService.listaUsuarios();
	
		
		if (id>0) {
			asignacionUsuarioEs = asignacionUsuarioEsRepository.findById(id).get();
		}else {
			return "redirect:/listar-asignaciones-usuarios-administradores";
		}
		model.addAttribute("titulo", "Editar Asignación Usuario Estudiante");
		model.addAttribute("asignacionUsuarioEs", asignacionUsuarioEs);
		model.addAttribute("estudiantes", listaEstudiantes);
		model.addAttribute("usuarios", listaUsuarios);
		return "AsignacionUsuarioEs/form-asignacion-usuario-es";
	}
	
	
	@RequestMapping(value = "/eliminar-asignacion-usuario-estudiante/{id}", method = RequestMethod.GET)
	public String eliminarAsignacionUsuarioEs(@PathVariable(value="id") Long id, Model model) {
		AsignacionUsuarioEs asignacionUsuarioEs = null;
		if (id>0) {
			asignacionUsuarioEs = asignacionUsuarioEsRepository.findById(id).get();
			asignacionUsuarioEsRepository.delete(asignacionUsuarioEs);
		}else {
			return "redirect:/listar-asignaciones-usuarios-estudiantes";
		}
		
		return "redirect:/listar-asignaciones-usuarios-estudiantes";
	}

	

}
