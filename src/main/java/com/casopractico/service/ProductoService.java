package com.casopractico.service;

import java.util.List;

import com.casopractico.entity.Producto;

public interface ProductoService {
	public List<Producto>listarTodos() throws Exception;
	public Producto buscarProducto(String id) throws Exception;
	public void guardarProducto(Producto producto) throws Exception;
	public void eliminarProducto(String producto) throws Exception;
}
