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
import com.plataformawebproygraduacion.umg.app.dto.ReporteEstudiantesGradoDTO;
import com.plataformawebproygraduacion.umg.app.enums.TipoReporteEnum;
import com.plataformawebproygraduacion.umg.app.service.api.ReporteEstudianteGradoServiceAPI;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteEstudianteGradoServiceImpl implements ReporteEstudianteGradoServiceAPI{

	@Autowired
	private JasperReportManager reportManager;
	
	@Autowired
	private DataSource dataSourse;
	
	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante1roA(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListadoEstudiante1ro";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante1roB(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListadoEstudiantes1rob";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante1roC(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListaEstudiantes1roc";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante1roD(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListaEstudiantes1rod";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante2doA(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListaEstudiantes2roa";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante2doB(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListaEstudiantes2rob";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante2doC(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListaEstudiantes2doc";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante3roA(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListaEstudiantes3roa";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante3roB(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListaEstudiantes3rob";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		
		ByteArrayOutputStream stream = reportManager.export(fileName,
				params.get("tipo").toString(), params, dataSourse.getConnection());		
		byte[] bs = stream .toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		return dto;
	}

	@Override
	public ReporteEstudiantesGradoDTO obtenerReporteEstudiante3roC(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ListaEstudiantes3roc";
		ReporteEstudiantesGradoDTO dto = new ReporteEstudiantesGradoDTO();
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
