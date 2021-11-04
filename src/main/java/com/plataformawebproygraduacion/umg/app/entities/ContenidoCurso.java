package com.plataformawebproygraduacion.umg.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "contenidocurso")
public class ContenidoCurso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idcontenidocurso")
    private Long idContenidoCurso;
	
	//@Column(name = "idcurso")
    //private Long idCurso;
	
	@ManyToOne
	@JoinColumn(name = "idcurso")
	Curso curso; 
	
	
	//@Column(name = "idcarpeta")
    //private Long idCarpeta;
	
	@ManyToOne
	@JoinColumn(name = "idcarpeta")
	CarpetaCurso carpetaCurso; 
	
	
    private String contenido;
    
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date fechaCreacion;

	public Long getIdContenidoCurso() {
		return idContenidoCurso;
	}

	public void setIdContenidoCurso(Long idContenidoCurso) {
		this.idContenidoCurso = idContenidoCurso;
	}

	
	
	

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public CarpetaCurso getCarpetaCurso() {
		return carpetaCurso;
	}

	public void setCarpetaCurso(CarpetaCurso carpetaCurso) {
		this.carpetaCurso = carpetaCurso;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
   
    

}
