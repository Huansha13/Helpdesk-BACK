package com.casopractico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casopractico.dao.ProductoDAO;
import com.casopractico.entity.Producto;
import com.casopractico.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDAO productoDAO;
	
	@Override
	public List<Producto> listarTodos() throws Exception {
		List<Producto>productos=(List<Producto>) productoDAO.findAll();
		return productos;
	}

	@Override
	public Producto buscarProducto(String id) throws Exception {
		Producto producto=productoDAO.findById(id).orElse(null);
		return producto;
	}

	@Override
	public void guardarProducto(Producto producto) throws Exception {
		productoDAO.save(producto);		
	}

	@Override
	public void eliminarProducto(String cod_producto) throws Exception {
		productoDAO.deleteById(cod_producto);
		
	}

}
