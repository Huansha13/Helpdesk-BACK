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

import com.casopractico.entity.Producto;
import com.casopractico.service.ProductoService;

@RestController()
@RequestMapping("/producto")
@CrossOrigin(origins = {"*"})
public class ProductoController
{
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/listar")
	@Transactional(readOnly = true) 
	public List<Producto> listarTodos() throws Exception
	{
		return productoService.listarTodos(); 
	}
	@GetMapping("/buscar/{id}")
	@Transactional(readOnly = true)
	public Producto buscarProducto(@PathVariable String id) throws Exception
	{
		return productoService.buscarProducto(id);
	}
	@PostMapping("/guardar")
	public void guardarProducto(@RequestBody Producto producto) throws Exception 
	{
		if (producto.getCod_producto()!=null) {
			productoService.guardarProducto(producto);
			System.out.println("Registro exitoso");
		}
		else
		{
			System.out.println("Error: Vacio");
		}
	}
	@DeleteMapping("/eliminar/{cod_producto}")
	public void eliminarProducto(@PathVariable String cod_producto) throws Exception 
	{
		//Producto producto=productoService.buscarProducto(cod_producto);
		productoService.eliminarProducto(cod_producto);
		System.out.println("Registro eliminado");
	}
	@PutMapping("/modificar/{cod_producto}")
	public void modificarProducto(@PathVariable String cod_producto,@RequestBody Producto producto) throws Exception 
	{
		Producto productobj=productoService.buscarProducto(cod_producto);
		if (productobj.getCod_producto()!=null) {
			productobj.setNombre(producto.getNombre());
			productobj.setPrecio(producto.getPrecio());
			productoService.guardarProducto(productobj);
			System.out.println("Registro modificado");
		}
		
	}
}
