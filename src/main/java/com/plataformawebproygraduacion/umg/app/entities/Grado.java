package com.plataformawebproygraduacion.umg.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grado")
public class Grado {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idgrado")
    private Long idGrado;
	
	@Column(name = "grado")
    private String ngrado;
	
	//@Column(name = "idseccion")
    //private Long idSeccion;
	
	@ManyToOne
	@JoinColumn(name = "idseccion")
	Seccion seccion; 
	
	
	//@Column(name = "idcurso")
    //private Long idCurso;
	
	/*
	@ManyToOne
	@JoinColumn(name = "idcurso")
	Curso curso;
	*/
	
    @OneToMany(mappedBy = "grado")
    List<GradoCurso> gradoCursoList;
    
    @OneToMany(mappedBy = "grado")
    List<AsignacionGradoE> asignacionGradoList;
	
    @OneToMany(mappedBy = "grado")
    List<Grupo> grupoList;
    
    
	public Long getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Long idGrado) {
		this.idGrado = idGrado;
	}

	

	public String getNgrado() {
		return ngrado;
	}

	public void setNgrado(String ngrado) {
		this.ngrado = ngrado;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}



	public List<GradoCurso> getGradoCursoList() {
		return gradoCursoList;
	}

	public void setGradoCursoList(List<GradoCurso> gradoCursoList) {
		this.gradoCursoList = gradoCursoList;
	}

	public List<AsignacionGradoE> getAsignacionGradoList() {
		return asignacionGradoList;
	}

	public void setAsignacionGradoList(List<AsignacionGradoE> asignacionGradoList) {
		this.asignacionGradoList = asignacionGradoList;
	}

	public List<Grupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<Grupo> grupoList) {
		this.grupoList = grupoList;
	}

	
	
	
}
