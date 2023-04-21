package com.FranquiaSorvetes.franquiaSorvetes.model;

import java.sql.Date;

public class InfoQueries1e6 {
	Date dataPedido;
	double valor;
	String nome;

	public InfoQueries1e6(Date dataPedido, double valor, String nome) {
		super();
		this.dataPedido = dataPedido;
		this.valor = valor;
		this.nome = nome;
	}

	public InfoQueries1e6() {

	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "InfoQueries1e6 [dataPedido=" + dataPedido + ", valor=" + valor + ", nome=" + nome + "]";
	}
	
	//Getters and setters:
	

}
