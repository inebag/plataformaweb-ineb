package com.plataformawebproygraduacion.umg.app.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_usuario")
public class RoleUsuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	@Column(name = "idrolusuario")
    private Long id;
	
	@Column(name = "idrol")
    private Long idRol;
	
	@Column(name = "idusuario")
    private Long idUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idRol, idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleUsuario other = (RoleUsuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(idRol, other.idRol)
				&& Objects.equals(idUsuario, other.idUsuario);
	}

	@Override
	public String toString() {
		return "RoleUsuario [id=" + id + ", idRol=" + idRol + ", idUsuario=" + idUsuario + "]";
	}
	
	
	
}
