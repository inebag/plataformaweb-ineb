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
import com.plataformawebproygraduacion.umg.app.entities.Actividades;
import com.plataformawebproygraduacion.umg.app.entities.Bimestre;
import com.plataformawebproygraduacion.umg.app.entities.CarpetaActividades;
import com.plataformawebproygraduacion.umg.app.entities.Curso;
import com.plataformawebproygraduacion.umg.app.repositories.ActividadesRepository;
import com.plataformawebproygraduacion.umg.app.service.BimestreService;
import com.plataformawebproygraduacion.umg.app.service.CarpetaActividadesService;
import com.plataformawebproygraduacion.umg.app.service.CursoService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class ActividadesController {
	
	@Autowired
	private ActividadesRepository actividadesRepository;
	
	@Autowired
	private BimestreService bimestreService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private CarpetaActividadesService carpetaActividadesService;
	
	@RequestMapping(value = "/listar-actividades", method = RequestMethod.GET)
	public String listarActividades(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Actividades> actividades = actividadesRepository.findAll(pageRequest);
		
		PageRender<Actividades> pageRender = new PageRender<Actividades>("/listar-actividades", actividades);
		model.addAttribute("titulo", "Listado de Actividades");
		model.addAttribute("actividades", actividades);
		model.addAttribute("page", pageRender);
		return "Actividades/actividades";
	}
	
	@RequestMapping(value = "/detalle-actividades/{idActividad}", method = RequestMethod.GET)
	public String detalleActividad(@PathVariable(value = "idActividad") Long id, Model model) {
		
		Actividades actividad = actividadesRepository.findById(id).get();
		if(actividad == null) {
			return "redirect:/listar-actividades";			
		}
		 
		model.addAttribute("titulo", "Detalle Actividad: " + actividad.getDesc());
		model.addAttribute("actividad", actividad);
		return "Actividades/detalle-actividad-form"; 
	}
	
	@RequestMapping(value = "/nueva-actividad", method = RequestMethod.GET)
	public String nuevaActividad(Model model) {
		Actividades actividad = new Actividades();
		
		List<Curso> listaCrusos = cursoService.listaCrusos();
		List<Bimestre> listaBimestres = bimestreService.listaBimestres();
		List<CarpetaActividades> listaCarpetaActvidades = carpetaActividadesService.listaCarpetaActividades();
		
		model.addAttribute("titulo", "Nueva Actividad");
		model.addAttribute("actividad", actividad);
		model.addAttribute("cursos", listaCrusos);
		model.addAttribute("bimestres", listaBimestres);
		model.addAttribute("carpetaActividades", listaCarpetaActvidades);
		return "Actividades/form-actividad";
    }
	
	@RequestMapping(value = "/nueva-actividad", method = RequestMethod.POST)
	public String guardarActividad(Actividades actividad) {

		actividadesRepository.save(actividad);
		return "redirect:/listar-actividades";
	}
	
	@RequestMapping(value = "/editar-actividad/{idActividad}", method = RequestMethod.GET)
	public String editarActividad(@PathVariable(value="idActividad") Long idActividad, Model model) {
		Actividades actividad = null;
		
		List<Curso> listaCrusos = cursoService.listaCrusos();
		List<Bimestre> listaBimestres = bimestreService.listaBimestres();
		List<CarpetaActividades> listaCarpetaActvidades = carpetaActividadesService.listaCarpetaActividades();
		
		if (idActividad>0) {
			actividad = actividadesRepository.findById(idActividad).get();
		}else {
			return "redirect:/listar-actividades";
		}
		model.addAttribute("titulo", "Editar Actividad");
		model.addAttribute("actividad", actividad);
		model.addAttribute("cursos", listaCrusos);
		model.addAttribute("bimestres", listaBimestres);
		model.addAttribute("carpetaActividades", listaCarpetaActvidades);
		return "Actividades/form-actividad";
	}
	
	@RequestMapping(value = "/eliminar-actividad/{idActividad}", method = RequestMethod.GET)
	public String eliminarActividad(@PathVariable(value="idActividad") Long idActividad, Model model) {
		Actividades actividad = null;
		if (idActividad>0) {
			actividad = actividadesRepository.findById(idActividad).get();
			actividadesRepository.delete(actividad);
		}else {
			return "redirect:/listar-actividades";
		}
		
		return "redirect:/listar-actividades";
	}
	
}
