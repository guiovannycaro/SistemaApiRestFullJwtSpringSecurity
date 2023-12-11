package com.sistema.api.controller;
import com.sistema.api.Models.Telefono;
import com.sistema.api.servicio.TelefonosServicioImpl;
import com.sistema.api.controlador.TelefoniaController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ContextConfiguration(classes = TelefoniaController.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(TelefoniaController.class)
public class TelefonoControllerTester {

	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private TelefonosServicioImpl mockService;
	    
	    @Test
	    public void testCrearTelefono_ReturnsString()  throws Exception{
	    	  Telefono tele = new Telefono();
	    		tele.setId(1);
	    		tele.setNumber("314-5682212");
	    		tele.setCodigociudad("15");
	    		tele.setCodigopais("50");
	    		tele.setFechacreacion("11/02/2023");
	    		tele.setFechaactualizacion("11/02/2023");
	    		tele.setEstado(true);
	    		  Mockito.when(mockService.crearTelefonos(tele)).thenReturn("El registro fue ingresado De Manera Correcta");
	    		  
	    		
	    		  mockMvc.perform(MockMvcRequestBuilders.post("/nisum/getion/telefonia/crearTelefonos")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content("{\"id\": \"1\", \"number\": 3160405672,\"codigociudad\":\"50\",\"codigopais\":\"15\",\"fechacreacion\":11/12/2023,\"fechaactualizacion\":\"11/12/2323\",\"estado\":\"true\" }"))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.content().string("El registro fue ingresado De Manera Correcta"));
	    		
	    		
	    }
	    
	    @Test
	    public void testCrearTelefono_Returns_WhenServiceThrowsException()  throws Exception{
	    	  Telefono tele = new Telefono();
	    		tele.setId(1);
	    		tele.setNumber("314-5682212");
	    		tele.setCodigociudad("15");
	    		tele.setCodigopais("50");
	    		tele.setFechacreacion("11/02/2023");
	    		tele.setFechaactualizacion("11/02/2023");
	    		tele.setEstado(true);
	    		  Mockito.when(mockService.crearTelefonos(tele)).thenReturn("Error occurred");
	    		  
	    		
	    		  mockMvc.perform(MockMvcRequestBuilders.post("/nisum/getion/telefonia/crearTelefonos")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content("{\"id\": \"1\", \"number\": 3160405672,\"codigociudad\":\"50\",\"codigopais\":\"15\",\"fechacreacion\":11/12/2023,\"fechaactualizacion\":\"11/12/2323\",\"estado\":\"true\" }"))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.content().string("Error occurred"));
	    		
	    		
	    }
}
