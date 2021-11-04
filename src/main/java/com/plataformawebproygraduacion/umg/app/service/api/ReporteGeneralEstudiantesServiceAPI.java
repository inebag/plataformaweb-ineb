package com.plataformawebproygraduacion.umg.app.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.plataformawebproygraduacion.umg.app.dto.ReporteGeneralEstudiantesDTO;
import com.plataformawebproygraduacion.umg.app.dto.ReporteGrupoDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteGeneralEstudiantesServiceAPI {

	ReporteGeneralEstudiantesDTO obtenerReporteGeneralEstudiantes(Map<String, Object> params) throws JRException, IOException, SQLException;

	}


