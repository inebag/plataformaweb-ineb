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

import com.plataformawebproygraduacion.umg.app.entities.Curso;
import com.plataformawebproygraduacion.umg.app.repositories.CursoRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@RequestMapping(value = "/detalle-curso/{idCurso}", method = RequestMethod.GET)
	public String detalleCurso(@PathVariable(value = "idCurso") Long id, Model model) {
		
		Curso curso = cursoRepository.findById(id).get();
		if(curso == null) {
			return "redirect:/listar-cursos";			
		}
		
		model.addAttribute("titulo", "Detalle Curso: " + curso.getCodigoEspecialidad());
		model.addAttribute("curso", curso);
		return "Curso/detalle-curso-form"; 
	}
	@RequestMapping(value = "/listar-cursos", method = RequestMethod.GET)
	public String listarCurso(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Curso> cursos = cursoRepository.findAll(pageRequest);
		
		PageRender<Curso> pageRender = new PageRender<Curso>("/listar-cursos", cursos);
		model.addAttribute("titulo", "Listado de cursos");
		model.addAttribute("cursos", cursos);
		model.addAttribute("page", pageRender);
		return "Curso/cursos";
	}
	
	@RequestMapping(value = "/nuevo-curso", method = RequestMethod.GET)
	public String nuevoCurso(Model model) {
		Curso curso = new Curso();
		model.addAttribute("titulo", "Nuevo Curso");
		model.addAttribute("curso", curso);
		return "Curso/form-curso";
    }
	
	@RequestMapping(value = "/editar-curso/{idCurso}", method = RequestMethod.GET)
	public String editarCurso(@PathVariable(value="idCurso") Long idCurso, Model model) {
		Curso curso = null;
		if (idCurso>0) {
			curso = cursoRepository.findById(idCurso).get();
		}else {
			return "redirect:/listar-cursos";
		}
		model.addAttribute("titulo", "Editar Curso");
		model.addAttribute("curso", curso);
		return "Curso/form-curso";
	}
	
	@RequestMapping(value = "/eliminar-curso/{idCurso}", method = RequestMethod.GET)
	public String eliminarCurso(@PathVariable(value="idCurso") Long idCurso, Model model) {
		Curso curso = null;
		if (idCurso>0) {
			curso = cursoRepository.findById(idCurso).get();
			cursoRepository.delete(curso);
		}else {
			return "redirect:/listar-cursos";
		}
		
		return "redirect:/listar-cursos";
	}
	
	@RequestMapping(value = "/nuevo-curso", method = RequestMethod.POST)
	public String guardarCurso(Curso curso) {
		

		
		cursoRepository.save(curso);
		return "redirect:/listar-cursos";
	}
	

}
