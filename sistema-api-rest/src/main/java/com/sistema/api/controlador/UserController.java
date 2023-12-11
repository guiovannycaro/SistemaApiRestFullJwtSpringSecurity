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

import  com.sistema.api.Models.Users;
import com.sistema.api.Models.RolXusuario;
import  com.sistema.api.Models.Telefono;
import com.sistema.api.Models.TelefonosXusuario;
import com.sistema.api.servicio.TelefonosServicioImpl;
import  com.sistema.api.servicio.UsersServicioImpl;
@RestController
@RequestMapping("/nisum/getion/usuarios")
@Api(value = "Administracion de Usuarios")
public class UserController {

	
	 @PostMapping(value = "/crearUsuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value = "Creacion de Usuarios", response = Users.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Users.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = Users.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Users.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Users.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = Users.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = Users.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue =
				  "{"
					+ "'id_usuario':1,"
					+ "'codigo':''a1',"
					+ "'nombre': 'guiovanny caro',"
					+ "'email': 'guiovanny.caro@prueba.com',"
					+ "'password':'Admin123',"
					+ "'fechacreacion':'08/12/23',"
					+ "'fechaactualizacion':'08/12/23',"
					+ "'lastlogin':'08/12/23',"
					+ "'estado': true,"
					+ "'username':'guiovanny'"
					+ "}"
					)})
	 
	 public String crearUsuarios(
			 @ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true)
			 @RequestBody Users u) throws Exception{
		 String mensaje ="";
	        try {
	        	UsersServicioImpl  usuarioServicio = new UsersServicioImpl();
	        	usuarioServicio.crearUsers(u);
	            mensaje = "{\"mensaje\":\"El registro fue ingresado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue ingresado De Manera Correcta\"}";
	            System.err.println("Se ha generado un erroral crear el usuario :  " + er.getMessage());
	            throw new Exception(" El registro no fue ingresado De Manera Correcta ");

	        }
	        return mensaje;
	    }
	 
	 
	 @PostMapping(value = "/actualizarUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Actualizar de Usuarios", response = Users.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Users.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = Users.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Users.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Users.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = Users.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = Users.class), })
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = 
					"{"
					+ "'id_usuario':1,"
					+ "'codigo':''a1',"
					+ "'nombre': 'guiovanny caro',"
					+ "'email': 'guiovanny.caro@prueba.com',"
					+ "'password':'Admin123',"
					+ "'fechacreacion':'08/12/23',"
					+ "'fechaactualizacion':'08/12/23',"
					+ "'lastlogin':'08/12/23',"
					+ "'estado': true,"
					+ "'username':'guiovanny'"
					+ "}"
					) })
	
	    public String actualizarUsuarios (
	    		 @ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true)
	    		@RequestBody Users u)  throws Exception{
	    	 String mensaje ="";
	        try {

	        	UsersServicioImpl  usuarioServicio = new UsersServicioImpl();
	    		usuarioServicio.actualizarUsers(u);
	            mensaje = "{\"mensaje\":\"El registro fue actualizado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue actualizado  De Manera Correcta\"}";
	            System.err.println("Se ha generado un error  :  " + er.getMessage());
	            throw new Exception(" El registro no fue actualizado  De Manera Correcta ");
	        }
	        return mensaje;
	    }
	 
	 @PostMapping(value = "/buscarUsuariosById", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "busca de Usuarios por Id", response = Users.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Users.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = Users.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Users.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Users.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = Users.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = Users.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = 
					      "{"
							+ "'id_usuario':1,"
							+ "'codigo':''a1',"
							+ "'nombre': 'guiovanny caro',"
							+ "'email': 'guiovanny.caro@prueba.com',"
							+ "'password':'Admin123',"
							+ "'fechacreacion':'08/12/23',"
							+ "'fechaactualizacion':'08/12/23',"
							+ "'lastlogin':'08/12/23',"
							+ "'estado': true,"
							+ "'username':'guiovanny'"
							+ "}"
					) })
	    
	    public Users buscarUsuariosById(
	    		 @ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true)
	    		@RequestBody Users u) {
	        try {

	        
	        	UsersServicioImpl  usuarioServicio = new UsersServicioImpl();
	    		return usuarioServicio.buscarUsersById(u);
	
	        } catch (Exception er) {

	            System.err.println("Se ha generado un error :  " + er.getMessage());
	            return null;

	        }
	    }
	 
	 @GetMapping(value = "/ListarTodosUsuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Lista de Usuarios ", response = Users.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = Users.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = Users.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Users.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = Users.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = Users.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = Users.class), })
	
		public List<Users> devolverTodosUsuarios() {
			// TODO Auto-generated method stub
	    	ArrayList<Users> informacionUsuarios = new ArrayList<>();
	    	ArrayList<Telefono> informacionTelefonos = new ArrayList<>();
	    	
	    	
	    	 TelefonosServicioImpl telefonoServicio = new TelefonosServicioImpl();
	    	 UsersServicioImpl  usuarioServicio = new UsersServicioImpl();
	    	 
	    	informacionTelefonos.addAll(telefonoServicio.devolverTodosTelefonos());
	    	informacionUsuarios.addAll(usuarioServicio.devolverTodosUsers());
	    	
	    	
	    	 
	    	 
		    return usuarioServicio.devolverTodosUsers();
		}
	 
	 @PostMapping(value = "/asociarUsuarioRol", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "busca de Usuarios por Id", response = RolXusuario.class, notes = "Crea un nuevo telefono")
		@ApiResponses({ @ApiResponse(code = 200, message = "Se crea  de manera correcta", response = RolXusuario.class),
			@ApiResponse(code = 400, message = "Bad Request.El Usuarios Ingresado Esta Mal Digitado(String)", response = RolXusuario.class),
			@ApiResponse(code = 500, message = "Error del sistema inesperado", response = RolXusuario.class),
			@ApiResponse(code = 403, message = "Acceso denegado", response = RolXusuario.class),
			@ApiResponse(code = 401, message = "No existen Datos Asociados a Ese Usuarios", response = RolXusuario.class),
			@ApiResponse(code = 404, message = "No existen Datos Asociados a Ese Usuarios", response = RolXusuario.class), })
		
		@ApiImplicitParams({
			@ApiImplicitParam(name = "Usuarios", required = true, paramType = "query", dataType = "Object", value = "Ojeto Usuarios", defaultValue = "{\r\n"
					+ "\"idrol\":xxx,\r\n"
					+ "\"idusuario\": \"xxx\"\r\n"
					+ "}"), })
	    public String asociarUsuarioRol(
	    		 @ApiParam(name = "Usuarios", value = "Recibe el objeto Usuarios", required = true)
	    		@RequestBody RolXusuario u)  throws Exception{
	   
		 UsersServicioImpl  usuarioServicio = new UsersServicioImpl();
	    		 return usuarioServicio.asociarUsersRol(u);
	      
	    }
 
	 
	 @PostMapping(value = "/asociarUsuarioTelefono", produces = MediaType.APPLICATION_JSON_VALUE)
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

		 UsersServicioImpl  usuarioServicio = new UsersServicioImpl();
	    		 return usuarioServicio.asociarUsersTelefono(u);
	       
	    }
	 
	 
}
