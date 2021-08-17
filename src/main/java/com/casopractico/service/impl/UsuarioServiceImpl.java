package com.casopractico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casopractico.dao.ProductoDAO;
import com.casopractico.dao.SucursalDAO;
import com.casopractico.dao.UsuarioDAO;
import com.casopractico.entity.Sucursal;
import com.casopractico.entity.Usuario;
import com.casopractico.service.SucursalService;
import com.casopractico.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> listarTodos() throws Exception {
		List<Usuario>usuario=(List<Usuario>) usuarioDAO.findAll();
		return usuario;
	}

	@Override
	public Usuario buscarUsuario(String id) throws Exception {
		Usuario usuario=usuarioDAO.findById(id).orElse(null);
		return usuario;
	}

	@Override
	public void guardarUsuario(Usuario usuario) throws Exception {
		usuarioDAO.save(usuario);		
	}

	@Override
	public void eliminarUsuario(String cod_usuario) throws Exception {
		usuarioDAO.deleteById(cod_usuario);
		
	}

}
