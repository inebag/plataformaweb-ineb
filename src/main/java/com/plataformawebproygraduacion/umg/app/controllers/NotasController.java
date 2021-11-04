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


import com.plataformawebproygraduacion.umg.app.entities.Notas;

import com.plataformawebproygraduacion.umg.app.repositories.NotaRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class NotasController {
	@Autowired
	private NotaRepository notaRepository;
	
	@RequestMapping(value = "/detalle-nota/{id}", method = RequestMethod.GET)
	public String detalleNota(@PathVariable(value = "id") Long id, Model model) {
		
		Notas nota = notaRepository.findById(id).get();
		if(nota == null) {
			return "redirect:/listar-notas";			
		}
		
		model.addAttribute("titulo", "Detalle Nota: " + nota.getId());
		model.addAttribute("nota", nota);
		return "Nota/detalle-nota-form"; 
	}
	

	@RequestMapping(value = "/listar-notas", method = RequestMethod.GET)
	public String listarNotas(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
	
		Page<Notas> notas = notaRepository.findAll(pageRequest);
		
		PageRender<Notas> pageRender = new PageRender<Notas>("/listar-notas", notas);
		model.addAttribute("titulo", "Listado de Notas");
		model.addAttribute("notas", notas);
		model.addAttribute("page", pageRender);
		return "Nota/notas";
	}
	
	
	@RequestMapping(value = "/nueva-nota", method = RequestMethod.GET)
	public String nuevaNota(Model model) {
		Notas nota = new Notas();
		
		//List<Curso> listaCursos = cursoService.listaCrusos();
		//List<Grado> listaGrados = gradoService.listaGrados();
		//List<Docente> listaDocentes = docenteService.listaDocentes();
		model.addAttribute("titulo", "Nueva Nota");
		model.addAttribute("nota", nota);
		//model.addAttribute("cursos", listaCursos);
		//model.addAttribute("grados", listaGrados);
		//model.addAttribute("docentes", listaDocentes);
		
		return "Nota/form-nota";
    }
	
	@RequestMapping(value = "/nueva-nota", method = RequestMethod.POST)
	public String guardarNota(Notas nota) {
		
		notaRepository.save(nota);
		return "redirect:/listar-notas";
	}
	
	@RequestMapping(value = "/editar-nota/{id}", method = RequestMethod.GET)
	public String editarGrupo(@PathVariable(value="id") Long id, Model model) {
		Notas nota = null;
		
		//List<Curso> listaCursos = cursoService.listaCrusos();
		//List<Grado> listaGrados = gradoService.listaGrados();
		//List<Docente> listaDocentes = docenteService.listaDocentes();
		if (id>0) {
			nota = notaRepository.findById(id).get();
		}else {
			return "redirect:/listar-notas";
		}
		model.addAttribute("titulo", "Editar Nota");
		model.addAttribute("nota", nota);
		//model.addAttribute("cursos", listaCursos);
		//model.addAttribute("grados", listaGrados);
		//model.addAttribute("docentes", listaDocentes);
		return "Nota/form-nota";
	}
	
	@RequestMapping(value = "/eliminar-nota/{id}", method = RequestMethod.GET)
	public String eliminarGrupo(@PathVariable(value="id") Long id, Model model) {
		Notas nota = null;
		if (id>0) {
			nota = notaRepository.findById(id).get();
			notaRepository.delete(nota);
		}else {
			return "redirect:/listar-notas";
		}
		
		return "redirect:/listar-notas";
	}


}
