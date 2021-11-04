package com.plataformawebproygraduacion.umg.app.servb;

import com.plataformawebproygraduacion.umg.app.dto.ChangePasswordForm;
import com.plataformawebproygraduacion.umg.app.entities.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> getAllUsuarios();

	public Usuario createUser(Usuario user) throws Exception;
	
	public Usuario getUserById(Long id) throws Exception;

	public Usuario updateUser(Usuario user) throws Exception;
	
	public void deleteUser(Long id) throws Exception;
	
	public Usuario changePassword(ChangePasswordForm form) throws Exception;

	
}

