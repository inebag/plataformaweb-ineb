package com.plataformawebproygraduacion.umg.app.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.plataformawebproygraduacion.umg.app.entities.Docente;
import com.plataformawebproygraduacion.umg.app.entities.Estudiante;

public interface DocenteRepository extends PagingAndSortingRepository<Docente, Long> {

	
	//Buscar docente por dpi
	List<Docente> findByDpiDocente(String dpiDocente);

}
