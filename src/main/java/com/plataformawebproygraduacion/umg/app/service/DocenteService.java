package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Docente;
import com.plataformawebproygraduacion.umg.app.repositories.DocenteRepository;

@Service
public class DocenteService {
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	public List<Docente> listaDocentes(){
		return (List<Docente>) docenteRepository.findAll();
	}

}
