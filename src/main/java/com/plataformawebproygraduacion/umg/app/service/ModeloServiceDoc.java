package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Docente;
import com.plataformawebproygraduacion.umg.app.repositories.DocenteRepository;
import com.plataformawebproygraduacion.umg.app.servb.IDocenteSer;

@Service
public class ModeloServiceDoc implements IDocenteSer{
	
	@Autowired
	private DocenteRepository docenteRepository;

	@Override
	public List<Docente> buscarDocentedpi(String dpiDocente) {
		// TODO Auto-generated method stub
		return docenteRepository.findByDpiDocente(dpiDocente);
	}
	

}
