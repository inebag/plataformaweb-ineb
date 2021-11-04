package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.TipoEstudiante;
import com.plataformawebproygraduacion.umg.app.repositories.TipoEstudianteRepository;


@Service
public class TipoEstudianteService {
	
	@Autowired
	private TipoEstudianteRepository tipoEstudianteRepository;
	
	
	public List<TipoEstudiante> listaTiposEstudiante(){
		
		return (List<TipoEstudiante>) tipoEstudianteRepository.findAll();
		
	}
	

}
