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
@Table(name = "actividades")
public class Actividades {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idactividad")
    private Long idActividad;
	
	//@Column(name = "idcurso")
   // private Long idCurso;
	
	@ManyToOne
	@JoinColumn(name = "idcurso")
	Curso curso; 
	@Column(name = "descripcion")
    private String desc;
    
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss")
    private Date fechaInicio;
    
    @Column(name = "fechafin")
    
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss")
    private Date fechaFin;
	
	//@Column(name = "idbimestre")
   // Long idBimestre;
	
	@ManyToOne
	@JoinColumn(name = "idbimestre")
	Bimestre bimestre; 

	//@Column(name = "idcarpetaactividad")
  //  private Long idCarpetaActividad;
	
	@ManyToOne
	@JoinColumn(name = "idcarpetaactividad")
	CarpetaActividades carpetaActividades; 

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Bimestre getBimestre() {
		return bimestre;
	}

	public void setBimestre(Bimestre bimestre) {
		this.bimestre = bimestre;
	}

	public CarpetaActividades getCarpetaActividades() {
		return carpetaActividades;
	}

	public void setCarpetaActividades(CarpetaActividades carpetaActividades) {
		this.carpetaActividades = carpetaActividades;
	}

	

	

}
