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
@Table(name = "bimestre")
public class Bimestre {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idbimestre")

    private Long idBimestre;
	
    @Column(name = "nombrebimestre")
    private String nombreBimestre;
    
    
    @OneToMany(mappedBy = "bimestre")
    List<Actividades> actividadesList;

	public Long getIdBimestre() {
		return idBimestre;
	}

	public void setIdBimestre(Long idBimestre) {
		this.idBimestre = idBimestre;
	}

	public String getNombreBimestre() {
		return nombreBimestre;
	}

	public void setNombreBimestre(String nombreBimestre) {
		this.nombreBimestre = nombreBimestre;
	}
    
    

}
