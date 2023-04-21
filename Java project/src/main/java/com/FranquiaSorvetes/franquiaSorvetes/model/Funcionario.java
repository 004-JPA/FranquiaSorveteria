package com.FranquiaSorvetes.franquiaSorvetes.model;

public class Funcionario {
	int IDfuncionario, CPF;
	double salario;
	String nome;
	
	public Funcionario(int ID, int CPF, double sal, String n) {
		this.IDfuncionario = ID;
		this.CPF = CPF;
		this.nome = n;
		this.salario = sal;
	}
	
	public Funcionario() {
		
	}

	
//Getters and setters
	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIDfuncionario() {
		return IDfuncionario;
	}
	
	
}
