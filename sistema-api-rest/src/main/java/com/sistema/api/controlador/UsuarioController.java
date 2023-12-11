package com.sistema.api.controlador;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import  com.sistema.api.Models.Usuarios;
import com.sistema.api.Models.RolXusuario;
import  com.sistema.api.Models.Telefono;
import com.sistema.api.Models.TelefonosXusuario;
import com.sistema.api.servicio.TelefonosServicioImpl;
import  com.sistema.api.servicio.UsuarioServicioImpl;
@RestController
@RequestMapping("/api/getion/clientes")
@Api(value = "Administracion de clientes")
public class UsuarioController {

	
	 @PostMapping(value = "/crearClientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value = "Creacion de Clientes", response = Usuarios.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El Clientes Ingresado Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Clientes", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Clientes", response = Usuarios.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Clientes", required = true, paramType = "query", dataType = "Object", value = "Ojeto Clientes", defaultValue = 
					"{\r\n"
					+ "\"id\":xxx,\r\n"
					+ "\"nombre\": \"xxx\",\r\n"
					+ "\"username\": \"xxx\",\r\n"
					+ "\"email\":\"xxx\",\r\n"
					+ "\"password\":\"xxxx\",\r\n"
					+ "\"fechacreacion\":\"xxxx\",\r\n"
					+ "\"fechaactualizacion\":\"xxxx\",\r\n"
					+ "\"ultimologeo\":\"xxxx\",\r\n"
					+ "\"estado\": xxx\r\n"
					+ "}")
			})
	 
	 public String crearUsuarios(
			 @ApiParam(name = "Clientes", value = "Recibe el objeto Usuarios", required = true)
			 @RequestBody Usuarios u) throws Exception{
		 String mensaje ="";
	        try {
	        	UsuarioServicioImpl  usuarioServicio = new UsuarioServicioImpl();
	        	usuarioServicio.crearUsuarios(u);
	            mensaje = "{\"mensaje\":\"El registro fue ingresado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue ingresado De Manera Correcta\"}";
	            System.err.println("Se ha generado un erroral crear el usuario :  " + er.getMessage());
	            throw new Exception(" El registro no fue ingresado De Manera Correcta ");

	        }
	        return mensaje;
	    }
	 
	 
	 @PostMapping(value = "/actualizarClientes", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Actualizar de Usuarios", response = Usuarios.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El Clientes Ingresado Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Clientes", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Clientes", response = Usuarios.class), })
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Clientes", required = true, paramType = "query", dataType = "Object", value = "Ojeto Clientes", defaultValue = 
					"{\r\n"
							+ "\"id\":xxx,\r\n"
							+ "\"nombre\": \"xxx\",\r\n"
							+ "\"username\": \"xxx\",\r\n"
							+ "\"email\":\"xxx\",\r\n"
							+ "\"password\":\"xxxx\",\r\n"
							+ "\"fechacreacion\":\"xxxx\",\r\n"
							+ "\"fechaactualizacion\":\"xxxx\",\r\n"
							+ "\"ultimologeo\":\"xxxx\",\r\n"
							+ "\"estado\": xxx\r\n"
							+ "}"
					
					) })
	
	    public String actualizarUsuarios (
	    		 @ApiParam(name = "Clientes", value = "Recibe el objeto Clientes", required = true)
	    		@RequestBody Usuarios u)  throws Exception{
	    	 String mensaje ="";
	        try {

	    		UsuarioServicioImpl  usuarioServicio = new UsuarioServicioImpl();
	    		usuarioServicio.actualizarUsuarios(u);
	            mensaje = "{\"mensaje\":\"El registro fue actualizado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue actualizado  De Manera Correcta\"}";
	            System.err.println("Se ha generado un error  :  " + er.getMessage());
	            throw new Exception(" El registro no fue actualizado  De Manera Correcta ");
	        }
	        return mensaje;
	    }
	 
	 @PostMapping(value = "/buscarClientesById", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "busca de Clientes por Id", response = Usuarios.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El Clientes Ingresado Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Clientes", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Clientes", response = Usuarios.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Clientes", required = true, paramType = "query", dataType = "Object", value = "Ojeto Clientes", defaultValue =
					"{\r\n"
							+ "\"id\":xxx,\r\n"
							+ "\"nombre\": \"xxx\",\r\n"
							+ "\"username\": \"xxx\",\r\n"
							+ "\"email\":\"xxx\",\r\n"
							+ "\"password\":\"xxxx\",\r\n"
							+ "\"fechacreacion\":\"xxxx\",\r\n"
							+ "\"fechaactualizacion\":\"xxxx\",\r\n"
							+ "\"ultimologeo\":\"xxxx\",\r\n"
							+ "\"estado\": xxx\r\n"
							+ "}")
			})
	    
	    public Usuarios buscarUsuariosById(
	    		 @ApiParam(name = "Clientes", value = "Recibe el objeto Clientes", required = true)
	    		@RequestBody Usuarios u) {
	        try {

	        
	        	UsuarioServicioImpl  usuarioServicio = new UsuarioServicioImpl();
	    		return usuarioServicio.buscarUsuariosById(u);
	
	        } catch (Exception er) {

	            System.err.println("Se ha generado un error :  " + er.getMessage());
	            return null;

	        }
	    }
	 
	 @GetMapping(value = "/ListarTodosClientes", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Lista de Clientes ", response = Usuarios.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Usuarios.class),
			@ApiResponse(code = 400, message = "Bad Request.El Clientes Ingresado Esta Mal Digitado(String)", response = Usuarios.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Clientes", response = Usuarios.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Clientes", response = Usuarios.class), })
	
		public List<Usuarios> devolverTodosUsuarios() {
			// TODO Auto-generated method stub
	    
	    	 UsuarioServicioImpl  usuarioServicio = new UsuarioServicioImpl();
		    return usuarioServicio.devolverTodosUsuarios();
		}
	 
	 @PostMapping(value = "/asociarClientesRol", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "busca de Usuarios por Id", response = RolXusuario.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = RolXusuario.class),
			@ApiResponse(code = 400, message = "Bad Request.El Clientes Ingresado Esta Mal Digitado(String)", response = RolXusuario.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = RolXusuario.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = RolXusuario.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Clientes", response = RolXusuario.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Clientes", response = RolXusuario.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Clientes", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = "{\r\n"
					+ "\"idrol\":xxx,\r\n"
					+ "\"idusuario\": \"xxx\"\r\n"
					+ "}"), })
	    public String asociarUsuarioRol(
	    		 @ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true)
	    		@RequestBody RolXusuario u)  throws Exception{
	   
	    		 UsuarioServicioImpl  usuarioServicio = new UsuarioServicioImpl();
	    		 return usuarioServicio.asociarUsuarioRol(u);
	      
	    }
 
	 
	 @PostMapping(value = "/asociarClientesTelefono", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Usuarios asociar Telefono", response = TelefonosXusuario.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = TelefonosXusuario.class),
			@ApiResponse(code = 400, message = "Bad Request.El Telefono Esta Mal Digitado(String)", response = TelefonosXusuario.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TelefonosXusuario.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = TelefonosXusuario.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Telefono", response = TelefonosXusuario.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Telefono", response = TelefonosXusuario.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "TelefonosXusuario", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = "{\r\n"
					+ "\"id_telefono\":xxx,\r\n"
					+ "\"id_usuario\": \"xxx\"\r\n"
					+ "}"), })
	  
	    public String asociarUsuarioTelefono(
	    		 @ApiParam(name = "TelefonosXusuario", value = "Recibe el objeto Usuarios x TELEFONO", required = true)
	    		@RequestBody TelefonosXusuario u) throws Exception{

	    		 UsuarioServicioImpl  usuarioServicio = new UsuarioServicioImpl();
	    		 return usuarioServicio.asociarUsuarioTelefono(u);
	       
	    }
	 
	 
}
