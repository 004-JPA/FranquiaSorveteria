package com.FranquiaSorvetes.model;

public class InfoQuery8 {
	String nome;
	String email;
	double valor;
	
	public InfoQuery8(String nome, String email, double valor) {
		super();
		this.nome = nome;
		this.email = email;
		this.valor = valor;
	}

//Getters e setters:	
	public InfoQuery8() {
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
		
}
