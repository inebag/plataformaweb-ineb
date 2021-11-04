package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.plataformawebproygraduacion.umg.app.entities.Seccion;
import com.plataformawebproygraduacion.umg.app.repositories.SeccionRepository;

@Service
public class SeccionService {
	
	@Autowired
	private SeccionRepository seccionRepository;
	
	public List<Seccion> listaSecciones(){
		
		return (List<Seccion>) seccionRepository.findAll();
		
	}
	

}
