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
@Table(name = "asignacionusuariodoc")
public class AsignacionUsuarioDoc {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	@Column(name = "idasignacionusuariodoc")
    private Long id;

	@ManyToOne
	@JoinColumn(name = "iddocente")
	Docente docente; 

	@ManyToOne
	@JoinColumn(name = "idusuario")
	Usuario usuario;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "AsignacionUsuarioDoc [id=" + id + ", docente=" + docente + ", usuario=" + usuario + "]";
	} 
	
	

}
