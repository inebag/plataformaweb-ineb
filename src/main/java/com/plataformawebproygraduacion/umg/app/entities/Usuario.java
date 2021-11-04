package com.plataformawebproygraduacion.umg.app.entities;



import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1671417246199538663L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	
	@Column(name = "idusuario")
    private Long id;
	
	private String nombres;
	private String apellidos;

    private String username;

    private String password;
    
    @Transient
    private String confirmarPassword;

    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns=@JoinColumn(name="idusuario"),
			inverseJoinColumns=@JoinColumn(name="idrol"))
	private Set<Role> roles;

    
    @OneToMany(mappedBy = "usuario")
    List<AsignacionUsuarioAdmin> asignacionUsuarioAdminList;
    
    @OneToMany(mappedBy = "usuario")
    List<AsignacionUsuarioEs> asignacionUsuarioEsList;
    
    @OneToMany(mappedBy = "usuario")
    List<AsignacionUsuarioDoc> asignacionUsuarioDocList;
    
    
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override 
	public int hashCode() {
		return Objects.hash(apellidos, confirmarPassword, id, nombres, password, roles, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(confirmarPassword, other.confirmarPassword)
				&& Objects.equals(id, other.id) && Objects.equals(nombres, other.nombres)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", username=" + username
				+ ", password=" + password + ", confirmarPassword=" + confirmarPassword + ", roles=" + roles + "]";
	}

	
}
