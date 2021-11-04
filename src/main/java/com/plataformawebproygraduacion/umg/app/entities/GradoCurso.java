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
@Table(name = "grado_curso")
public class GradoCurso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idgrado_curso")
	private Long id;
	
	 
	//@Column(name = "idgrado")
	//private Long idGrado;
	
	@ManyToOne
	@JoinColumn(name = "idgrado")
	Grado grado; 
	
	//@Column(name = "idcurso")
	//private Long idCursp;
	
	@ManyToOne
	@JoinColumn(name = "idcurso")
	Curso curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "GradoCurso [id=" + id + ", grado=" + grado + ", curso=" + curso + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, grado, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradoCurso other = (GradoCurso) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(grado, other.grado) && Objects.equals(id, other.id);
	} 
	
	
	

}
