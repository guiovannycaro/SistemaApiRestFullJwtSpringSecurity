package com.sistema.api.dao;

import java.sql.ResultSet;

import com.sistema.api.Models.RolXusuario;
import com.sistema.api.interfaces.RolXusuarioInterface;
import com.sistema.api.utilerias.executeQueryBD;
public class RolXusuarioDao  implements RolXusuarioInterface {
	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	
	@Override
	public String asociarRol(RolXusuario r) throws Exception {
		String validaIngreso="";
		String sql = "insert into  clientes (idrol,idusuario) " + "values( "+ r.getIdrol() + "," + "" + r.getIdusuario()  + ")  ";
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
