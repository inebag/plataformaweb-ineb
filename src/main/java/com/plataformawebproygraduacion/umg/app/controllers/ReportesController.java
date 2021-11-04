package com.plataformawebproygraduacion.umg.app.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plataformawebproygraduacion.umg.app.dto.ReporteEstudiantesGradoDTO;
import com.plataformawebproygraduacion.umg.app.dto.ReporteGeneralEstudiantesDTO;
import com.plataformawebproygraduacion.umg.app.dto.ReporteGrupoDTO;
import com.plataformawebproygraduacion.umg.app.enums.TipoReporteEnum;
import com.plataformawebproygraduacion.umg.app.service.api.ReporteEstudainteServiceAPI;
import com.plataformawebproygraduacion.umg.app.service.api.ReporteEstudianteGradoServiceAPI;
import com.plataformawebproygraduacion.umg.app.service.api.ReporteGeneralDocentesServiceAPI;
import com.plataformawebproygraduacion.umg.app.service.api.ReporteGeneralEstudiantesServiceAPI;
import com.plataformawebproygraduacion.umg.app.service.api.ReporteGrupoServiceAPI;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/report")
public class ReportesController {
	
	@Autowired
	private ReporteGrupoServiceAPI reporteGruposServiceAPI;
	
	@Autowired
	private ReporteGeneralEstudiantesServiceAPI reporteGeneralEstudiantesServiceAPI;
	
	@Autowired
	private ReporteGeneralDocentesServiceAPI reporteGeneralDocentesServiceAPI;
	
	@Autowired
	private ReporteEstudainteServiceAPI reporteEstudainteServiceAPI;
	
	@Autowired
	private ReporteEstudianteGradoServiceAPI reporteEstudianteGradoServiceAPI;
	
	@GetMapping(path = "/grupos/download")
	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteGrupoDTO dto = reporteGruposServiceAPI.obtenerReporteGrupo(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/estudiantes-general/download")
	public ResponseEntity<Resource> downloadD(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteGeneralEstudiantesDTO dto = reporteGeneralEstudiantesServiceAPI.obtenerReporteGeneralEstudiantes(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/docentes-general/download")
	public ResponseEntity<Resource> downloadE(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteGeneralEstudiantesDTO dto = reporteGeneralDocentesServiceAPI.obtenerReporteGeneralDocentes(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	} 
	
	@GetMapping(path = "/detalle-estudiante/download")
	public ResponseEntity<Resource> downloadEst(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteGeneralEstudiantesDTO dto = reporteEstudainteServiceAPI.obtenerReporteEstudiante(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	//REPORTE ESTUDIANTES POR GRADO Y SECCION 
	
	@GetMapping(path = "/estudiantes-primero-a/download")
	public ResponseEntity<Resource> download1roa(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante1roA(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/estudiantes-primero-b/download")
	public ResponseEntity<Resource> download1rob(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante1roB(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/estudiantes-primero-c/download")
	public ResponseEntity<Resource> download1roc(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante1roC(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/estudiantes-primero-d/download")
	public ResponseEntity<Resource> download1rod(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante1roD(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}

	@GetMapping(path = "/estudiantes-segundo-a/download")
	public ResponseEntity<Resource> download2doa(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante2doA(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/estudiantes-segundo-b/download")
	public ResponseEntity<Resource> download2dob(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante2doB(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/estudiantes-segundo-c/download")
	public ResponseEntity<Resource> download2doc(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante2doC(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	
	@GetMapping(path = "/estudiantes-tercero-a/download")
	public ResponseEntity<Resource> download3roa(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante3roA(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	@GetMapping(path = "/estudiantes-tercero-b/download")
	public ResponseEntity<Resource> download3rob(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante3roB(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	
	
	@GetMapping(path = "/estudiantes-tercero-c/download")
	public ResponseEntity<Resource> download3roc(@RequestParam Map<String, Object> params) 
			throws JRException, IOException, SQLException {
		
		ReporteEstudiantesGradoDTO dto = reporteEstudianteGradoServiceAPI.obtenerReporteEstudiante3roC(params);
		
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}

		
}


