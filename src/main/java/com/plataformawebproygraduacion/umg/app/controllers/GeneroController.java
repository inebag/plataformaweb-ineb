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


import com.plataformawebproygraduacion.umg.app.entities.Genero;
import com.plataformawebproygraduacion.umg.app.repositories.GeneroRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class GeneroController {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@RequestMapping(value = "/detalle-genero/{idGenero}", method = RequestMethod.GET)
	public String detalleGenero(@PathVariable(value = "idGenero") Long id, Model model) {
		
		Genero genero = generoRepository.findById(id).get();
		if(genero == null) {
			return "redirect:/listar-generos";			
		}
		
		model.addAttribute("titulo", "Detalle Genero: " + genero.getNombreGenero());
		model.addAttribute("genero", genero);
		return "detalle-genero-form"; 
	}
	
	
	@RequestMapping(value = "/listar-generos", method = RequestMethod.GET)
	public String listarGeneros(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Genero> generos = generoRepository.findAll(pageRequest);
		
		PageRender<Genero> pageRender = new PageRender<Genero>("/listar-generos", generos);
		model.addAttribute("titulo", "Listado de generos");
		model.addAttribute("generos", generos);
		model.addAttribute("page", pageRender);
		return "generos";
	}
	
	@RequestMapping(value = "/nuevo-genero", method = RequestMethod.GET)
	public String nuevoGenero(Model model) {
		Genero genero = new Genero();
		model.addAttribute("titulo", "Nuevo Genero");
		model.addAttribute("genero", genero);
		return "form-genero";
    }
	
	@RequestMapping(value = "/editar-genero/{idGenero}", method = RequestMethod.GET)
	public String editarGenero(@PathVariable(value="idGenero") Long id, Model model) {
		Genero genero = null;
		if (id>0) {
			genero = generoRepository.findById(id).get();
		}else {
			return "redirect:/listar-generos";
		}
		model.addAttribute("titulo", "Editar Genero");
		model.addAttribute("genero", genero);
		return "form-genero";
	}
	
	@RequestMapping(value = "/eliminar-genero/{idGenero}", method = RequestMethod.GET)
	public String eliminarGeneros(@PathVariable(value="idGenero") Long id, Model model) {
		Genero genero = null;
		if (id>0) {
			genero = generoRepository.findById(id).get();
			generoRepository.delete(genero);
		}else {
			return "redirect:/listar-generos";
		}
		
		return "redirect:/listar-generos";
	}
	
	@RequestMapping(value = "/nuevo-genero", method = RequestMethod.POST)
	public String guardarGenero(Genero genero) {
		

		
		generoRepository.save(genero);
		return "redirect:/listar-generos";
	}
	

}
