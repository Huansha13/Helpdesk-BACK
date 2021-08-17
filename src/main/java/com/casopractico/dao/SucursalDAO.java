package com.casopractico.dao;

import org.springframework.data.repository.CrudRepository;

import com.casopractico.entity.Sucursal;


public interface SucursalDAO extends CrudRepository<Sucursal, String> {
	
}