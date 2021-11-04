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



@Entity
@Table(name = "estudiante")
public class Estudiante {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
	@Column(name = "idestudiante")
    private Long idEstudiante;
	
    @Column(name = "nombresestudiante")
    private String nombresEstudiante;
    
    @Column(name = "apellidosestudiante")
    private String apellidosEstudiante;
    
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
    
	@ManyToOne
	@JoinColumn(name = "idgeneroestudiante")
	Genero genero; 
	
	private Long telefono;
    private String direccion;
    
    @Column(name = "nombresencargado")
    private String nombresEncargado;
    
    @Column(name = "apellidosencargado")
    private String apellidosEncargado;
    
	@Column(name = "dpiencargado")
    private String dpiEncargado;
	
	@Column(name = "telefonoencargado")
    private Long telefonoEncargado;
	
	@ManyToOne
	@JoinColumn(name = "idtipoestudiante")
	TipoEstudiante tipoEstudiante; 
	
    @OneToMany(mappedBy = "estudiante")
    List<AsignacionGradoE> asignacionGradoEList;
    
    @OneToMany(mappedBy = "estudiante")
   List<AsignacionUsuarioEs> asignacionUsuarioEsEList;
    
    @OneToMany(mappedBy = "estudiante")
    List<Notas> notasList;
    
    

	public List<AsignacionUsuarioEs> getAsignacionUsuarioEsEList() {
		return asignacionUsuarioEsEList;
	}

	public void setAsignacionUsuarioEsEList(List<AsignacionUsuarioEs> asignacionUsuarioEsEList) {
		this.asignacionUsuarioEsEList = asignacionUsuarioEsEList;
	}

	public List<Notas> getNotasList() {
		return notasList;
	}

	public void setNotasList(List<Notas> notasList) {
		this.notasList = notasList;
	}

	public Long getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombresEstudiante() {
		return nombresEstudiante;
	}

	public void setNombresEstudiante(String nombresEstudiante) {
		this.nombresEstudiante = nombresEstudiante;
	}

	public String getApellidosEstudiante() {
		return apellidosEstudiante;
	}

	public void setApellidosEstudiante(String apellidosEstudiante) {
		this.apellidosEstudiante = apellidosEstudiante;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombresEncargado() {
		return nombresEncargado;
	}

	public void setNombresEncargado(String nombresEncargado) {
		this.nombresEncargado = nombresEncargado;
	}

	public String getApellidosEncargado() {
		return apellidosEncargado;
	}

	public void setApellidosEncargado(String apellidosEncargado) {
		this.apellidosEncargado = apellidosEncargado;
	}



	public String getDpiEncargado() {
		return dpiEncargado;
	}

	public void setDpiEncargado(String dpiEncargado) {
		this.dpiEncargado = dpiEncargado;
	}

	public Long getTelefonoEncargado() {
		return telefonoEncargado;
	}

	public void setTelefonoEncargado(Long telefonoEncargado) {
		this.telefonoEncargado = telefonoEncargado;
	}

	public TipoEstudiante getTipoEstudiante() {
		return tipoEstudiante;
	}

	public void setTipoEstudiante(TipoEstudiante tipoEstudiante) {
		this.tipoEstudiante = tipoEstudiante;
	}

	public List<AsignacionGradoE> getAsignacionGradoEList() {
		return asignacionGradoEList;
	}

	public void setAsignacionGradoEList(List<AsignacionGradoE> asignacionGradoEList) {
		this.asignacionGradoEList = asignacionGradoEList;
	}

	
	
	
	

}
