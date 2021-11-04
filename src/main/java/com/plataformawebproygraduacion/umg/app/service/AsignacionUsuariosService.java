package com.plataformawebproygraduacion.umg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Administrador;
import com.plataformawebproygraduacion.umg.app.entities.Usuario;
import com.plataformawebproygraduacion.umg.app.repositories.AdministradorRepository;
import com.plataformawebproygraduacion.umg.app.repositories.UsuarioRepository;

@Service
public class AsignacionUsuariosService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AdministradorRepository administradorRepository;

	public List<Usuario> listaUsuarios(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public List<Administrador> listaAdministradores(){
		return (List<Administrador>) administradorRepository.findAll();
	}
}
