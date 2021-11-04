package com.plataformawebproygraduacion.umg.app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Grado;
import com.plataformawebproygraduacion.umg.app.entities.GradoCurso;
import com.plataformawebproygraduacion.umg.app.repositories.GradoCursoRepository;
import com.plataformawebproygraduacion.umg.app.repositories.GradoRepository;



@Service
public class GradoService {

	@Autowired
	private GradoRepository gradoRepository;
	
	public List<Grado> listaGrados(){
		return (List<Grado>) gradoRepository.findAll();
	}
}
