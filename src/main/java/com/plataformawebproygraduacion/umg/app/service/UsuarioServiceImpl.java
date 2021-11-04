package com.plataformawebproygraduacion.umg.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.dto.ChangePasswordForm;
import com.plataformawebproygraduacion.umg.app.entities.Usuario;
import com.plataformawebproygraduacion.umg.app.repositories.UsuarioRepository;
import com.plataformawebproygraduacion.umg.app.servb.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Iterable<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	private boolean checkUsernameAvailable(Usuario user) throws Exception {
		Optional<Usuario> usuarioFound = usuarioRepository.findByUsername(user.getUsername());
		if (usuarioFound.isPresent()) {
			throw new Exception("Usuario no disponible");
		}
		return true;
	}

	private boolean checkPasswordValid(Usuario user) throws Exception {
		if (user.getConfirmarPassword() == null || user.getConfirmarPassword().isEmpty()) {
			throw new Exception("Confirm Password es obligatorio");
		}

		if ( !user.getPassword().equals(user.getConfirmarPassword())) {
			throw new Exception("Password y Confirmar Password no son iguales");
		}
		return true;
	}


	//usuario.getPassword()!=null && 

	@Override
	public Usuario createUser(Usuario user) throws Exception {
		if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
			user = usuarioRepository.save(user);
		}
		return user;
	}

	
	@Override
	public Usuario getUserById(Long id) throws Exception {
		return usuarioRepository.findById(id).orElseThrow(() -> new Exception("El usuario no existe."));
	}

	@Override
	public Usuario updateUser(Usuario fromUser) throws Exception {
		Usuario toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return usuarioRepository.save(toUser);
	}


	protected void mapUser(Usuario from,Usuario to) {
		to.setUsername(from.getUsername());
		to.setNombres(from.getNombres());
		to.setApellidos(from.getApellidos());
		to.setRoles(from.getRoles());
		to.setPassword(from.getPassword());
	}
	
	public void deleteUser(Long id) throws Exception {
		Usuario user = usuarioRepository.findById(id)
				.orElseThrow(() -> new Exception("UsernotFound in deleteUser -"+this.getClass().getName()));

		usuarioRepository.delete(user);
	}
	
	@Override
	public Usuario changePassword(ChangePasswordForm form) throws Exception {
		Usuario user = getUserById(form.getId());

		if ( !user.getPassword().equals(form.getCurrentPassword())) {
			throw new Exception ("Contraseña actual invalido.");
		}

		if( user.getPassword().equals(form.getNewPassword())) {
			throw new Exception ("La nueva contraseña debe ser diferente a la contraseña actual.");
		}

		if( !form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception ("la nueva contraseña y actual contraseña no coinciden.");
		}

		user.setPassword(form.getNewPassword());
		return usuarioRepository.save(user);
	}

}
