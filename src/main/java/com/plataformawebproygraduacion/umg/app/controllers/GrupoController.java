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

import com.plataformawebproygraduacion.umg.app.entities.Curso;
import com.plataformawebproygraduacion.umg.app.entities.Docente;
import com.plataformawebproygraduacion.umg.app.entities.Grado;
import com.plataformawebproygraduacion.umg.app.entities.Grupo;
import com.plataformawebproygraduacion.umg.app.repositories.GrupoRepository;
import com.plataformawebproygraduacion.umg.app.service.CursoService;
import com.plataformawebproygraduacion.umg.app.service.DocenteService;
import com.plataformawebproygraduacion.umg.app.service.GradoService;
import com.plataformawebproygraduacion.umg.app.util.PageRender;

@Controller
public class GrupoController {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private GradoService gradoService;
	
	@Autowired
	private DocenteService docenteService;
	
	
	@RequestMapping(value = "/detalle-grupo/{idGrupo}", method = RequestMethod.GET)
	public String detalleGrupo(@PathVariable(value = "idGrupo") Long id, Model model) {
		
		Grupo grupo = grupoRepository.findById(id).get();
		if(grupo == null) {
			return "redirect:/listar-grupos";			
		}
		
		model.addAttribute("titulo", "Detalle Grupo: " + grupo.getIdGrupo());
		model.addAttribute("grupo", grupo);
		return "Grupo/detalle-grupo-form"; 
	}

	@RequestMapping(value = "/listar-grupos", method = RequestMethod.GET)
	public String listarGrupos(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 10);
	
		Page<Grupo> grupos = grupoRepository.findAll(pageRequest);
		
		PageRender<Grupo> pageRender = new PageRender<Grupo>("/listar-grupos", grupos);
		model.addAttribute("titulo", "Listado de Asignaciones de Grupos de Docentes");
		model.addAttribute("grupos", grupos);
		model.addAttribute("page", pageRender);
		return "Grupo/grupos";
	}
	
	@RequestMapping(value = "/nuevo-grupo", method = RequestMethod.GET)
	public String nuevoGrupo(Model model) {
		Grupo grupo = new Grupo();
		
		List<Curso> listaCursos = cursoService.listaCrusos();
		List<Grado> listaGrados = gradoService.listaGrados();
		List<Docente> listaDocentes = docenteService.listaDocentes();
		model.addAttribute("titulo", "Nuevo Grupo");
		model.addAttribute("grupo", grupo);
		model.addAttribute("cursos", listaCursos);
		model.addAttribute("grados", listaGrados);
		model.addAttribute("docentes", listaDocentes);
		
		return "Grupo/form-grupo";
    }
	
	@RequestMapping(value = "/nuevo-grupo", method = RequestMethod.POST)
	public String guardarGrupo(Grupo grupo) {
		
		grupoRepository.save(grupo);
		return "redirect:/listar-grupos";
	}
	
	@RequestMapping(value = "/editar-grupo/{idGrupo}", method = RequestMethod.GET)
	public String editarGrupo(@PathVariable(value="idGrupo") Long idGrupo, Model model) {
		Grupo grupo = null;
		List<Curso> listaCursos = cursoService.listaCrusos();
		List<Grado> listaGrados = gradoService.listaGrados();
		List<Docente> listaDocentes = docenteService.listaDocentes();
		if (idGrupo>0) {
			grupo = grupoRepository.findById(idGrupo).get();
		}else {
			return "redirect:/listar-grupos";
		}
		model.addAttribute("titulo", "Editar Grupo");
		model.addAttribute("grupo", grupo);
		model.addAttribute("cursos", listaCursos);
		model.addAttribute("grados", listaGrados);
		model.addAttribute("docentes", listaDocentes);
		return "Grupo/form-grupo";
	}
	
	@RequestMapping(value = "/eliminar-grupo/{idGrupo}", method = RequestMethod.GET)
	public String eliminarGrupo(@PathVariable(value="idGrupo") Long idGrupo, Model model) {
		Grupo grupo = null;
		if (idGrupo>0) {
			grupo = grupoRepository.findById(idGrupo).get();
			grupoRepository.delete(grupo);
		}else {
			return "redirect:/listar-grupos";
		}
		
		return "redirect:/listar-grupos";
	}
	
	
	
}
