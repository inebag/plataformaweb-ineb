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
@Table(name = "seccion")
public class Seccion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idseccion")

    private Long idSeccion;
	
	@Column(name = "seccion")
    private String nseccion;
	
    @OneToMany(mappedBy = "seccion")
    List<Grado> gradoList;

	public Long getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getNseccion() {
		return nseccion;
	}

	public void setNseccion(String nseccion) {
		this.nseccion = nseccion;
	}

	public List<Grado> getGradoList() {
		return gradoList;
	}

	public void setGradoList(List<Grado> gradoList) {
		this.gradoList = gradoList;
	}


    

}
