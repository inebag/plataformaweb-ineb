package com.plataformawebproygraduacion.umg.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "docente")
public class Docente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "iddocente")
    private Long idDocente;
	
	@Column(name = "dpidocente")
    private String dpiDocente;
	
    @Column(name = "nombresdocente")
    private String nombresDocente;   
	
    @Column(name = "apellidosdocente")
    private String apellidosDocente;
    
    @Nullable
    @Column(name = "apellidocasadadocente")
    private String apellidoCasadaDocente;
    
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
    
    @Column(name = "direcciondocente")
    private String direccionDocente;
    
    @Column(name = "estadocivil")
    private String estadoCivil;
    
	//@Column(name = "idgenero")
    //private Long idGenero;
	
	@ManyToOne
	@JoinColumn(name = "idgenero")
	Genero genero; 
	
	 
	@Column(name = "telefonodocente")
    private Long telefonoDocente;
	
    @Column(name = "nitdocente")
    private String nitDocente;
    
    private String email;
	
    @Column(name = "afiliacionigss")
    private String afiliacionIgss;
	
    @OneToMany(mappedBy = "docente")
    List<Grupo> grupoList;
    
    @OneToMany(mappedBy = "docente")
    List<AsignacionUsuarioDoc> asignacionUsuarioDocList;
    
	public Long getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(Long idDocente) {
		this.idDocente = idDocente;
	}
	
	
	public String getDpiDocente() {
		return dpiDocente;
	}

	public void setDpiDocente(String dpiDocente) {
		this.dpiDocente = dpiDocente;
	}

	public String getNombresDocente() {
		return nombresDocente;
	}

	public void setNombresDocente(String nombresDocente) {
		this.nombresDocente = nombresDocente;
	}

	public String getApellidosDocente() {
		return apellidosDocente;
	}

	public void setApellidosDocente(String apellidosDocente) {
		this.apellidosDocente = apellidosDocente;
	}

	public String getApellidoCasadaDocente() {
		return apellidoCasadaDocente;
	}

	public void setApellidoCasadaDocente(String apellidoCasadaDocente) {
		this.apellidoCasadaDocente = apellidoCasadaDocente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccionDocente() {
		return direccionDocente;
	}

	public void setDireccionDocente(String direccionDocente) {
		this.direccionDocente = direccionDocente;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public Long getTelefonoDocente() {
		return telefonoDocente;
	}

	public void setTelefonoDocente(Long telefonoDocente) {
		this.telefonoDocente = telefonoDocente;
	}

	public String getNitDocente() {
		return nitDocente;
	}

	public void setNitDocente(String nitDocente) {
		this.nitDocente = nitDocente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAfiliacionIgss() {
		return afiliacionIgss;
	}

	public void setAfiliacionIgss(String afiliacionIgss) {
		this.afiliacionIgss = afiliacionIgss;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Grupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<Grupo> grupoList) {
		this.grupoList = grupoList;
	}
	
	
    
}
