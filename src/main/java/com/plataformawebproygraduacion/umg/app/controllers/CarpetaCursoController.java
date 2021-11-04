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

import com.plataformawebproygraduacion.umg.app.entities.CarpetaCurso;
import com.plataformawebproygraduacion.umg.app.repositories.CarpetaCursoRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class CarpetaCursoController {

	@Autowired
	private CarpetaCursoRepository carpetaCursoRepository;
	
	@RequestMapping(value = "/detalle-carpeta-curso/{idCarpetaCurso}", method = RequestMethod.GET)
	public String detalleCarpetaCurso(@PathVariable(value = "idCarpetaCurso") Long id, Model model) {
		
		CarpetaCurso carpetaCurso = carpetaCursoRepository.findById(id).get();
		if(carpetaCurso == null) {
			return "redirect:/listar-carpeta-curso";			
		}
		
		model.addAttribute("titulo", "Detalle Carpeta Curso: " + carpetaCurso.getNombreCarpetaCurso());
		model.addAttribute("carpetaCurso", carpetaCurso);
		return "CarpetaCurso/detalle-carpeta-curso-form"; 
	}
	
	@RequestMapping(value = "/listar-carpeta-curso", method = RequestMethod.GET)
	public String listarCarpetaCruso(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<CarpetaCurso> carpetaCurso = carpetaCursoRepository.findAll(pageRequest);
		
		PageRender<CarpetaCurso> pageRender = new PageRender<CarpetaCurso>("/listar-carpeta-curso", carpetaCurso);
		model.addAttribute("titulo", "Listado de carpetas de cursos");
		model.addAttribute("carpetaCurso", carpetaCurso);
		model.addAttribute("page", pageRender);
		return "CarpetaCurso/carpeta-cursos"; 
	}
	
	@RequestMapping(value = "/nueva-carpeta-curso", method = RequestMethod.GET)
	public String nuevaCarpetaCruso(Model model) {
		CarpetaCurso carpetaCurso = new CarpetaCurso();
		model.addAttribute("titulo", "Nueva Carpeta de Curso");
		model.addAttribute("carpetaCurso", carpetaCurso);
		return "CarpetaCurso/form-carpeta-curso";
    }
	
	@RequestMapping(value = "/editar-carpeta-curso/{idCarpetaCurso}", method = RequestMethod.GET)
	public String editarCarpetaCurso(@PathVariable(value="idCarpetaCurso") Long idCarpetaCurso, Model model) {
		CarpetaCurso carpetaCurso = null;
		if (idCarpetaCurso>0) {
			carpetaCurso = carpetaCursoRepository.findById(idCarpetaCurso).get();
		}else {
			return "redirect:/listar-carpeta-cusrso";
		}
		model.addAttribute("titulo", "Editar Carpeta Curso");
		model.addAttribute("carpetaCurso", carpetaCurso);
		return "CarpetaCurso/form-carpeta-curso";
	}
	
	@RequestMapping(value = "/eliminar-carpeta-curso/{idCarpetaCurso}", method = RequestMethod.GET)
	public String eliminarCarpetaCurso(@PathVariable(value="idCarpetaCurso") Long idCarpetaCurso, Model model) {
		CarpetaCurso carpetaCurso = null;
		if (idCarpetaCurso>0) {
			carpetaCurso = carpetaCursoRepository.findById(idCarpetaCurso).get();
			carpetaCursoRepository.delete(carpetaCurso);
		}else {
			return "redirect:/listar-carpeta-curso";
		}
		
		
		return "redirect:/listar-carpeta-curso";
	}
	
	@RequestMapping(value = "/nueva-carpeta-curso", method = RequestMethod.POST)
	public String guardarCarpetaCurso(CarpetaCurso carpetaCurso) {
		
		
		carpetaCursoRepository.save(carpetaCurso);
		return "redirect:/listar-carpeta-curso";
	}
	
	
	
}
