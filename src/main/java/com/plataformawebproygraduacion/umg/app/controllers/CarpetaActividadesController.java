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

import com.plataformawebproygraduacion.umg.app.entities.CarpetaActividades;
import com.plataformawebproygraduacion.umg.app.repositories.CarpetaActividadesRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class CarpetaActividadesController {
	
	@Autowired
	private CarpetaActividadesRepository carpetaActividadesRepository;

	@RequestMapping(value = "/detalle-carpeta-actividades/{idCarpetaActividad}", method = RequestMethod.GET)
	public String detalleCarpetaActividades(@PathVariable(value = "idCarpetaActividad") Long id, Model model) {
		
		CarpetaActividades carpetaActividad = carpetaActividadesRepository.findById(id).get();
		if(carpetaActividad == null) {
			return "redirect:/listar-carpetas-actividades";			
		}
		
		model.addAttribute("titulo", "Detalle Carpeta Actividates: " + carpetaActividad.getNombreCarpetaActividad());
		model.addAttribute("carpetaActividad", carpetaActividad);
		return "CarpetaActividades/detalle-carpeta-actividades-form"; 
	}
	
	@RequestMapping(value = "/listar-carpeta-actividades", method = RequestMethod.GET)
	public String listarCarpetaActividades(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<CarpetaActividades> carpetaActividades = carpetaActividadesRepository.findAll(pageRequest);
		
		PageRender<CarpetaActividades> pageRender = new PageRender<CarpetaActividades>("/listar-carpeta-actividades", carpetaActividades);
		model.addAttribute("titulo", "Listado de Carpetas de Actividades");
		model.addAttribute("carpetaActividades", carpetaActividades);
		model.addAttribute("page", pageRender);
		return "CarpetaActividades/carpeta-actividades";
	}
	
	@RequestMapping(value = "/nueva-carpeta-actividades", method = RequestMethod.GET)
	public String nuevoCarpetaActividades(Model model) {
		CarpetaActividades carpetaActividad = new CarpetaActividades();
		model.addAttribute("titulo", "Nueva Carpeta de Actividades");
		model.addAttribute("carpetaActividad", carpetaActividad);
		return "CarpetaActividades/form-carpeta-actividades";
    }
	
	@RequestMapping(value = "/nueva-carpeta-actividades", method = RequestMethod.POST)
	public String guardarCarpetaActividades(CarpetaActividades carpetaActividad) {

		carpetaActividadesRepository.save(carpetaActividad);
		return "redirect:/listar-carpeta-actividades";
	}
	
	@RequestMapping(value = "/editar-carpeta-actividades/{idCarpetaActividad}", method = RequestMethod.GET)
	public String editarCarpetaActividades(@PathVariable(value="idCarpetaActividad") Long idCarpetaActividad, Model model) {
		CarpetaActividades carpetaActividad = null;
		if (idCarpetaActividad>0) {
			carpetaActividad = carpetaActividadesRepository.findById(idCarpetaActividad).get();
		}else {
			return "redirect:/listar-generos";
		}
		model.addAttribute("titulo", "Editar Carpeta de Actividad");
		model.addAttribute("carpetaActividad", carpetaActividad);
		return "CarpetaActividades/form-carpeta-actividades";
	}
	
	@RequestMapping(value = "/eliminar-carpeta-actividad/{idCarpetaActividad}", method = RequestMethod.GET)
	public String eliminarGenero(@PathVariable(value="idCarpetaActividad") Long idCarpetaActividad, Model model) {
		CarpetaActividades carpetaActividad= null;
		if (idCarpetaActividad>0) {
			carpetaActividad = carpetaActividadesRepository.findById(idCarpetaActividad).get();
			carpetaActividadesRepository.delete(carpetaActividad);
		}else {
			return "redirect:/listar-carpeta-actividades";
		}
		
		return "redirect:/listar-carpeta-actividades";
	}
	
	
}
