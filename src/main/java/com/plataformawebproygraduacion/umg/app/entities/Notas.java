package com.plataformawebproygraduacion.umg.app.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Notas {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "idnota")
    private Long id;
	
	
//	@Column(name = "idestudiante")
    //private Long idEstudiante;
	
	@ManyToOne
	@JoinColumn(name = "idestudiante")
	Estudiante estudiante; 
	
//	@Column(name = "idcurso")
  //  private Long idCurso;
	
	@ManyToOne
	@JoinColumn(name = "idcurso")
	Curso curso; 
	
    private Double nota;
    
    private String observacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "Notas [id=" + id + ", estudiante=" + estudiante + ", curso=" + curso + ", nota=" + nota
				+ ", observacion=" + observacion + "]";
	}


    
    

}
