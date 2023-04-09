package com.FranquiaSorvetes.model;

public class InfoQuery2 {
	String nome;
	int numeroVendas;
	double total;
	
	public InfoQuery2(String nome, int numeroVendas, double total) {
		super();
		this.nome = nome;
		this.numeroVendas = numeroVendas;
		this.total = total;
	}
	public InfoQuery2() {
		
	}
//Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroVendas() {
		return numeroVendas;
	}

	public void setNumeroVendas(int numeroVendas) {
		this.numeroVendas = numeroVendas;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
		
}
