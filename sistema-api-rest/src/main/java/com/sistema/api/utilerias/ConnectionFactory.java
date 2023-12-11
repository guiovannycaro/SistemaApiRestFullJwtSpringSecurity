package com.sistema.api.utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sistema.api.configuracion.properties.Propiedad;

public class ConnectionFactory {
	public static Connection connectToBD() throws SQLException {
		
		String connString = Propiedad.getInstance().getBDJdbc();
		
		String username = Propiedad.getInstance().getBDUsuario();
	
		String password = Propiedad.getInstance().getBDClave();
		
		return DriverManager.getConnection(connString, username, password);
	}
}
