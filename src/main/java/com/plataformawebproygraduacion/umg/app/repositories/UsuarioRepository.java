package com.plataformawebproygraduacion.umg.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.plataformawebproygraduacion.umg.app.entities.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	 
	public Optional<Usuario> findByUsername(String username);

}