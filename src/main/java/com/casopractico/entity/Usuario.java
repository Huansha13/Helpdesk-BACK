package com.casopractico.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	private String cod_usuario;
	
	@NotNull
	private String nombre;
	
	@NotNull
	//@Column(name="user")
	private String usuario;
	
	@NotNull
	//@Column(name="clave")
	private String clave;
	
	@ManyToOne
	private Sucursal sucursal;
	
	public Usuario() {
		
	}

	public String getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(String cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Usuario(String cod_usuario, String nombre, String usuario, String clave, Sucursal sucursal) {
		this.cod_usuario = cod_usuario;
		this.nombre = nombre;
		this.usuario = usuario;
		this.clave = clave;
		this.sucursal = sucursal;
	}

	
	
	
}
