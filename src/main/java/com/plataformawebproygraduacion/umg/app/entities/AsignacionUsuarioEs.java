package com.plataformawebproygraduacion.umg.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aignacionusuarioes")
public class AsignacionUsuarioEs {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	@Column(name = "idaignacionusuarioes")
    private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "idestudiante")
	Estudiante estudiante; 
	

	@ManyToOne
	@JoinColumn(name = "idusuario")
	Usuario usuario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "AsignacionUsuarioEs [id=" + id + ", estudiante=" + estudiante + ", usuario=" + usuario + "]";
	} 
	
	
	
	

}
