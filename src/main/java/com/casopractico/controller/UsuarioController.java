package com.casopractico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casopractico.entity.Sucursal;
import com.casopractico.entity.Usuario;
import com.casopractico.service.UsuarioService;

@RestController()
@RequestMapping("/usuario")
@CrossOrigin(origins = {"*"})
public class UsuarioController
{
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/listar")
	@Transactional(readOnly = true) 
	public List<Usuario> listarTodos() throws Exception
	{
		return usuarioService.listarTodos(); 
	}
	@GetMapping("/buscar/{id}")
	@Transactional(readOnly = true)
	public Usuario buscarUsuario(@PathVariable String id) throws Exception
	{
		return usuarioService.buscarUsuario(id);
	}
	@PostMapping("/guardar")
	public void guardarUsuario(@RequestBody Usuario usuario) throws Exception 
	{		
			if (usuario.getCod_usuario()!=null) {
				usuarioService.guardarUsuario(usuario);
				System.out.println("Registro exitoso");
			}
			else
			{
				System.out.println("Error: Vacio");
			}
	}
	@DeleteMapping("/eliminar/{cod_usuario}")
	public void eliminarUsuario(@PathVariable String cod_usuario) throws Exception 
	{
		usuarioService.eliminarUsuario(cod_usuario);
		System.out.println("Registro eliminado");
	}
	@PutMapping("/modificar/{cod_usuario}")
	public void modificarUsuario(@PathVariable String cod_usuario,@RequestBody Usuario usuario) throws Exception 
	{
		Usuario usuariobj=usuarioService.buscarUsuario(cod_usuario);
		if (usuariobj.getCod_usuario()!=null) {
			usuariobj.setNombre(usuario.getNombre());
			usuariobj.setClave(usuario.getClave());
			Sucursal sucursal = new Sucursal();
			sucursal.setCod_sucursal(usuario.getSucursal().getCod_sucursal());
			sucursal.setNombre(usuario.getSucursal().getNombre());
			usuariobj.setSucursal(sucursal);
			usuarioService.guardarUsuario(usuariobj);
			System.out.println("Registro actualizado");
		}
	}
}
