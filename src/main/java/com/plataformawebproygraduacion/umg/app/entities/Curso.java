package com.plataformawebproygraduacion.umg.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idcurso")
    private Long idCurso;
	
    @Column(name = "codigoespecialidad")
    private String codigoEspecialidad;
    
    @Column(name = "nombrecurso")
    private String nombreCurso;

    @OneToMany(mappedBy = "curso")
    List<GradoCurso> gradoCursoList;
    
    @OneToMany(mappedBy = "curso")
    List<ContenidoCurso> contenidoCursoList;
    
    @OneToMany(mappedBy = "curso")
    List<Actividades> actividadesList;
    
    @OneToMany(mappedBy = "curso")
    List<Grupo> grupoList;
    
    @OneToMany(mappedBy = "curso")
    List<Notas> notasList;
    
    
    
	public List<Grupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<Grupo> grupoList) {
		this.grupoList = grupoList;
	}

	public List<Notas> getNotasList() {
		return notasList;
	}

	public void setNotasList(List<Notas> notasList) {
		this.notasList = notasList;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getCodigoEspecialidad() {
		return codigoEspecialidad;
	}

	public void setCodigoEspecialidad(String codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}



	public List<GradoCurso> getGradoCursoList() {
		return gradoCursoList;
	}

	public void setGradoCursoList(List<GradoCurso> gradoCursoList) {
		this.gradoCursoList = gradoCursoList;
	}

	public List<ContenidoCurso> getContenidoCursoList() {
		return contenidoCursoList;
	}

	public void setContenidoCursoList(List<ContenidoCurso> contenidoCursoList) {
		this.contenidoCursoList = contenidoCursoList;
	}

	public List<Actividades> getActividadesList() {
		return actividadesList;
	}

	public void setActividadesList(List<Actividades> actividadesList) {
		this.actividadesList = actividadesList;
	}
	

    
    

}
