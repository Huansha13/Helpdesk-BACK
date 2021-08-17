package com.casopractico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casopractico.dao.SucursalDAO;
import com.casopractico.entity.Sucursal;
import com.casopractico.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

	@Autowired
	SucursalDAO sucursalDAO;
	
	@Override
	public List<Sucursal> listarTodos() throws Exception {
		List<Sucursal>sucursal=(List<Sucursal>) sucursalDAO.findAll();
		return sucursal;
	}

	@Override
	public Sucursal buscarSucursal(String id) throws Exception {
		Sucursal sucursal=sucursalDAO.findById(id).orElse(null);
		return sucursal;
	}

	@Override
	public void guardarSucursal(Sucursal sucursal) throws Exception {
		sucursalDAO.save(sucursal);		
	}

	@Override
	public void eliminarSucursal(String cod_sucursal) throws Exception {
		sucursalDAO.deleteById(cod_sucursal);
		
	}

}
