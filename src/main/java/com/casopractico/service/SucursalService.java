package com.casopractico.service;

import java.util.List;

import com.casopractico.entity.Sucursal;

public interface SucursalService {
	public List<Sucursal>listarTodos() throws Exception;
	public Sucursal buscarSucursal(String id) throws Exception;
	public void guardarSucursal(Sucursal sucursal) throws Exception;
	public void eliminarSucursal(String sucursal) throws Exception;
}
