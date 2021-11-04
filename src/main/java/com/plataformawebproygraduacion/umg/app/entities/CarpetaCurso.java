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
@Table(name = "carpetacurso")
public class CarpetaCurso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idcarpetacurso")

    private Long idCarpetaCurso;
	
    @Column(name = "nombrecarpetacurso")
    private String nombreCarpetaCurso;
    
    
    @OneToMany(mappedBy = "carpetaCurso")
    List<ContenidoCurso> contenidoCursoList;

	public Long getIdCarpetaCurso() {
		return idCarpetaCurso;
	}

	public void setIdCarpetaCurso(Long idCarpetaCurso) {
		this.idCarpetaCurso = idCarpetaCurso;
	}

	public String getNombreCarpetaCurso() {
		return nombreCarpetaCurso;
	}

	public void setNombreCarpetaCurso(String nombreCarpetaCurso) {
		this.nombreCarpetaCurso = nombreCarpetaCurso;
	}
    
    

}
