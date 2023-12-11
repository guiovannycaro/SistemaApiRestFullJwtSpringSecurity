package com.sistema.api.Models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RolXusuario", description = "Esta clase maneja RolXusuario")
public class RolXusuario {

	@ApiModelProperty(value = "idrol", required = true, dataType = "int", example = "000", position = 1)
	private int idrol;
	@ApiModelProperty(value = "idusuario", required = true, dataType = "int", example = "000", position = 2)
	private int idusuario;
	
	public RolXusuario(int idrol, int idusuario) {
		this.idrol = idrol;
		this.idusuario = idusuario;
	}

	public RolXusuario() {
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	@Override
	public String toString() {
		return "RolXusuario [idrol=" + idrol + ", idusuario=" + idusuario + "]";
	}
	
	
	
	
	
	
}

