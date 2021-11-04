package com.plataformawebproygraduacion.umg.app.entities;



import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genero")
public class Genero  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idgenero")

    private Long idGenero;
	
    @Column(name = "nombregenero")
    private String nombreGenero;
    
    
    @OneToMany(mappedBy = "genero")
    List<Estudiante> estudianteList;
    
    @OneToMany(mappedBy = "genero")
    List<Docente> docenteteList;

    

	public Long getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombreGenero() {
		return nombreGenero;
	}

	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}

	public List<Estudiante> getEstudianteList() {
		return estudianteList;
	}

	public void setEstudianteList(List<Estudiante> estudianteList) {
		this.estudianteList = estudianteList;
	}

	public List<Docente> getDocenteteList() {
		return docenteteList;
	}

	public void setDocenteteList(List<Docente> docenteteList) {
		this.docenteteList = docenteteList;
	}

	@Override
	public String toString() {
		return "Genero [idGenero=" + idGenero + ", nombreGenero=" + nombreGenero + ", estudianteList=" + estudianteList
				+ ", docenteteList=" + docenteteList + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(docenteteList, estudianteList, idGenero, nombreGenero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		return Objects.equals(docenteteList, other.docenteteList)
				&& Objects.equals(estudianteList, other.estudianteList) && Objects.equals(idGenero, other.idGenero)
				&& Objects.equals(nombreGenero, other.nombreGenero);
	}


    
    
    
	

}
