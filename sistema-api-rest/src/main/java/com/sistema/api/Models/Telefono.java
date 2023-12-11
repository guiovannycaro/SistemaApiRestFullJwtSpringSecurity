package com.sistema.api.Models;

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
@Table(name = "app_telefonos")
@Data
@ApiModel(value = "Telefono", description = "Esta clase maneja Usuarios")
public class Telefono {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id_telefono", required = true, dataType = "int", example = "000", position = 1)
    private int id;
    

	 @Column(name = "number")
    @ApiModelProperty(value = "number", required = true, dataType = "string", example = "000", position = 2)
	private String number;
    
   
	 @Column(name = "codigociudad")
    @ApiModelProperty(value = "codigociudad", required = true, dataType = "string", example = "000", position = 3)
	private String codigociudad;
    
 
	 @Column(name = "codigopais")
    @ApiModelProperty(value = "codigopais", required = true, dataType = "string", example = "000", position = 4)
	private String codigopais;

	 @Column(name = "fechacreacion")
    @ApiModelProperty(value = "fechacreacion", required = true, dataType = "string", example = "000", position = 5)
    private String fechacreacion;

   
	 @Column(name = "fechaactualizacion")
    @ApiModelProperty(value = "fechaactualizacion", required = true, dataType = "string", example = "000", position = 6)
    private String fechaactualizacion;
    
  
	 @Column(name = "estado")
    @ApiModelProperty(value = "estado", required = true, dataType = "Boolean", example = "000", position = 7)
    private Boolean estado;

   





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCodigociudad() {
		return codigociudad;
	}

	public void setCodigociudad(String codigociudad) {
		this.codigociudad = codigociudad;
	}

	public String getCodigopais() {
		return codigopais;
	}

	public void setCodigopais(String codigopais) {
		this.codigopais = codigopais;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Telefonos [id=" + id + ", number=" + number + ", codigociudad=" + codigociudad
				+ ", codigopais=" + codigopais + ", fechacreacion=" + fechacreacion + ", fechaactualizacion="
				+ fechaactualizacion + ", estado=" + estado + "]";
	}

}