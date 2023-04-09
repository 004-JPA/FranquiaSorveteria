package com.FranquiaSorvetes.model;

public class Fornecedor {
	int IDfornecer;
	String nome, endereco, cidade;
	
	public Fornecedor(int id, String n, String end, String c) {
		this.IDfornecer = id;
		this.cidade = c;
		this.nome = n;
		this.endereco = end;
	}

	public Fornecedor() {
		
	}
	
//Getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getIDfornecer() {
		return IDfornecer;
	}
	
	
}
