package com.plataformawebproygraduacion.umg.app.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "idrole")
    private Long id;
	
	@Column(name = "nombre")
    private String nombreRol;
	

    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nombreRol=" + nombreRol + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, nombreRol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(nombreRol, other.nombreRol);
	}


	
	
}

