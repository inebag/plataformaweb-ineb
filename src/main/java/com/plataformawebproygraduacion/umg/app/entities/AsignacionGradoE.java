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
@Table(name = "asignaciongradoes")
public class AsignacionGradoE {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idasignaciongradoe")
    private Long idAsignacionGradoE;
	
	//@Column(name = "idestudiante")
    //private Long idEstudiante;
	
	@ManyToOne
	@JoinColumn(name = "idestudiante")
	Estudiante estudiante; 

	//@Column(name = "idgrado")
    //private Long idGrado;

	@ManyToOne
	@JoinColumn(name = "idgrado")
	Grado grado; 
	

	public Long getIdAsignacionGradoE() {
		return idAsignacionGradoE;
	}

	public void setIdAsignacionGradoE(Long idAsignacionGradoE) {
		this.idAsignacionGradoE = idAsignacionGradoE;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}


	
	
	

	

}
