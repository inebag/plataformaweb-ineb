package com.plataformawebproygraduacion.umg.app.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plataformawebproygraduacion.umg.app.entities.Role;
import com.plataformawebproygraduacion.umg.app.repositories.UsuarioRepository;

@Service
@Transactional
public class UsuarioDetalleServiceImpl implements UserDetailsService  {
	
	@Autowired
    UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.plataformawebproygraduacion.umg.app.entities.Usuario appUser = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido."));

		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>(); 
		for (Role role: appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
            grantList.add(grantedAuthority);
		}
		UserDetails user = (UserDetails) new User(username,appUser.getPassword(),grantList);

		return user;
	}

/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}*/
}