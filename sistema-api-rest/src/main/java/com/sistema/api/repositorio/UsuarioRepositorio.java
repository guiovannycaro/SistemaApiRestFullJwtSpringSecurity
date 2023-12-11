package com.sistema.api.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.sistema.api.Models.Usuarios;

public interface UsuarioRepositorio extends JpaRepository<Usuarios, Long>{

	public Optional<Usuarios> findByEmail(String email);
	
	public Optional<Usuarios> findByUsernameOrEmail(String username,String email);
	
	 @Query("SELECT  s FROM Usuarios s WHERE s.id =?1 and s.email =?1")
	 Usuarios findByUsernameOrEmaild(String username,String email);
	
	public Optional<Usuarios> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
	
	  @Query("SELECT  s FROM Usuarios s WHERE s.id =?1")
	  Usuarios BuscarById(@Param("id") Integer id);
	  
	  @Query("SELECT  s FROM Usuarios s")
	   List<Usuarios> ListarUsuarios();
	  
	  @Query("SELECT  s FROM Usuarios s WHERE s.estado=?1")
	   List<Usuarios> findByStatus(@Param("estado") boolean estado);
	  
	   @Query("SELECT  s FROM Usuarios s WHERE s.nombre=?1")
	   Usuarios findByNombre(String nombre);
	   
	   @Query("SELECT  s FROM Usuarios s WHERE s.email=?1")
	   Usuarios findByEmails(String email);
}
