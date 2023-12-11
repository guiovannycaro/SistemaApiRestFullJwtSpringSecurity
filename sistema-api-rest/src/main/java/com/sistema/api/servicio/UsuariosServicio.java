package com.sistema.api.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sistema.api.Models.RolXusuario;
import com.sistema.api.Models.TelefonosXusuario;

import com.sistema.api.Models.Usuarios;

public interface UsuariosServicio {
	public String crearUsuarios(Usuarios u) throws Exception;

	public String actualizarUsuarios(Usuarios u) throws Exception;

	public Usuarios buscarUsuariosById(Usuarios u);

	public Usuarios buscarUsuarioNombre(String nombre) throws UsernameNotFoundException;

	public List<Usuarios> devolverTodosUsuarios();

	public void eliminarUsuario(Integer idusuario);

	public String asociarUsuarioRol(RolXusuario u) throws Exception;

	public String asociarUsuarioTelefono(TelefonosXusuario u) throws Exception;
	
	public List<Usuarios> buscarPorCampos(Usuarios filtro);
}
