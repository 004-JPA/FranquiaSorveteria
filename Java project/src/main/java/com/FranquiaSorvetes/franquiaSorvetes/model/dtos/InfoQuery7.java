package com.FranquiaSorvetes.franquiaSorvetes.model.dtos;

import java.sql.Date;

public class InfoQuery7 {
	String nomeCliente;
	String email;
	Date dataPedido;
	
	public InfoQuery7(String nomeCliente, String email, Date dataPedido) {
		super();
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.dataPedido = dataPedido;
	}
	
	public InfoQuery7() {
	
	}
//Getters e setters:

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}	
}
