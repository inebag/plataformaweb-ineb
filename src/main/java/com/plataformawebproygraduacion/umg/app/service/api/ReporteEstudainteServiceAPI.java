package com.plataformawebproygraduacion.umg.app.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.plataformawebproygraduacion.umg.app.dto.ReporteGeneralEstudiantesDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteEstudainteServiceAPI {
	ReporteGeneralEstudiantesDTO obtenerReporteEstudiante(Map<String, Object> params) throws JRException, IOException, SQLException;

	}
