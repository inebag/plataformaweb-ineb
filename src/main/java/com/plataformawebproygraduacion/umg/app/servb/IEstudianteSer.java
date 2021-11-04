package com.plataformawebproygraduacion.umg.app.servb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plataformawebproygraduacion.umg.app.entities.Estudiante;

@Repository
public interface IEstudianteSer {
	
	List<Estudiante> buscarEstudianteN(String nombresEstudiante);

}
