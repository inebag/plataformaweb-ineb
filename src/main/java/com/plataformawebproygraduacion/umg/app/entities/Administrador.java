package com.plataformawebproygraduacion.umg.app.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "administrador")
public class Administrador {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idadministrador")
    private Long id;

    private String nombres;
    
    private String apellidos;
    
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaNac;
    
    private Long telefono;
    
    private String direccion;

    @OneToMany(mappedBy = "administrador")
    List<AsignacionUsuarioAdmin> asignacionUsuarioAdminList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<AsignacionUsuarioAdmin> getAsignacionUsuarioAdminList() {
		return asignacionUsuarioAdminList;
	}

	public void setAsignacionUsuarioAdminList(List<AsignacionUsuarioAdmin> asignacionUsuarioAdminList) {
		this.asignacionUsuarioAdminList = asignacionUsuarioAdminList;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNac="
				+ fechaNac + ", telefono=" + telefono + ", direccion=" + direccion + ", asignacionUsuarioAdminList="
				+ asignacionUsuarioAdminList + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, asignacionUsuarioAdminList, direccion, fechaNac, id, nombres, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(apellidos, other.apellidos)
				&& Objects.equals(asignacionUsuarioAdminList, other.asignacionUsuarioAdminList)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(fechaNac, other.fechaNac)
				&& Objects.equals(id, other.id) && Objects.equals(nombres, other.nombres)
				&& Objects.equals(telefono, other.telefono);
	}
    

    
    
}
