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
import com.casopractico.service.SucursalService;

@RestController()
@RequestMapping("/sucursal")
@CrossOrigin(origins = {"*"})
public class SucursalController
{
	@Autowired
	SucursalService sucursalService;
	
	@GetMapping("/listar")
	@Transactional(readOnly = true) 
	public List<Sucursal> listarTodos() throws Exception
	{
		return sucursalService.listarTodos(); 
	}
	@GetMapping("/buscar/{id}")
	@Transactional(readOnly = true)
	public Sucursal buscarSucursal(@PathVariable String id) throws Exception
	{
		return sucursalService.buscarSucursal(id);
	}
	@PostMapping("/guardar")
	public void guardarSucursal(@RequestBody Sucursal sucursal) throws Exception 
	{		
			if (sucursal.getCod_sucursal()!=null) {
				sucursalService.guardarSucursal(sucursal);
				System.out.println("Registro exitoso");
			}
			else
			{
				System.out.println("Error: Vacio");
			}
	}
	@DeleteMapping("/eliminar/{cod_sucursal}")
	public void eliminarSucursal(@PathVariable String cod_sucursal) throws Exception 
	{
		sucursalService.eliminarSucursal(cod_sucursal);
		System.out.println("Registro eliminado");
	}
	@PutMapping("/modificar/{cod_sucursal}")
	public void modificarSucursal(@PathVariable String cod_sucursal,@RequestBody Sucursal sucursal) throws Exception 
	{
		Sucursal sucursalobj=sucursalService.buscarSucursal(cod_sucursal);
		if (sucursalobj.getCod_sucursal()!=null) {
			sucursalobj.setNombre(sucursal.getNombre());
			sucursalService.guardarSucursal(sucursalobj);
			System.out.println("Registro actualizado");
		}
	}
}
