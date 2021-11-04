package com.plataformawebproygraduacion.umg.app.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.plataformawebproygraduacion.umg.app.entities.Estudiante;

public interface EstudianteRepository extends PagingAndSortingRepository<Estudiante, Long>{
	
	
	//Buscar estudiantes por nombre
	List<Estudiante> findByNombresEstudiante(String nombresEstudiante);
	;


}
