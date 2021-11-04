package com.plataformawebproygraduacion.umg.app.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.plataformawebproygraduacion.umg.app.dto.ReporteGrupoDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteGrupoServiceAPI {
	ReporteGrupoDTO obtenerReporteGrupo(Map<String, Object> params) throws JRException, IOException, SQLException;

}
