package com.plataformawebproygraduacion.umg.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class InicioController {
	
	@RequestMapping(value = {"/inicio","/"}, method = RequestMethod.GET)
	public String mostrarInicio(Model model) {

		model.addAttribute("titulo", "Inicio");	
		return "index";
	}
	
	
	@RequestMapping(value = {"/inicio-p"}, method = RequestMethod.GET)
	public String mostrarInicioPrueba(Model model) {

		model.addAttribute("titulo", "Inicio");	
		return "Inicio/inicio-prueba";
	}
	
	@RequestMapping(value = {"/inicio-admin"}, method = RequestMethod.GET)
	public String mostrarInicioAdmin(Model model) {

		return "Inicio/inicio-admin";
	}
	
	@RequestMapping(value = {"/inicio-ineb"}, method = RequestMethod.GET)
	public String mostrarInicioIneb(Model model) {

		return "inicio";
	}
	
	@RequestMapping(value = {"/selec-prueba"}, method = RequestMethod.GET)
	public String mostrarSelect(Model model) {

		return "pselect";
	}

}