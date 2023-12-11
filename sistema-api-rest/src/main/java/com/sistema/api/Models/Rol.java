package com.sistema.api.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
@ApiModel(value = "Rol", description = "Esta clase maneja roles")
public class Rol  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "id", required = true, dataType = "long", example = "000", position = 1)
	private long id;

	@Column(length = 60)
	@ApiModelProperty(value = "nombre", required = true, dataType = "String", example = "000", position = 2)
	private String nombre;

	@Column(name="descripcion")
	@ApiModelProperty(value = "description", required = true, dataType = "String", example = "000", position = 3)
	private String description;
	
	@Column(name = "estado")
	@ApiModelProperty(value = "description", required = true, dataType = "Boolean", example = "000", position = 4)
	private Boolean estado;

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

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Rol() {
		super();
	}

}
