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


import com.plataformawebproygraduacion.umg.app.entities.TipoEstudiante;
import com.plataformawebproygraduacion.umg.app.repositories.TipoEstudianteRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class TipoEstudianteController {
	
	@Autowired
	private TipoEstudianteRepository tipoEstudianteRepository;
	
	@RequestMapping(value = "/detalle-tipo-estudiante/{idTipoEstudiante}", method = RequestMethod.GET)
	public String detalleTipoEstudiante(@PathVariable(value = "idTipoEstudiante") Long idTipoEstudiante, Model model) {
		
		TipoEstudiante tipoEstudiante = tipoEstudianteRepository.findById(idTipoEstudiante).get();
		if(tipoEstudiante == null) {
			return "redirect:/listar-tipo-estudiante";			
		}
		
		model.addAttribute("titulo", "Detalle Genero: " + tipoEstudiante.getNtipoEstudiante());
		model.addAttribute("tipoEstudiante", tipoEstudiante);
		return "detalle-tipoestudiante-form"; 
	}
	
	
	@RequestMapping(value = "/listar-tipos-estudiantes", method = RequestMethod.GET)
	public String listarTiposEstudiantes(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<TipoEstudiante> tiposEstudiantes = tipoEstudianteRepository.findAll(pageRequest);
		
		PageRender<TipoEstudiante> pageRender = new PageRender<TipoEstudiante>("/listar-tipos-estudiantes", tiposEstudiantes);
		model.addAttribute("titulo", "Listado de Tipo Estudiantes");
		model.addAttribute("tiposEstudiantes", tiposEstudiantes);
		model.addAttribute("page", pageRender);
		return "tiposEstudiantes";
	}
	
	@RequestMapping(value = "/nuevo-tipo-estudiante", method = RequestMethod.GET)
	public String nuevoTipoEstudiante(Model model) {
		TipoEstudiante tipoEstudiante = new TipoEstudiante();
		model.addAttribute("titulo", "Nuevo Tipo Estudiante");
		model.addAttribute("tipoEstudiante", tipoEstudiante);
		return "form-tipo-estudiante";
    }
	
	@RequestMapping(value = "/editar-tipo-estudiante/{idTipoEstudiante}", method = RequestMethod.GET)
	public String editarTipoEstudiante(@PathVariable(value="idTipoEstudiante") Long idTipoEstudiante, Model model) {
		TipoEstudiante tipoEstudiante = null;
		if (idTipoEstudiante>0) {
			tipoEstudiante = tipoEstudianteRepository.findById(idTipoEstudiante).get();
		}else {
			return "redirect:/listar-tipos-estudiantes";
		}
		model.addAttribute("titulo", "Editar Tipo Estudiante");
		model.addAttribute("tipoEstudiante", tipoEstudiante);
		return "form-tipo-estudiante";
	}
	
	@RequestMapping(value = "/eliminar-tipo-estudiante/{idTipoEstudiante}", method = RequestMethod.GET)
	public String eliminarTipoEstudiante(@PathVariable(value="idTipoEstudiante") Long idTipoEstudiante, Model model) {
		TipoEstudiante tipoEstudiante= null;
		if (idTipoEstudiante>0) {
			tipoEstudiante = tipoEstudianteRepository.findById(idTipoEstudiante).get();
			tipoEstudianteRepository.delete(tipoEstudiante);
		}else {
			return "redirect:/listar-tipos-estudiantes";
		}
		
		return "redirect:/listar-tipos-estudiantes";
	}
	
	@RequestMapping(value = "/nuevo-tipo-estudiante", method = RequestMethod.POST)
	public String guardarTipoEstudiante(TipoEstudiante tipoEstudiante) {
		
		/*
		Audit audit = null;
		
		
		if (genero.getId()!=null && genero.getId() >0) {
			Genero genero2 = generoRepository.findById(genero.getId()).get();
			audit = new Audit("ADMIN");
			genero.setAudit(audit);
			genero.setId(genero2.getId());
			genero.getAudit().setTsCreated(genero2.getAudit().getTsCreated());
			genero.getAudit().setUsuCreated(genero2.getAudit().getUsuCreated()); 
		}
		else {
			audit = new Audit("ADMIN");
			genero.setAudit(audit);
		}
		*/
		
		tipoEstudianteRepository.save(tipoEstudiante);
		return "redirect:/listar-tipos-estudiantes";
	}
	
	

}
