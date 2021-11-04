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

import com.plataformawebproygraduacion.umg.app.entities.AsignacionGradoE;
import com.plataformawebproygraduacion.umg.app.entities.Curso;
import com.plataformawebproygraduacion.umg.app.entities.Estudiante;
import com.plataformawebproygraduacion.umg.app.entities.Grado;
import com.plataformawebproygraduacion.umg.app.repositories.AsignacionGradoERepository;
import com.plataformawebproygraduacion.umg.app.service.EstudianteService;
import com.plataformawebproygraduacion.umg.app.service.GradoService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class AsignacionGradoEsController {
	
	@Autowired
	private AsignacionGradoERepository AsignacionGradoERepository;

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private GradoService gradoService;
	
	@RequestMapping(value = "/detalle-asignacion-grado-estudiante/{idAsignacionGradoE}", method = RequestMethod.GET)
	public String detalleAsignacionGradoE(@PathVariable(value = "idAsignacionGradoE") Long id, Model model) {
		
		AsignacionGradoE asignacionGradoE = AsignacionGradoERepository.findById(id).get();
		
		if(asignacionGradoE == null) {
			return "redirect:/listar-asignaciones-grados-estudiantes";			
		}
		
		model.addAttribute("titulo", "Detalle Asignación Grado: " + asignacionGradoE.getIdAsignacionGradoE());
		model.addAttribute("asignacionGradoE", asignacionGradoE);
		return "AsignacionGradoE/detalle-asignacion-grado-form"; 
	}
	
	@RequestMapping(value = "/listar-asignaciones-grados-estudiantes", method = RequestMethod.GET)
	public String listarAsignacionGrado(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<AsignacionGradoE> asignacionGrados = AsignacionGradoERepository.findAll(pageRequest);
		
		PageRender<AsignacionGradoE> pageRender = new PageRender<AsignacionGradoE>("/listar-asignaciones-grados-estudiantes", asignacionGrados);
		model.addAttribute("titulo", "Listado de Asignación de Grados");
		model.addAttribute("asignacionGrados", asignacionGrados);
		model.addAttribute("page", pageRender);
		return "AsignacionGradoE/asignaciones-grados";
	}
	
	@RequestMapping(value = "/nueva-asignacion-grado", method = RequestMethod.GET)
	public String nuevaAsignacionGrado(Model model) {
		AsignacionGradoE asignacionGradoE = new AsignacionGradoE();
		List<Grado> listaGrados = gradoService.listaGrados();
		List<Estudiante> listaEstudiantes = estudianteService.listaEstudiantes();
		
		model.addAttribute("titulo", "Nueva Asignación Grado");
		model.addAttribute("asignacionGradoE", asignacionGradoE);
		model.addAttribute("grados", listaGrados);
		model.addAttribute("estudiantes", listaEstudiantes);
		return "AsignacionGradoE/form-asignacion-grado";
    }
	
	@RequestMapping(value = "/nueva-asignacion-grado", method = RequestMethod.POST)
	public String guardarAsignacionGrado(AsignacionGradoE asignacionGradoE) {
	
		AsignacionGradoERepository.save(asignacionGradoE);
		return "redirect:/listar-asignaciones-grados-estudiantes";
	}
	
	@RequestMapping(value = "/editar-asignacion-grado-estudiante/{idAsignacionGradoE}", method = RequestMethod.GET)
	public String editarAsignacionGrado(@PathVariable(value="idAsignacionGradoE") Long idAsignacionGradoE, Model model) {
		AsignacionGradoE asignacionGradoE = null;
		List<Grado> listaGrados = gradoService.listaGrados();
		List<Estudiante> listaEstudiantes = estudianteService.listaEstudiantes();
	
		
		if (idAsignacionGradoE>0) {
			asignacionGradoE = AsignacionGradoERepository.findById(idAsignacionGradoE).get();
		}else {
			return "redirect:/listar-asignaciones-grados-estudiantes";
		}
		model.addAttribute("titulo", "Editar Asignación Grado");
		model.addAttribute("asignacionGradoE", asignacionGradoE);
		model.addAttribute("grados", listaGrados);
		model.addAttribute("estudiantes", listaEstudiantes);
		return "AsignacionGradoE/form-asignacion-grado";
	}
	
	
	@RequestMapping(value = "/eliminar-asignacion-grado/{idAsignacionGradoE}", method = RequestMethod.GET)
	public String eliminarCurso(@PathVariable(value="idAsignacionGradoE") Long idAsignacionGradoE, Model model) {
		AsignacionGradoE asignacionGradoE = null;
		if (idAsignacionGradoE>0) {
			asignacionGradoE = AsignacionGradoERepository.findById(idAsignacionGradoE).get();
			AsignacionGradoERepository.delete(asignacionGradoE);
		}else {
			return "redirect:/listar-asignaciones-grados-estudiantes";
		}
		
		return "redirect:/listar-asignaciones-grados-estudiantes";
	}
	

}
