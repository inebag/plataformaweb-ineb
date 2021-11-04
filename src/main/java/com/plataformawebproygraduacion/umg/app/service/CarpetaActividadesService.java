package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.CarpetaActividades;
import com.plataformawebproygraduacion.umg.app.repositories.CarpetaActividadesRepository;

@Service
public class CarpetaActividadesService {
	
	@Autowired
	private CarpetaActividadesRepository carpetaActividadesRepository;
	
	public List<CarpetaActividades> listaCarpetaActividades(){
		return(List<CarpetaActividades>) carpetaActividadesRepository.findAll();
	}

}
