package com.plataformawebproygraduacion.umg.app.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.plataformawebproygraduacion.umg.app.dto.ReporteGeneralEstudiantesDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteGeneralDocentesServiceAPI {
	
	ReporteGeneralEstudiantesDTO obtenerReporteGeneralDocentes(Map<String, Object> params) throws JRException, IOException, SQLException;

}



