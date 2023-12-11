package com.sistema.api.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sistema.api.Models.RolXusuario;
import com.sistema.api.Models.TelefonosXusuario;
import com.sistema.api.Models.Users;

public interface UsersServicio {
	public String crearUsers(Users u) throws Exception;

	public String actualizarUsers(Users u) throws Exception;

	public Users buscarUsersById(Users u);

	public Users buscarUsersNombre(String nombre) throws UsernameNotFoundException;

	public List<Users> devolverTodosUsers();

	public void eliminarUsers(Integer idusuario);

	public String asociarUsersRol(RolXusuario u) throws Exception;

	public String asociarUsersTelefono(TelefonosXusuario u) throws Exception;
	
	public List<Users> buscarPorCampos(Users filtro);
}
