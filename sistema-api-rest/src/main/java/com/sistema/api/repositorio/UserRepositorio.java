package com.sistema.api.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.sistema.api.Models.Users;
import org.springframework.data.jpa.repository.Modifying;

public interface UserRepositorio  extends JpaRepository<Users, Long>{

public Optional<Users> findByEmail(String email);
	
	public Optional<Users> findByUsernameOrEmail(String username,String email);
	
	 @Query("SELECT  s FROM Users s WHERE s.id =?1 and s.email =?1")
	 Users findByUsernameOrEmaild(String username,String email);
	
	public Optional<Users> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
	
	@Transactional
	  @Query("SELECT  s FROM Users s WHERE s.id_usuario =?1")
	  Users BuscarById(@Param("id") Long id);
	@Transactional
	  @Query("SELECT  s FROM Users s")
	   List<Users> ListarUsuarios();
	@Transactional
    @Modifying
	  @Query("SELECT  s FROM Users s WHERE s.estado=?1")
	   List<Users> findByStatus(@Param("estado") boolean estado);
	@Transactional
	   @Query("SELECT  s FROM Users s WHERE s.nombre=?1")
	   Users findByNombre(@Param("nombre") String nombre);
	@Transactional
	   @Query("SELECT  s FROM Users s WHERE s.email=?1")
	   Users findByEmails(@Param("email") String email);
	   
	 
}
