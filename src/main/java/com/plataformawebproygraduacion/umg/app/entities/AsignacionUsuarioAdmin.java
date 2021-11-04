package com.plataformawebproygraduacion.umg.app.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "asignacionusuarioadm")
public class AsignacionUsuarioAdmin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idasignacionusuarioadm")
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idadministrador")
	Administrador administrador; 

	@ManyToOne
	@JoinColumn(name = "idusuario")
	Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 

	@Override
	public String toString() {
		return "asignacionUsuarioAdmin [id=" + id + ", administrador=" + administrador + ", usuario=" + usuario + "]";
	}



	
}
