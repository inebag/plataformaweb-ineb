package com.plataformawebproygraduacion.umg.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.plataformawebproygraduacion.umg.app.entities.Estudiante;
import com.plataformawebproygraduacion.umg.app.entities.Genero;
import com.plataformawebproygraduacion.umg.app.entities.TipoEstudiante;
import com.plataformawebproygraduacion.umg.app.repositories.EstudianteRepository;
import com.plataformawebproygraduacion.umg.app.servb.IEstudianteSer;
import com.plataformawebproygraduacion.umg.app.service.GeneroService;
import com.plataformawebproygraduacion.umg.app.service.TipoEstudianteService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class EstudianteController {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private TipoEstudianteService tipoEstudianteService;
	
	@Autowired
	private IEstudianteSer estudianteSer;
	

	@RequestMapping(value = "/detalle-estudiante/{idEstudiante}", method = RequestMethod.GET)
	public String detalleEstudainte(@PathVariable(value = "idEstudiante") Long id, Model model) {
		
		Estudiante estudiante = estudianteRepository.findById(id).get();
		if(estudiante == null) {
			return "redirect:/listar-estudiantes";			
		}
		
		model.addAttribute("titulo", "Detalle Estudiante: " + estudiante.getNombresEstudiante() +" "+ estudiante.getApellidosEstudiante());
		model.addAttribute("estudiante", estudiante);
		return "Estudiante/detalle-estudiante-form"; 
	}


	@RequestMapping(value = "/listar-estudiantes", method = RequestMethod.GET)
	public String listarEstudiantes(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Estudiante> estudiantes = estudianteRepository.findAll(pageRequest);
		
		PageRender<Estudiante> pageRender = new PageRender<Estudiante>("/listar-estudiantes", estudiantes);
		model.addAttribute("titulo", "Listado de Estudiantes");
		model.addAttribute("estudiantes", estudiantes);
		model.addAttribute("page", pageRender);
		return "Estudiante/estudiantes";
	}
	
	@RequestMapping(value = "/nuevo-estudiante", method = RequestMethod.GET)
	public String nuevoEstudiante(Model model) {
		Estudiante estudiante = new Estudiante();
		List<Genero> listaGeneros = generoService.listaGeneros();
		List<TipoEstudiante> listaTiposEstudiante = tipoEstudianteService.listaTiposEstudiante();
				
		model.addAttribute("titulo", "Nuevo Estudiante");
		model.addAttribute("estudiante", estudiante);
		model.addAttribute("generos", listaGeneros);
		model.addAttribute("tiposEstudiante", listaTiposEstudiante);
		return "Estudiante/form-estudiante";
    }
	
	@RequestMapping(value = "/nuevo-estudiante", method = RequestMethod.POST)
	public String guardarEstudiante(Estudiante estudiante) {
		
		estudianteRepository.save(estudiante);
		return "redirect:/listar-estudiantes";
	}
	
	@RequestMapping(value = "/editar-estudiante/{idEstudiante}", method = RequestMethod.GET)
	public String editarEstudiante(@PathVariable(value="idEstudiante") Long idEstudiante, Model model) {
		Estudiante estudiante = null;
		List<Genero> listaGeneros = generoService.listaGeneros();
		List<TipoEstudiante> listaTiposEstudiante = tipoEstudianteService.listaTiposEstudiante();
		
		if (idEstudiante>0) {
			estudiante = estudianteRepository.findById(idEstudiante).get();
		}else {
			return "redirect:/listar-estudiantes";
		}
		model.addAttribute("titulo", "Editar Estudiante");
		model.addAttribute("estudiante", estudiante);
		model.addAttribute("generos", listaGeneros);
		model.addAttribute("tiposEstudiante", listaTiposEstudiante);
		return "Estudiante/form-estudiante";
	}
	
	@RequestMapping(value = "/eliminar-estudiante/{idEstudiante}", method = RequestMethod.GET)
	public String eliminarEstudiante(@PathVariable(value="idEstudiante") Long idEstudiante, Model model) {
		Estudiante estudiante = null;
		if (idEstudiante>0) {
			estudiante = estudianteRepository.findById(idEstudiante).get();
			estudianteRepository.delete(estudiante);
		}else {
			return "redirect:/listar-estudiantes";
		}
		
		return "redirect:/listar-estudiantes";
	}
	
	
	@GetMapping("/estudiantesB")
	public String BusquedaEstudiante(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "Estudiante/estudianteB";
		
	}
	
	
	@GetMapping("/nombresEstudiante")
	public String buscarEstudiante(@RequestParam String nombresEstudiante, Model model, @ModelAttribute("estudiante") Estudiante estudiante) {
		model.addAttribute("buscarEstudianteN", estudianteSer.buscarEstudianteN(nombresEstudiante));
		
		return "Estudiante/estudianteB";
	}
	
	
/*
	@RequestMapping(value = "/buscar-estudiante1", method = RequestMethod.GET)
	public String buscarEstudiante(@RequestParam String nombresEstudiante, Model model, @ModelAttribute("estudiante") Estudiante estudiante) {
		model.addAttribute("buscarEstudianteN", estudianteSer.buscarEstudianteN(nombresEstudiante));
		
		
		return "estudianteB";
	}

*/
	
	

}
