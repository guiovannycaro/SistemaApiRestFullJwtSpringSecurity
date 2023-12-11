package com.sistema.api.Models;



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
@Table(name = "app_users")
@Data
@ApiModel(value = "Users", description = "Esta clase maneja Users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "id", required = true, dataType = "Long", example = "000", position = 1)
	 @Column(name = "idusuario")
	private Long id_usuario;

	 @Column(name = "codigo")
	 @ApiModelProperty(value = "codigo", required = true, dataType = "String", example = "000", position = 2)
	 private String codigo;
		
	 
	 @Column(name = "nombre")
	@ApiModelProperty(value = "nombre", required = true, dataType = "String", example = "000", position = 3)
	private String nombre;
	
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
	 @ApiModelProperty(value = "lastlogin", required = true, dataType = "String", example = "000", position =8)
	 private String lastlogin;
	    
	   
	 @Column(name = "estado")
	 @ApiModelProperty(value = "estado", required = true, dataType = "Boolean", example = "000", position = 9)
	 private Boolean estado;

	  
	  @Column(name = "username")
	  @ApiModelProperty(value = "username", required = true, dataType = "Boolean", example = "000", position = 10)
	  private String username;


	public Long getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	public String getLastlogin() {
		return lastlogin;
	}


	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	

	
	

	

}
