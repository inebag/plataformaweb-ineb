package com.plataformawebproygraduacion.umg.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idgrupo")
    private Long idGrupo;
	
	//@Column(name = "iddocente")
    //private Long idDocente;
	
	@ManyToOne
	@JoinColumn(name = "iddocente")
	Docente docente; 
	
	
	//@Column(name = "idcurso")
    //private Long idCurso;
	
	@ManyToOne
	@JoinColumn(name = "idcurso")
	Curso curso; 
	
	//@Column(name = "idgrado")
    //private Long idGrado;
	
	@ManyToOne
	@JoinColumn(name = "idgrado")
	Grado grado; 

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}
	
	


	

	
}
