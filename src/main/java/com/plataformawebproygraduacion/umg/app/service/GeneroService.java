package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Genero;
import com.plataformawebproygraduacion.umg.app.repositories.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	
	public List<Genero> listaGeneros(){
		
		return (List<Genero>) generoRepository.findAll();
		
	}
	

}
