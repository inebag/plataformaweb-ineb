package com.plataformawebproygraduacion.umg.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Curso;

import com.plataformawebproygraduacion.umg.app.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	
	public List<Curso> listaCrusos(){
		
		return (List<Curso>) cursoRepository.findAll();
		
	}
	/*
	public ArrayList<Curso> listarCursoAL = new ArrayList<Curso>() {
		return;
	}
	
	*/
	

}
