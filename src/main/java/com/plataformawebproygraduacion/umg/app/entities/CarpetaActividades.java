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
@Table(name = "carpetaactividades")
public class CarpetaActividades {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idcarpetaactividad")

    private Long idCarpetaActividad;
	
    @Column(name = "nombrecarpetaactividad")
    private String nombreCarpetaActividad;

    @OneToMany(mappedBy = "carpetaActividades")
    List<Actividades> actividadesList;
    
	public Long getIdCarpetaActividad() {
		return idCarpetaActividad;
	}

	public void setIdCarpetaActividad(Long idCarpetaActividad) {
		this.idCarpetaActividad = idCarpetaActividad;
	}

	public String getNombreCarpetaActividad() {
		return nombreCarpetaActividad;
	}

	public void setNombreCarpetaActividad(String nombreCarpetaActividad) {
		this.nombreCarpetaActividad = nombreCarpetaActividad;
	}
    
    

}
