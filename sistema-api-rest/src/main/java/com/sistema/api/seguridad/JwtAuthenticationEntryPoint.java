package com.sistema.api.seguridad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import com.sistema.api.configuracion.properties.Propiedad;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
	private static final long serialVersionUID = -7858869558953243875L;
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		final Log log = LogFactory.getLog(this.getClass());
		response.addHeader("Access-Control-Allow-Origin", Propiedad.getInstance().getAllowedOrigins());
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", Propiedad.getInstance().getAllowedOrigins());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
		if (!request.getMethod().equals("OPTIONS")) {
			log.error("commence unauthorized ---------------------------------------");
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		} else {
			log.info("commence authorized +++++++++++++++++++++++++++++++++++++++++");
		
		}
	}

}
