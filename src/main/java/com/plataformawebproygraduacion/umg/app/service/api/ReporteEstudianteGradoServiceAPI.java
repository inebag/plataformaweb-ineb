package com.plataformawebproygraduacion.umg.app.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.plataformawebproygraduacion.umg.app.dto.ReporteEstudiantesGradoDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteEstudianteGradoServiceAPI {
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante1roA(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante1roB(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante1roC(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante1roD(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante2doA(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante2doB(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante2doC(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante3roA(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante3roB(Map<String, Object> params) throws JRException, IOException, SQLException;
	
	ReporteEstudiantesGradoDTO obtenerReporteEstudiante3roC(Map<String, Object> params) throws JRException, IOException, SQLException;

}

