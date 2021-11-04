package com.plataformawebproygraduacion.umg.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.plataformawebproygraduacion.umg.app.entities.Curso;
import com.plataformawebproygraduacion.umg.app.repositories.CursoRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class MisCursos {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	/*
	@GetMapping({"/mis-cursos-est"})
	public String Index() {
		return"MisCursos/mis-cursos-estudiante";
	}
	*/
	
	 
	@RequestMapping(value = "/portal-curso", method = RequestMethod.GET)
	public String listarCursoD(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Curso> cursos = cursoRepository.findAll(pageRequest);
		
		PageRender<Curso> pageRender = new PageRender<Curso>("/listar-cursos", cursos);
		model.addAttribute("titulo", "Mis Cursos");
		model.addAttribute("cursos", cursos);
		model.addAttribute("page", pageRender);
		return "MisCursos/portal-curso";
	}
	
	@RequestMapping(value = "/mis-cursos-estudiante{idEstudiante=1}", method = RequestMethod.GET)
	public String listarCursoE(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Curso> cursos = cursoRepository.findAll(pageRequest);
		
		PageRender<Curso> pageRender = new PageRender<Curso>("/listar-cursos", cursos);
		model.addAttribute("titulo", "Mis Cursos");
		model.addAttribute("cursos", cursos);
		model.addAttribute("page", pageRender);
		return "MisCursos/mis-cursos-estudiante";
	}

	
	//---CALIFICAICONES ESTUDIANTE --- //
	
	@RequestMapping(value = "/mis-calificaciones", method = RequestMethod.GET)
	public String misCalificaciones(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		model.addAttribute("titulo", "Mis Calificaciones");

		return "MisCalificaciones/mis-calificaciones";
	}
}
