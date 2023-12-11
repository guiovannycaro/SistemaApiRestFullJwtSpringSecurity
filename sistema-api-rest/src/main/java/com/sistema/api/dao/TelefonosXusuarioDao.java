package com.sistema.api.dao;

import com.sistema.api.Models.TelefonosXusuario;
import com.sistema.api.interfaces.TelefonosXusuarioInterface;

import java.sql.ResultSet;


import com.sistema.api.utilerias.executeQueryBD;

public class TelefonosXusuarioDao implements TelefonosXusuarioInterface{

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	
	@Override
	public String asociarTelefono(TelefonosXusuario r) {
		String validaIngreso = "";
		String sql = "insert into  clientes (idtelefono,idusuario) " + "values( "+ r.getId_telefono() + "," + "" + r.getId_usuario()  + ")  ";
		try {
		boolean rpt = query.executeUpdateBd(sql);
		
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} 
		}catch(Exception e) {
			
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\",\"exeption error\":\""+e.getMessage()+"\"}";
		}
		
		return validaIngreso;
	}

}
