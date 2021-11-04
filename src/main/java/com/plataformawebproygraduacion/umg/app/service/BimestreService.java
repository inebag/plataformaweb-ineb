package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Bimestre;
import com.plataformawebproygraduacion.umg.app.repositories.BimestreRepository;

@Service
public class BimestreService {

	@Autowired 
	private BimestreRepository bimestreRepository;
	
	public List<Bimestre> listaBimestres(){
		
		return (List<Bimestre>) bimestreRepository.findAll();
	}
}
