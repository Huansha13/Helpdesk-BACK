package com.casopractico.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name="sucursal")
public class Sucursal {

	@NotNull
	@Id
	private String cod_sucursal;
	
	@NotNull
	private String nombre;
	
	public String getCod_sucursal() {
		return cod_sucursal;
	}

	public void setCod_sucursal(String cod_sucursal) {
		this.cod_sucursal = cod_sucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		
}
