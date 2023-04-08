package Model;

public class Produto {
	int IDproduto;
	double preco;
	String nome, tipo;
	
	public Produto(int ID, double p, String n, String tipo) {
		this.IDproduto = ID;
		this.nome = n;
		this.preco = p;
		this.tipo = tipo;
	}
	
	public Produto() {
		
	}
//Getters and setters
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIDproduto() {
		return IDproduto;
	}
	
	
}
