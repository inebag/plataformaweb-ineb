package com.plataformawebproygraduacion.umg.app.controllers;

import java.util.ArrayList;
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
import com.plataformawebproygraduacion.umg.app.entities.Seccion;
import com.plataformawebproygraduacion.umg.app.repositories.GradoRepository;
import com.plataformawebproygraduacion.umg.app.service.CursoService;
import com.plataformawebproygraduacion.umg.app.service.SeccionService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class GradoController {
	
	@Autowired
	private GradoRepository gradoRepository;
	
	@Autowired
	private SeccionService seccionService;
	
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(value = "/detalle-grado/{idGrado}", method = RequestMethod.GET)
	public String detalleGrado(@PathVariable(value = "idGrado") Long id, Model model) {
		
		Grado grado = gradoRepository.findById(id).get();
		if(grado == null) {
			return "redirect:/listar-grados";			
		}
		
		model.addAttribute("titulo", "Detalle Grado: " + grado.getNgrado());
		model.addAttribute("grado", grado);
		return "Grado/detalle-grado-form"; 
	}
	
	@RequestMapping(value = "/listar-grados", method = RequestMethod.GET)
	public String listarGrados(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Grado> grados = gradoRepository.findAll(pageRequest);
		
		PageRender<Grado> pageRender = new PageRender<Grado>("/listar-grados", grados);
		model.addAttribute("titulo", "Listado de grados");
		model.addAttribute("grados", grados);
		model.addAttribute("page", pageRender);
		return "Grado/grados";
	}
	
	@RequestMapping(value = "/nuevo-grado", method = RequestMethod.GET)
	public String nuevoGrado(Model model) {
		Grado grado = new Grado();
		List<Seccion> listaSecciones = seccionService.listaSecciones();
		List<Curso> listaCursos = cursoService.listaCrusos();
		List<Curso> listCursos = new ArrayList<Curso>();
		
		listCursos.add(null);
		
		
		model.addAttribute("titulo", "Nuevo Grado");
		model.addAttribute("grado", grado);
		model.addAttribute("secciones", listaSecciones);
		model.addAttribute("cursos", listaCursos);
		model.addAttribute("listCursos", listCursos);
		return "Grado/form-grado";
    }
	
	@RequestMapping(value = "/editar-grado/{idGrado}", method = RequestMethod.GET)
	public String editarGrado(@PathVariable(value="idGrado") Long idGrado, Model model) {
		Grado grado = null;
		List<Seccion> listaSecciones = seccionService.listaSecciones();
		List<Curso> listaCursos = cursoService.listaCrusos();
		if (idGrado>0) {
			grado = gradoRepository.findById(idGrado).get();
		}else {
			return "redirect:/listar-grados";
		}
		model.addAttribute("titulo", "Editar Grado");
		model.addAttribute("grado", grado);
		model.addAttribute("secciones", listaSecciones);
		model.addAttribute("cursos", listaCursos);
		return "Grado/form-grado";
	}
	
	@RequestMapping(value = "/eliminar-grado/{idGrado}", method = RequestMethod.GET)
	public String eliminarGrado(@PathVariable(value="idGrado") Long idGrado, Model model) {
		Grado grado = null;
		if (idGrado>0) {
			grado = gradoRepository.findById(idGrado).get();
			gradoRepository.delete(grado);
		}else {
			return "redirect:/listar-grados";
		}
		
		return "redirect:/listar-grados";
	}
	
	@RequestMapping(value = "/nuevo-grado", method = RequestMethod.POST)
	public String guardarGenero(Grado grado) {
		

		
		gradoRepository.save(grado);
		return "redirect:/listar-grados";
	}
	
	
	
	

}
