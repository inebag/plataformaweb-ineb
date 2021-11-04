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
import com.plataformawebproygraduacion.umg.app.entities.Seccion;
import com.plataformawebproygraduacion.umg.app.repositories.SeccionRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class SeccionController {
	@Autowired
	private SeccionRepository seccionRepository;

	@RequestMapping(value = "/detalle-seccion/{idSeccion}", method = RequestMethod.GET)
	public String detalleSeccion(@PathVariable(value = "idSeccion") Long id, Model model) {
		
		Seccion seccion = seccionRepository.findById(id).get();
		if(seccion == null) {
			return "redirect:/listar-seccion";			
		}
		
		model.addAttribute("titulo", "Detalle Seccion: " + seccion.getNseccion());
		model.addAttribute("seccion", seccion);
		return "Seccion/detalle-seccion-form"; 
	}
	
	@RequestMapping(value = "/listar-secciones", method = RequestMethod.GET)
	public String listarSeccion(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Seccion> secciones = seccionRepository.findAll(pageRequest);
		
		PageRender<Seccion> pageRender = new PageRender<Seccion>("/listar-secciones", secciones);
		model.addAttribute("titulo", "Listado de Secciones");
		model.addAttribute("secciones", secciones);
		model.addAttribute("page", pageRender);
		return "Seccion/secciones";
	}
	

	@RequestMapping(value = "/nueva-seccion", method = RequestMethod.GET)
	public String nuevoSeccion(Model model) {
		Seccion seccion = new Seccion();
		model.addAttribute("titulo", "Nueva Sección");
		model.addAttribute("seccion", seccion);
		return "Seccion/form-seccion";
    }
	
	@RequestMapping(value = "/editar-seccion/{idSeccion}", method = RequestMethod.GET)
	public String editarSeccion(@PathVariable(value="idSeccion") Long idSeccion, Model model) {
		Seccion seccion = null;
		if (idSeccion>0) {
			seccion = seccionRepository.findById(idSeccion).get();
		}else {
			return "redirect:/listar-secciones";
		}
		model.addAttribute("titulo", "Editar Sección");
		model.addAttribute("seccion", seccion);
		return "Seccion/form-seccion";
	}
	
	@RequestMapping(value = "/eliminar-seccion/{idSeccion}", method = RequestMethod.GET)
	public String eliminarSeccion(@PathVariable(value="idSeccion") Long idSeccion, Model model) {
		Seccion seccion = null;
		if (idSeccion>0) {
			seccion = seccionRepository.findById(idSeccion).get();
			seccionRepository.delete(seccion);
		}else {
			return "redirect:/listar-secciones";
		}
		
		return "redirect:/listar-secciones";
	}
	
	@RequestMapping(value = "/nueva-seccion", method = RequestMethod.POST)
	public String guardarSeccion(Seccion seccion) {
		
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
		
		seccionRepository.save(seccion);
		return "redirect:/listar-secciones";
	}
	


}
