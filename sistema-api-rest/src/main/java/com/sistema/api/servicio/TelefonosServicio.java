package com.sistema.api.servicio;

import java.util.List;

import com.sistema.api.Models.Telefono;

public interface TelefonosServicio {

	public String crearTelefonos(Telefono t);

	public List<Telefono> devolverTodosTelefonos();

	public String actualizarTelefonos(Telefono t);

	public void eliminarTelefonos(Integer idTelefono);

	public Telefono buscarTelefonosById(Telefono t);

	public List<Telefono> buscarPorCampos(Telefono filtro);

	public List<Telefono> buscarTelefonosNumero(Telefono datos);

}
