package com.sistema.api.controlador;

import java.util.List;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;
import com.sistema.api.servicio.TelefonosServicioImpl;
import com.sistema.api.Models.Telefono;



@RestController
@RequestMapping("/api/getion/telefonia")
@Api(value = "Administracion de Telefonia")
public class TelefoniaController {
	

	
	
	@PostMapping(value = "/crearTelefonos", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Creacion de Telefonos", response = Telefono.class, notes = "Crea un nuevo telefono")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Telefono.class),
		@ApiResponse(code = 400, message = "Bad Request.El telefono Ingresado Esta Mal Digitado(String)", response = Telefono.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Telefono.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Telefono.class),
		@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese telefono", response = Telefono.class),
		@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese telefono", response = Telefono.class), })
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Telefonos", required = true, paramType = "query", dataType = "Object", value = "Ojeto Telefono", defaultValue = 
				"{\r\n"
				+ "\"id_telefono\":xxx,\r\n"
				+ "\"number\": \"xxx\",\r\n"
				+ "\"codigociudad\": \"xxx\",\r\n"
				+ "\"codigopais\":\"xxx\",\r\n"
				+ "\"fechacreacion\":\"xxxx\",\r\n"
				+ "\"fechaactualizacion\":\"xxxx\",\r\n"
				+ "\"estado\": xxx\r\n"
				+ "}"), })
	  
	 public String crearTelefonos(
			 @ApiParam(name = "Telefonos", value = "Recibe el objeto telefono", required = true)
			 @RequestBody Telefono t) {
		   TelefonosServicioImpl telefonoServicio = new TelefonosServicioImpl();
	        return telefonoServicio.crearTelefonos(t);
	    }
	
	


	 @PostMapping(value = "/ListadoDeTelefonos", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value = "Listado de Telefonos", response = Telefono.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Telefono.class),
			@ApiResponse(code = 400, message = "Bad Request.El telefono Ingresado Esta Mal Digitado(String)", response = Telefono.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Telefono.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Telefono.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese telefono", response = Telefono.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese telefono", response = Telefono.class), })

	public List<Telefono> devolverTodosTelefonos() {
		  TelefonosServicioImpl telefonoServicio = new TelefonosServicioImpl();
		 return telefonoServicio.devolverTodosTelefonos();
	}
	
	 @PostMapping(value = "/actualizarTelefonos", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value = "actualizar de Telefonos", response = Telefono.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Telefono.class),
			@ApiResponse(code = 400, message = "Bad Request.El telefono Ingresado Esta Mal Digitado(String)", response = Telefono.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Telefono.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Telefono.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese telefono", response = Telefono.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese telefono", response = Telefono.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Telefonos", required = true, paramType = "query", dataType = "Object", value = "Ojeto Telefono", defaultValue = "{\r\n"
					+ "\"id_telefono\":xxx,\r\n"
					+ "\"number\": \"xxx\",\r\n"
					+ "\"codigociudad\": \"xxx\",\r\n"
					+ "\"codigopais\":\"xxx\",\r\n"
					+ "\"fechacreacion\":\"xxxx\",\r\n"
					+ "\"fechaactualizacion\":\"xxxx\",\r\n"
					+ "\"estado\": xxx\r\n"
					+ "}"), })
	    
	    public String actualizarTelefonos(
	    		 @ApiParam(name = "Telefonos", value = "Recibe el objeto telefono", required = true)
	    		@RequestBody Telefono t) {
		 String mensaje;
	        try {


	      	  TelefonosServicioImpl telefonoServicio = new TelefonosServicioImpl();

	      	telefonoServicio.actualizarTelefonos(t);
	            mensaje = "{\"mensaje\":\"El registro fue actualizado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue actualizado  De Manera Correcta\"}";
	            System.err.println("Se ha generado un error  :  " + er.getMessage());

	        }
	        return mensaje;
	    }

	
	 
	 @PostMapping(value = "/buscarTelefonosById", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "buscar de Telefono por id", response = Telefono.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Telefono.class),
			@ApiResponse(code = 400, message = "Bad Request.El telefono Ingresado Esta Mal Digitado(String)", response = Telefono.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Telefono.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Telefono.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese telefono", response = Telefono.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese telefono", response = Telefono.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Telefonos", required = true, paramType = "query", dataType = "Object", value = "Ojeto Telefono", defaultValue = "{\r\n"
					+ "\"id_telefono\":xxx,\r\n"
					+ "\"number\": \"xxx\",\r\n"
					+ "\"codigociudad\": \"xxx\",\r\n"
					+ "\"codigopais\":\"xxx\",\r\n"
					+ "\"fechacreacion\":\"xxxx\",\r\n"
					+ "\"fechaactualizacion\":\"xxxx\",\r\n"
					+ "\"estado\": xxx\r\n"
					+ "}"), })
	    
	    public Telefono buscarTelefonosById(
	    		 @ApiParam(name = "Telefonos", value = "Recibe el objeto telefono", required = true)
	    		@RequestBody Telefono t) {
	        try {
	        	  TelefonosServicioImpl telefonoServicio = new TelefonosServicioImpl();
	   


	    		 return telefonoServicio.buscarTelefonosById(t);
	        } catch (Exception er) {

	            System.err.println("Se ha generado un error :  " + er.getMessage());
	            return null;

	        }
	    }
	
}
