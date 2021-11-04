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

import com.plataformawebproygraduacion.umg.app.entities.Curso;

import com.plataformawebproygraduacion.umg.app.entities.Grado;
import com.plataformawebproygraduacion.umg.app.entities.GradoCurso;

import com.plataformawebproygraduacion.umg.app.repositories.GradoCursoRepository;
import com.plataformawebproygraduacion.umg.app.service.CursoService;
import com.plataformawebproygraduacion.umg.app.service.GradoService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class GradoCursoController {
	
	@Autowired
	private GradoCursoRepository gradoCursoRepository;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private GradoService gradoService;
	
	@RequestMapping(value = "/listar-grados-cursos", method = RequestMethod.GET)
	public String listarGradosCursos(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<GradoCurso> gradosCursos = gradoCursoRepository.findAll(pageRequest);
		
		PageRender<GradoCurso> pageRender = new PageRender<GradoCurso>("/listar-grados-cursos", gradosCursos);
		model.addAttribute("titulo", "Listado de generos");
		model.addAttribute("gradosCursos", gradosCursos);
		model.addAttribute("page", pageRender);
		return "GradoCurso/grados-cursos";
	}
	
	
	@RequestMapping(value = "/nuevo-grado-curso", method = RequestMethod.GET)
	public String nuevoGradoCurso(Model model) {
		GradoCurso gradoCurso = new GradoCurso();
		
		List<Curso> listaCursos = cursoService.listaCrusos();
		List<Grado> listaGrados = gradoService.listaGrados();
				
		model.addAttribute("titulo", "Nuevo Grado - Curso");
		model.addAttribute("gradoCurso", gradoCurso);
		model.addAttribute("cursos", listaCursos);
		model.addAttribute("grados", listaGrados);

		return "GradoCurso/form-grado-curso";
    }
	
	@RequestMapping(value = "/nuevo-grado-curso", method = RequestMethod.POST)
	public String guardarGradoCurso(GradoCurso gradoCurso) {
		
		gradoCursoRepository.save(gradoCurso);
		return "redirect:/listar-grados-cursos";
	}
	
	@RequestMapping(value = "/editar-grado-curso/{id}", method = RequestMethod.GET)
	public String editarEstudiante(@PathVariable(value="id") Long id, Model model) {
		GradoCurso gradoCurso = null;
		List<Curso> listaCursos = cursoService.listaCrusos();
		List<Grado> listaGrados = gradoService.listaGrados();		
		if (id>0) {
			gradoCurso = gradoCursoRepository.findById(id).get();
		}else {
			return "redirect:/listar-grados-cursos";
		}
		model.addAttribute("titulo", "Editar Grado - Curso");
		model.addAttribute("gradoCurso", gradoCurso);
		model.addAttribute("cursos", listaCursos);
		model.addAttribute("grados", listaGrados);
		return "GradoCurso/form-grado-curso";
	}
	
	@RequestMapping(value = "/eliminar-grado-curso/{id}", method = RequestMethod.GET)
	public String eliminarEstudiante(@PathVariable(value="id") Long id, Model model) {
		GradoCurso gradoCurso = null;
		if (id>0) {
			gradoCurso = gradoCursoRepository.findById(id).get();
			gradoCursoRepository.delete(gradoCurso);
		}else {
			return "redirect:/listar-grados-cursos";
		}
		
		return "redirect:/listar-grados-cursos";
	}
	

}
