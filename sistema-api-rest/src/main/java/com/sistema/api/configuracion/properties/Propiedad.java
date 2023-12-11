package com.sistema.api.configuracion.properties;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sistema.api.utilerias.ExceptionUtil;
import java.io.Serializable;

public class Propiedad implements Serializable{

	    Properties propVersion = new Properties();
	    Properties propGlobal = new Properties();
	    Properties propErrorPer = new Properties();
	    
	 String algoritm = "PBKDF2WithHmacSHA1";
	 String cipherMode = "AES/CBC/PKCS5Padding";
	  String allowedOrigins = "*";
	    private static Propiedad p = null;
	    
	public Propiedad() {
		try {
			InputStream in = this.getClass().getResourceAsStream("com/nisum/app/rest/configuration/properties/param.properties");
			propGlobal.load(in);
			in.close();
		} catch (IOException e) {
			final Log log = LogFactory.getLog(this.getClass());
			log.error(ExceptionUtil.format(e));
		}
	}

	

	public static Propiedad getInstance() {
		if (p == null) {
			p = new Propiedad();
		}
		return p;
	}
	
	public String getBDJdbc() {
		return propGlobal.getProperty("BD.JDBC");
	}

	public String getBDUsuario() {
		return propGlobal.getProperty("BD.USUARIO");
	}

	public String getBDClave() {
		return propGlobal.getProperty("BD.CLAVE");
	}
	
	public String getVersion() {
		return propGlobal.getProperty("VERSION");
	}
	
	public String getJwtSecret() {
		return propGlobal.getProperty("JWT_SECRET");
	}

	public String getJwtAccessToken() {
		return propGlobal.getProperty("JWT_ACCESS_TOKEN_SECRET");
	}
	
	public String getTiempoToken() {
		return propGlobal.getProperty("JWT_ACCESS_TOKEN_VALIDATE_SECONDS");
	}
	
	public String getUrlToken() {
		return propGlobal.getProperty("REQUEST_TOKEN_URL");
	}
	
	public String getAuthoritiesKeyToken() {
		return propGlobal.getProperty("AUTHORITIES_KEY");
	}
	
	
	public String getSigningKeyToken() {
		return propGlobal.getProperty("SIGNING_KEY");
	}
	
	public String getAccesTokenValidytySecondsToken() {
		return propGlobal.getProperty("ACCESS_TOKEN_VALIDITY_SECONDS");
	}
	
	public String getIssuerToken() {
		return propGlobal.getProperty("ISSUER_TOKEN");
	}
	
	public String getHeaderAuthorizationKeyToken() {
		return propGlobal.getProperty("HEADER_AUTHORIZATION_KEY");
	}
	
	public String getTokenBearerPrefix() {
		return propGlobal.getProperty("TOKEN_BEARER_PREFIX");
	}
	public String getAllowedOrigins() {
		return allowedOrigins;
	}
	public String getCipherMode() {
		return cipherMode;
	}

	public String getAlgorithm() {
		return algoritm;
	}
}
