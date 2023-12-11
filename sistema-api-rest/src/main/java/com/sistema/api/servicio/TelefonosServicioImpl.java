package com.sistema.api.servicio;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.api.Models.Telefono;
import com.sistema.api.repositorio.TelefoniaRepository;

public class TelefonosServicioImpl implements TelefonosServicio{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TelefoniaRepository telefonoRepositorio;
	@Override
	public String crearTelefonos(Telefono t) {
		 String mensaje ="";
	        try {

	            System.out.println("viene del front " + t.getId());
	            Telefono tele = new Telefono();
	    		tele.setId(t.getId());
	    		tele.setNumber(t.getNumber());
	    		tele.setCodigociudad(t.getCodigociudad());
	    		tele.setCodigopais(t.getCodigopais());
	    		tele.setFechacreacion(t.getFechacreacion());
	    		tele.setFechaactualizacion(t.getFechaactualizacion());
	    		tele.setEstado(t.getEstado());
	    		
	    		telefonoRepositorio.save(tele);
	            mensaje = "{\"mensaje\":\"El registro fue ingresado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue ingresado De Manera Correcta\"}";
	            System.err.println("Se ha generado un erroral crear el usuario :  " + er.getMessage());

	        }
	        return mensaje;
	}

	@Override
	public List<Telefono> devolverTodosTelefonos() {
		// TODO Auto-generated method stub
		return telefonoRepositorio.findAll();
	}

	@Override
	public String actualizarTelefonos(Telefono t) {
		 String mensaje;
	        try {


	            System.out.println("viene del front " + t.getId());
	        	  Telefono tele = new Telefono();
		    		tele.setId(t.getId());
		    		tele.setNumber(t.getNumber());
		    		tele.setCodigociudad(t.getCodigociudad());
		    		tele.setCodigopais(t.getCodigopais());
		    		tele.setFechacreacion(t.getFechacreacion());
		    		tele.setFechaactualizacion(t.getFechaactualizacion());
		    		tele.setEstado(t.getEstado());

		    		telefonoRepositorio.save(tele);
	            mensaje = "{\"mensaje\":\"El registro fue actualizado De Manera Correcta\"}";
	        } catch (Exception er) {
	        	mensaje = "{\"mensaje\":\"El registro no fue actualizado  De Manera Correcta\"}";
	            System.err.println("Se ha generado un error  :  " + er.getMessage());

	        }
	        return mensaje;
	}

	@Override
	public void eliminarTelefonos(Integer idTelefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Telefono buscarTelefonosById(Telefono t) {
		 try {

	        	System.out.println("viene del front " + t.getId());
	      	  Telefono tele = new Telefono();
		    		tele.setId(t.getId());
		    		tele.setNumber(t.getNumber());
		    		tele.setCodigociudad(t.getCodigociudad());
		    		tele.setCodigopais(t.getCodigopais());
		    		tele.setFechacreacion(t.getFechacreacion());
		    		tele.setFechaactualizacion(t.getFechaactualizacion());
		    		tele.setEstado(t.getEstado());


	    		 return telefonoRepositorio.findById(tele.getId()).orElse(null);
	        } catch (Exception er) {

	            System.err.println("Se ha generado un error :  " + er.getMessage());
	            return null;

	        }
	}

	@Override
	public List<Telefono> buscarPorCampos(Telefono filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Telefono> buscarTelefonosNumero(Telefono datos) {
		// TODO Auto-generated method stub
		return null;
	}

}
