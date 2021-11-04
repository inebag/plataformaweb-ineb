package com.plataformawebproygraduacion.umg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.plataformawebproygraduacion.umg.app.entities.Estudiante;
import com.plataformawebproygraduacion.umg.app.repositories.EstudianteRepository;

@Service
public class EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	public List<Estudiante> listaEstudiantes(){
		return (List<Estudiante>) estudianteRepository.findAll(); 
	}


}
