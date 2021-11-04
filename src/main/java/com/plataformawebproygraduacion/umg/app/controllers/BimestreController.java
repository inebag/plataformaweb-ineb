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

import com.plataformawebproygraduacion.umg.app.entities.Bimestre;
import com.plataformawebproygraduacion.umg.app.repositories.BimestreRepository;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class BimestreController {
	
	@Autowired
	private BimestreRepository bimestreRepository;
	
	@RequestMapping(value = "/detalle-bimestre/{idBimestre}", method = RequestMethod.GET)
	public String detalleBimestre(@PathVariable(value = "idBimestre") Long id, Model model) {
		
		Bimestre bimestre = bimestreRepository.findById(id).get();
		if(bimestre == null) {
			return "redirect:/listar-bimestre";			
		}
		
		model.addAttribute("titulo", "Detalle Bimestre: " + bimestre.getNombreBimestre());
		model.addAttribute("bimestre", bimestre);
		return "Bimestre/detalle-bimestre-form"; 
	}
	
	@RequestMapping(value = "/listar-bimestres", method = RequestMethod.GET)
	public String listarBimestre(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Bimestre> bimestres = bimestreRepository.findAll(pageRequest);
		
		PageRender<Bimestre> pageRender = new PageRender<Bimestre>("/listar-bimestres", bimestres);
		model.addAttribute("titulo", "Listado de generos");
		model.addAttribute("bimestres", bimestres);
		model.addAttribute("page", pageRender);
		return "Bimestre/bimestres";
	}
	
	@RequestMapping(value = "/nuevo-bimestre", method = RequestMethod.GET)
	public String nuevoBimestre(Model model) {
		Bimestre bimestre = new Bimestre();
		model.addAttribute("titulo", "Nuevo Bimestre");
		model.addAttribute("bimestre", bimestre);
		return "Bimestre/form-bimestre";
    }
	
	@RequestMapping(value = "/editar-bimestre/{idBimestre}", method = RequestMethod.GET)
	public String editarBimestre(@PathVariable(value="idBimestre") Long idBimestre, Model model) {
		Bimestre bimestre  = null;
		if (idBimestre>0) {
			bimestre = bimestreRepository.findById(idBimestre).get();
		}else {
			return "redirect:/listar-bimestres";
		}
		model.addAttribute("titulo", "Editar Bimestre");
		model.addAttribute("bimestre", bimestre);
		return "Bimestre/form-bimestre";
	}
	
	@RequestMapping(value = "/eliminar-bimestre/{idBimestre}", method = RequestMethod.GET)
	public String eliminarBimestre(@PathVariable(value="idBimestre") Long idBimestre, Model model) {
		Bimestre bimestre = null;
		if (idBimestre>0) {
			bimestre = bimestreRepository.findById(idBimestre).get();
			bimestreRepository.delete(bimestre);
		}else {
			return "redirect:/listar-bimestres";
		}
		
		return "redirect:/listar-bimestres"; 
	}
	
	@RequestMapping(value = "/nuevo-bimestre", method = RequestMethod.POST)
	public String guardarBimestre(Bimestre bimestre) {
		
	
		
		bimestreRepository.save(bimestre);
		return "redirect:/listar-bimestres";
	}
	

	

}
