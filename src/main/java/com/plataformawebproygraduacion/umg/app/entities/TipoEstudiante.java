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
@Table(name = "tipoestudiante")
public class TipoEstudiante {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idtipoestudiante")

    private Long idTipoEstudiante;
	
    @Column(name = "nombretipoestudiante")
    private String ntipoEstudiante;
    
    @OneToMany(mappedBy = "tipoEstudiante")
    List<Estudiante> EstudianteList;

	public Long getIdTipoEstudiante() {
		return idTipoEstudiante;
	}

	public void setIdTipoEstudiante(Long idTipoEstudiante) {
		this.idTipoEstudiante = idTipoEstudiante;
	}

	public String getNtipoEstudiante() {
		return ntipoEstudiante;
	}

	public void setNtipoEstudiante(String ntipoEstudiante) {
		this.ntipoEstudiante = ntipoEstudiante;
	}

	public List<Estudiante> getEstudianteList() {
		return EstudianteList;
	}

	public void setEstudianteList(List<Estudiante> estudianteList) {
		EstudianteList = estudianteList;
	}

	


    
    

}
