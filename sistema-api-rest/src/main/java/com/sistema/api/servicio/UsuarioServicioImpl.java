package com.sistema.api.servicio;

import java.util.List;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.sistema.api.Models.RolXusuario;
import com.sistema.api.Models.TelefonosXusuario;
import com.sistema.api.Models.Usuarios;
import com.sistema.api.Models.Telefono;
import com.sistema.api.repositorio.TelefoniaRepository;
import com.sistema.api.repositorio.UserRepositorio;
import com.sistema.api.repositorio.UsuarioRepositorio;
import com.sistema.api.dao.RolXusuarioDao;
import com.sistema.api.dao.TelefonosXusuarioDao;

@Service
public class UsuarioServicioImpl implements UsuariosServicio{

	@Autowired
	private ModelMapper modelMapper;
	

	
	@Autowired
	private UsuarioRepositorio usuariosRepositorio;
	
	@Override
	public String crearUsuarios(Usuarios u) throws Exception {
		 String mensaje ="";
	        try {
	        	
	        	 Pattern pattern = Pattern
	                     .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                             + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	        	
	        	 Matcher mather = pattern.matcher(u.getEmail());
	        	 String validaEmail ="";
	             if (mather.find() == true) {
	            	 validaEmail = u.getEmail();
	             } else {
	            	 validaEmail = "{\"mensaje\":\"El email ingresado es inválido.\"}\";";
	            	 throw new Exception(" El email ingresado es inválido " + u.getEmail());
	             }

	           
	        	
	        	
	        	
	            Usuarios usu = new Usuarios();
	    		usu.setId(u.getId());
	    		 System.out.println("viene del front usuario " + usu.getId());
	    		usu.setNombre(u.getNombre());
	    		System.out.println("viene del front nombre " + usu.getNombre());
	    		
	    		/*
	    		Usuarios us = usuariosRepositorio.findByEmails(u.getEmail());
	    		System.err.println("el email es " + us.getEmail());
	    		if (us != null) {
	    			usu.setEmail(validaEmail);
	    		}else {
	    			mensaje = "{\"mensaje\":\"El correo electronico ya existe\"}";
	      			 throw new Exception(" El correo electronico ya existe");
	    		}
	    		*/
	    		usu.setEmail(validaEmail);
	    		// Contraseña de 4-8 caracteres que requiere números y letras de ambos casos
			     String PASSWORD_REGEX =
			    		"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
			 
			    // Contraseña de 4 a 32 caracteres que requiere al menos 3 de 4 (mayúsculas
			    // y letras minúsculas, números y caracteres especiales) y como máximo
			    // 2 caracteres consecutivos iguales.
			    String COMPLEX_PASSWORD_REGEX =
			            "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
			            "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
			            "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
			            "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
			            "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
			            "{8,32}$";
			 
			  Pattern PASSWORD_PATTERN =
			                                    Pattern.compile(COMPLEX_PASSWORD_REGEX);
			  String validaPass ="";
			  if (PASSWORD_PATTERN.matcher(u.getPassword()).matches()) {
				
				  validaPass = u.getPassword();
		
		        }
		        else {
		        	 validaPass = "{\"mensaje\":\"La contraseña es invalida .\"}\";";
		        	 throw new Exception(" La contraseña es invalida " + usu.getPassword());
		        			 
		        }
			  
	    		usu.setPassword(validaPass);
	    		
	    		System.out.println("valida pas " + validaPass);
	    		usu.setFechacreacion(u.getFechacreacion());
	    		System.out.println("valida fecha_creacion " + usu.getFechacreacion());
	    		usu.setFechaactualizacion(u.getFechaactualizacion());
	    		System.out.println("valida fecha_actualizacion " + usu.getFechaactualizacion());
	    		usu.setUltimologeo(u.getUltimologeo());
	    		System.out.println("valida logeo " + usu.getUltimologeo());
	    		usu.setEstado(u.getEstado());
	    		System.out.println("valida estado " + usu.getEstado());
	    		
	    		
	    		usuariosRepositorio.save(usu);
	    		
	    		
	            mensaje = "{\"mensaje\":\"El registro fue ingresado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue ingresado De Manera Correcta\"}";
	            System.err.println("Se ha generado un erroral crear el usuario :  " + er.getMessage());
	            throw new Exception(" El registro no fue ingresado De Manera Correcta ");

	        }
	        return mensaje;
	}

	@Override
	public String actualizarUsuarios(Usuarios u) throws Exception {
		 String mensaje ="";
	        try {


	        	 Pattern pattern = Pattern
	                     .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                             + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	        	
	        	 Matcher mather = pattern.matcher(u.getEmail());
	        	 String validaEmail ="";
	             if (mather.find() == true) {
	            	 validaEmail = u.getEmail();
	             } else {
	            	 validaEmail = "{\"mensaje\":\"El email ingresado es inválido.\"}\";";
	            	  throw new Exception(" El email ingresado es inválido. " + u.getEmail());
	             }
	             
	        	System.out.println("viene del front " + u.getId());
	        	System.out.println("valida email  " + u.getEmail());
	            Usuarios usu = new Usuarios();
	    		usu.setId(u.getId());
	    		usu.setNombre(u.getNombre());
	    		usu.setEmail(validaEmail);
	    		
	    		
	    		
	    		// Contraseña de 4-8 caracteres que requiere números y letras de ambos casos
			     String PASSWORD_REGEX =
			    		"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
			 
			    // Contraseña de 4 a 32 caracteres que requiere al menos 3 de 4 (mayúsculas
			    // y letras minúsculas, números y caracteres especiales) y como máximo
			    // 2 caracteres consecutivos iguales.
			    String COMPLEX_PASSWORD_REGEX =
			            "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
			            "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
			            "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
			            "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
			            "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
			            "{8,32}$";
			 
			  Pattern PASSWORD_PATTERN =
			                                    Pattern.compile(COMPLEX_PASSWORD_REGEX);
			  String validaPass ="";
			  if (PASSWORD_PATTERN.matcher(u.getPassword()).matches()) {
				  validaPass = u.getPassword();
		        }
		        else {
		        	 validaPass = "{\"mensaje\":\"La contraseña es invalida .\"}\";";
		        	 throw new Exception(" La contraseña es invalida ");
		        }
			  
	    		usu.setPassword(validaPass);

	    		usuariosRepositorio.save(usu);
	            mensaje = "{\"mensaje\":\"El registro fue actualizado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue actualizado  De Manera Correcta\"}";
	            System.err.println("Se ha generado un error  :  " + er.getMessage());
	            throw new Exception(" El registro no fue actualizado  De Manera Correcta ");
	        }
	        return mensaje;
	}

	@Override
	public Usuarios buscarUsuariosById(Usuarios u) {
		  try {

	        	System.out.println("viene del front " + u.getId());
	            Usuarios usu = new Usuarios();
	    		usu.setId(u.getId());
	    		usu.setNombre(u.getNombre());
	    		usu.setEmail(u.getEmail());
	    		usu.setPassword(u.getPassword());

	    		

	    		 return usuariosRepositorio.findById(usu.getId()).orElse(null);
	        } catch (Exception er) {

	            System.err.println("Se ha generado un error :  " + er.getMessage());
	            return null;

	        }
	}

	@Override
	public Usuarios buscarUsuarioNombre(String nombre) throws UsernameNotFoundException {
		final Usuarios retrievedUser = usuariosRepositorio.findByNombre(nombre);
    	if (retrievedUser == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}

		return retrievedUser;
	}

	@Override
	public List<Usuarios> buscarPorCampos(Usuarios filtro) {

	    return null;
	
	}

	@Override
	public List<Usuarios> devolverTodosUsuarios() {

	    return usuariosRepositorio.findAll();
	}

	@Override
	public void eliminarUsuario(Integer idusuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String asociarUsuarioRol(RolXusuario u) throws Exception {
		System.out.println("viene del front " + u.getIdrol());
    	RolXusuario usu = new RolXusuario();
		usu.setIdrol(u.getIdrol());
		usu.setIdusuario(u.getIdusuario());
	
		RolXusuarioDao servicioUsuario = new RolXusuarioDao();

		 return servicioUsuario.asociarRol(usu);
	}

	@Override
	public String asociarUsuarioTelefono(TelefonosXusuario u) throws Exception {

    	System.out.println("viene del front " + u.getId_telefono());
    	TelefonosXusuario usu = new TelefonosXusuario();
		usu.setId_telefono(u.getId_telefono());
		usu.setId_telefono(u.getId_usuario());
	
		TelefonosXusuarioDao servicioUsuario = new TelefonosXusuarioDao();

		 return servicioUsuario.asociarTelefono(usu);
	}

}
