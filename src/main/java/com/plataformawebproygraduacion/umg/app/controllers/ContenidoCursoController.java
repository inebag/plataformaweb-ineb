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

import com.plataformawebproygraduacion.umg.app.entities.CarpetaCurso;
import com.plataformawebproygraduacion.umg.app.entities.ContenidoCurso;
import com.plataformawebproygraduacion.umg.app.entities.Curso;

import com.plataformawebproygraduacion.umg.app.repositories.ContenidoCursoRepository;
import com.plataformawebproygraduacion.umg.app.service.CarpetaCursoService;
import com.plataformawebproygraduacion.umg.app.service.CursoService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class ContenidoCursoController {
	
	@Autowired
	private ContenidoCursoRepository contenidoCursoRepository;
	
	@Autowired
	private CarpetaCursoService carpetaCursoService;
	
	@Autowired 
	private CursoService cursoService;
	
	@RequestMapping(value = "/detalle-contenido-curso/{idContenidoCurso}", method = RequestMethod.GET)
	public String detalleContenidoCurso(@PathVariable(value = "idContenidoCurso") Long id, Model model) {
		
		ContenidoCurso contenidoCurso = contenidoCursoRepository.findById(id).get();
		if(contenidoCurso == null) {
			return "redirect:/listar-contenido-cursos";			
		}
		
		model.addAttribute("titulo", "Detalle Material de Aprendizaje");
		model.addAttribute("contenidoCurso", contenidoCurso);
		return "ContenidoCurso/detalle-contenido-curso-form"; 
	}
	
	@RequestMapping(value = "/listar-contenido-cursos", method = RequestMethod.GET)
	public String listarContenidoCurso(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<ContenidoCurso> contenidoCursos = contenidoCursoRepository.findAll(pageRequest);
		
		PageRender<ContenidoCurso> pageRender = new PageRender<ContenidoCurso>("/listar-contenido-cursos", contenidoCursos);
		model.addAttribute("titulo", "Material de Aprendizaje");
		model.addAttribute("contenidoCursos", contenidoCursos);
		model.addAttribute("page", pageRender);
		return "ContenidoCurso/contenido-cursos";
	}
	
	@RequestMapping(value = "/nuevo-contenido-curso", method = RequestMethod.GET)
	public String nuevoContenidoCurso(Model model) {
		ContenidoCurso contenidoCurso = new ContenidoCurso();
		
		List<Curso> listaCursos = cursoService.listaCrusos();
		List<CarpetaCurso> listaCarpetaCursos = carpetaCursoService.listaCarpetaCurso();
		
		
		model.addAttribute("titulo", "Nuevo Material de Aprendizaje");
		model.addAttribute("contenidoCurso", contenidoCurso);
		model.addAttribute("cursos", listaCursos);	
		model.addAttribute("carpetaCursos", listaCarpetaCursos);
		return "ContenidoCurso/form-contenido-curso";
    }
	
	
	@RequestMapping(value = "/nuevo-contenido-curso", method = RequestMethod.POST)
	public String guardarContenidoCurso(ContenidoCurso contenidoCurso) {

		contenidoCursoRepository.save(contenidoCurso);
		return "redirect:/listar-contenido-cursos";
	}
	
	@RequestMapping(value = "/editar-contenido-curso/{idContenidoCurso}", method = RequestMethod.GET)
	public String editarContenidoCurso(@PathVariable(value="idContenidoCurso") Long idContenidoCurso, Model model) {
		ContenidoCurso contenidoCurso = null;
		List<Curso> listaCursos = cursoService.listaCrusos();
		List<CarpetaCurso> listaCarpetaCursos = carpetaCursoService.listaCarpetaCurso();
		
		
		if (idContenidoCurso>0) {
			contenidoCurso = contenidoCursoRepository.findById(idContenidoCurso).get();
		}else {
			return "redirect:/listar-contenido-cursos";
		}
		model.addAttribute("titulo", "Editar Material de Aprendizaje");
		model.addAttribute("contenidoCurso", contenidoCurso);
		model.addAttribute("cursos", listaCursos);	
		model.addAttribute("carpetaCursos", listaCarpetaCursos);
		
		return "ContenidoCurso/form-contenido-curso";
	}
	
	@RequestMapping(value = "/eliminar-genero/{idContenidoCurso}", method = RequestMethod.GET)
	public String eliminarContenidoCurso(@PathVariable(value="idContenidoCurso") Long idContenidoCurso, Model model) {
		ContenidoCurso contenidoCurso = null;
		if (idContenidoCurso>0) {
			contenidoCurso = contenidoCursoRepository.findById(idContenidoCurso).get();
			contenidoCursoRepository.delete(contenidoCurso);
		}else {
			return "redirect:/listar-contenido-cursos";
		}
		
		return "redirect:/listar-contenido-cursos";
	}
	
}
