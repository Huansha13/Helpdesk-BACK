package com.casopractico.dao;

import org.springframework.data.repository.CrudRepository;

import com.casopractico.entity.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, String> {
	
}