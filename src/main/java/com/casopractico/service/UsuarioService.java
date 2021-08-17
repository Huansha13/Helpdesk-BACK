package com.casopractico.service;

import java.util.List;

import com.casopractico.entity.Usuario;

public interface UsuarioService {
	public List<Usuario>listarTodos() throws Exception;
	public Usuario buscarUsuario(String id) throws Exception;
	public void guardarUsuario(Usuario usuario) throws Exception;
	public void eliminarUsuario(String usuario) throws Exception;
}
