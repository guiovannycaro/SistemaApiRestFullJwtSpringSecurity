package com.sistema.api.Models;




import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TelefonosXusuario", description = "Esta clase maneja TelefonosXusuario")
public class TelefonosXusuario {


	

	@ApiModelProperty(value = "id_telefono", required = true, dataType = "int", example = "000", position = 1)
	private int id_telefono;
	
	
	@ApiModelProperty(value = "id_usuario", required = true, dataType = "int", example = "000", position = 2)
	private int id_usuario;

	public TelefonosXusuario() {
		
	}

	public TelefonosXusuario(int id_telefono, int id_usuario) {
		this.id_telefono = id_telefono;
		this.id_usuario = id_usuario;
	}



	public int getId_telefono() {
		return id_telefono;
	}

	public void setId_telefono(int id_telefono) {
		this.id_telefono = id_telefono;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	

	
}
