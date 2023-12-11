package com.sistema.api.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
@Data
@ApiModel(value = "Usuarios", description = "Esta clase maneja Usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "id", required = true, dataType = "long", example = "000", position = 1)
	private long id;

	 @Column(name = "nombre")
	@ApiModelProperty(value = "nombre", required = true, dataType = "String", example = "000", position = 2)
	private String nombre;
	
	@Column(name = "username")
	@ApiModelProperty(value = "username", required = true, dataType = "String", example = "000", position = 3)
	private String username;
	
	@Column(name = "email")
	@ApiModelProperty(value = "email", required = true, dataType = "String", example = "000", position = 4)
	private String email;
	
	@Column(name = "password")
	@ApiModelProperty(value = "password", required = true, dataType = "String", example = "000", position = 5)
	private String password;
	
	 @Column(name = "fecha_creacion")
	 @ApiModelProperty(value = "fechacreacion", required = true, dataType = "String", example = "000", position = 6)
	 private String fechacreacion;


	 @Column(name = "fecha_actualizacion")
	 @ApiModelProperty(value = "fechaactualizacion", required = true, dataType = "String", example = "000", position = 7)
	 private String fechaactualizacion;
	    
	   
	 @Column(name = "last_login")
	 @ApiModelProperty(value = "ultimologeo", required = true, dataType = "String", example = "000", position = 8)
	 private String ultimologeo;

	  
	  @Column(name = "estado")
	  @ApiModelProperty(value = "estado", required = true, dataType = "Boolean", example = "000", position = 9)
	  private Boolean estado;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
	private Set<Rol> roles = new HashSet<>();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public String getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getFechaactualizacion() {
		return fechaactualizacion;
	}

	public void setFechaactualizacion(String fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public String getUltimologeo() {
		return ultimologeo;
	}

	public void setUltimologeo(String ultimologeo) {
		this.ultimologeo = ultimologeo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	

}
