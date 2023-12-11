package com.sistema.api.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sistema.api.Models.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long>{

	public Optional<Rol> findByNombre(String nombre);
	
	@Query("SELECT  s FROM Rol s WHERE s.nombre=?1")
	Rol findByNombres(String nombre);
	
}
