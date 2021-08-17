package com.casopractico.dao;

import org.springframework.data.repository.CrudRepository;

import com.casopractico.entity.Producto;

public interface ProductoDAO extends CrudRepository<Producto, String> {
	
}