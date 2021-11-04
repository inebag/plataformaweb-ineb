package com.plataformawebproygraduacion.umg.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.plataformawebproygraduacion.umg.app.entities.Docente;
import com.plataformawebproygraduacion.umg.app.entities.Genero;
import com.plataformawebproygraduacion.umg.app.repositories.DocenteRepository;
import com.plataformawebproygraduacion.umg.app.servb.IDocenteSer;
import com.plataformawebproygraduacion.umg.app.service.GeneroService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;




@Controller
@PreAuthorize("hasRole('ADMIN')")
public class DocenteController {
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private IDocenteSer docenteSer;
	
	@RequestMapping(value = "/detalle-docente/{idDocente}", method = RequestMethod.GET)
	public String detalleDocente(@PathVariable(value = "idDocente") Long id, Model model) {
		
		Docente docente = docenteRepository.findById(id).get();
		if(docente == null) {
			return "redirect:/listar-docentes";			
		}
		
		model.addAttribute("titulo", "Detalle Docente: " + docente.getNombresDocente() + " " + docente.getApellidosDocente());
		model.addAttribute("docente", docente);
		
		return "Docente/detalle-docente-form"; 
	}

	
	@RequestMapping(value = "/listar-docentes", method = RequestMethod.GET)
	public String listarDocentes(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Docente> docentes = docenteRepository.findAll(pageRequest);
		
		PageRender<Docente> pageRender = new PageRender<Docente>("/listar-docentes", docentes);
		model.addAttribute("titulo", "Listado de Docentes");
		model.addAttribute("docentes", docentes);
		model.addAttribute("page", pageRender);
		return "Docente/docentes";
	}
	
	@RequestMapping(value = "/nuevo-docente", method = RequestMethod.GET)
	public String nuevoDocente(Model model) {
		Docente docente = new Docente();
		List<Genero> listaGeneros = generoService.listaGeneros();
		
		model.addAttribute("titulo", "Nuevo Docente");
		model.addAttribute("docente", docente);
		model.addAttribute("generos", listaGeneros);		
		return "Docente/form-docente";
    }
	
	@RequestMapping(value = "/nuevo-docente", method = RequestMethod.POST)
	public String guardarDocente(Docente docente) {
		
		docenteRepository.save(docente);
		return "redirect:/listar-docentes";
	}
	
	
	
	
	
	@RequestMapping(value = "/editar-docente/{idDocente}", method = RequestMethod.GET)
	public String editarDocente(@PathVariable(value="idDocente") Long idDocente, Model model) {
		Docente docente = null;
		List<Genero> listaGeneros = generoService.listaGeneros();
		if (idDocente>0) {
			docente = docenteRepository.findById(idDocente).get();
		}else {
			return "redirect:/listar-docentes";
		}
		model.addAttribute("titulo", "Editar Docente");
		model.addAttribute("docente", docente);
		model.addAttribute("generos", listaGeneros);
		return "Docente/form-docente";
	}
	
	@RequestMapping(value = "/eliminar-docente/{idDocente}", method = RequestMethod.GET)
	public String eliminarDocente(@PathVariable(value="idDocente") Long idDocente, Model model) {
		Docente docente = null;
		if (idDocente>0) {
			docente = docenteRepository.findById(idDocente).get();
			docenteRepository.delete(docente);
		}else {
			return "redirect:/listar-docentes";
		}
		
		return "redirect:/listar-docentes";
	}
	
	
	//BUSQUEDA
	
	@GetMapping("/buscar-docente")
	public String BusquedaDocente(Model model) {
		model.addAttribute("docente", new Docente());
		return "Docente/docenteB";
		
	}
	
	
	@GetMapping("/dpiDocente")
	public String buscarDocente(@RequestParam String dpiDocente, Model model, @ModelAttribute("docente") Docente docente) {
		model.addAttribute("buscarDocentedpi", docenteSer.buscarDocentedpi(dpiDocente));
		
		return "Docente/docenteB";
	}

}
