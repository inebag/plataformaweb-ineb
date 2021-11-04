package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Estudiante;
import com.plataformawebproygraduacion.umg.app.repositories.EstudianteRepository;
import com.plataformawebproygraduacion.umg.app.servb.IEstudianteSer;

@Service
public class ModeloService implements IEstudianteSer {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public List<Estudiante> buscarEstudianteN(String nombresEstudiante){
		return estudianteRepository.findByNombresEstudiante(nombresEstudiante);
	}
	
	


}
