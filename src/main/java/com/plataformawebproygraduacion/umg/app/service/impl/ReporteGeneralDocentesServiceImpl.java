package com.plataformawebproygraduacion.umg.app.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.commons.JasperReportManager;
import com.plataformawebproygraduacion.umg.app.dto.ReporteGeneralEstudiantesDTO;
import com.plataformawebproygraduacion.umg.app.enums.TipoReporteEnum;
import com.plataformawebproygraduacion.umg.app.service.api.ReporteGeneralDocentesServiceAPI;

import net.sf.jasperreports.engine.JRException;
@Service

public class ReporteGeneralDocentesServiceImpl implements ReporteGeneralDocentesServiceAPI{

	@Autowired
	private JasperReportManager reportManager;
	
	@Autowired
	private DataSource dataSourse;
	
	@Override
	public ReporteGeneralEstudiantesDTO obtenerReporteGeneralDocentes(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "reporteGeneralDocentes";
		ReporteGeneralEstudiantesDTO dto = new ReporteGeneralEstudiantesDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

}
