package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plataformawebproygraduacion.umg.app.entities.CarpetaCurso;
import com.plataformawebproygraduacion.umg.app.repositories.CarpetaCursoRepository;


@Service
public class CarpetaCursoService {
	
	@Autowired
	private CarpetaCursoRepository carpetaCursoRepository;
	
	
	
	public List<CarpetaCurso> listaCarpetaCurso(){
		
		return (List<CarpetaCurso>) carpetaCursoRepository.findAll();
		
	}

}
