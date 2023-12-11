package com.sistema.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sistema.api.Models.Telefono;
import java.util.List;

public interface TelefoniaRepository extends JpaRepository<Telefono, Integer>{

	  @Query("SELECT  s FROM Telefono s WHERE s.id =?1")
	  Telefono BuscarById(@Param("id") Integer id);
	   
	   

	   @Query("SELECT  s FROM Telefono s WHERE s.estado=?1")
	   List<Telefono> findByStatus(@Param("estado") boolean estado);
	   
	   
	   @Query("SELECT  s FROM Telefono s WHERE s.number=?1")
	   List<Telefono> findByNumero(String numerot);
}
