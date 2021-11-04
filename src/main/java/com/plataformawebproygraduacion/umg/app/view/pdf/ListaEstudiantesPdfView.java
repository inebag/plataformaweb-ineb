package com.plataformawebproygraduacion.umg.app.view.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.plataformawebproygraduacion.umg.app.entities.Estudiante;



@Component("Estudiante/estudiantes")
public class ListaEstudiantesPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		

	
	@SuppressWarnings("unchecked")
	Page<Estudiante> listaEstudiante2 = (Page<Estudiante>) model.get("estudiantes");
	List<Estudiante> listaEstudiante = listaEstudiante2.getContent();
	
	/*Fuentes, tamaños y colores para cada seccion*/
	Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
	Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.COURIER ,10,Color.BLACK);
	Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);
	
	document.setPageSize(PageSize.LETTER.rotate());
	document.setMargins(-20, -20, 30, 20);
	document.open();
	PdfPCell celda = null;
	
	/*Tabla para el Titulo de PDF*/
	PdfPTable tablaTitulo = new PdfPTable(1);

	celda = new PdfPCell(new Phrase("LISTADO GENERAL DE ESTUDIANTES", fuenteTitulo));
	celda.setBorder(0);
	celda.setBackgroundColor(new Color(236,177,65));
	celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
	celda.setPadding(30);
	
	tablaTitulo.addCell(celda);
	tablaTitulo.setSpacingAfter(30);
	
	/*Tabla para mostra listado de pedidos*/
	PdfPTable tablaEstudiantes = new PdfPTable(12);
	tablaEstudiantes.setWidths(new float[] {1f, 1.5f, 2.5f, 2.5f, 1.5f, 3.2f, 2.5f, 2.5f, 3.2f, 3.2f, 2.5f, 2f});
	
	
	
	celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("TIPO ESTUDIANTE", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("NOMBRES", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("APELLIDOS", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("FECHA NACIMIENTO", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("APELLIDOS", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("GENERO", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("TELEFONO", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("DIRECCION", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("NOMBRE ENCARGADO", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("APELLIDO ENCARGADO", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("DPI ENCARGADO", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	celda = new PdfPCell(new Phrase("TELEFONO ENCARGADO", fuenteTituloColumnas));
	celda.setBackgroundColor(Color.lightGray);
	celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	celda.setVerticalAlignment(Element.ALIGN_CENTER);
	celda.setPadding(10);
	tablaEstudiantes.addCell(celda);
	
	/* Bucle For para mostrar todos los datos de los clientes*/
	
	for(Estudiante estudiante : listaEstudiante) {
		celda = new PdfPCell(new Phrase(estudiante.getIdEstudiante().toString(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getTipoEstudiante().getNtipoEstudiante(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getNombresEstudiante(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getApellidosEstudiante(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getFechaNacimiento().toString(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getGenero().getNombreGenero(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getTelefono().toString(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getDireccion(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getNombresEncargado(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getApellidosEncargado(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getDpiEncargado(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		
		celda = new PdfPCell(new Phrase(estudiante.getTelefono().toString(), fuenteDataCeldas));
		celda.setPadding(5);
		tablaEstudiantes.addCell(celda);
		

	
	}
	
	

	document.add(tablaTitulo);
	document.add(tablaEstudiantes);
	
	
	}

}
