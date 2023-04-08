package Model;

public class Loja {
	int IDloja;
	String nome, telefone, endereco;
	
	public Loja(int ID, String n, String tel, String end) {
		this.endereco = end;
		this.IDloja = ID;
		this.nome = n;
		this.telefone = tel;
	}
	
	public Loja() {
		
	}
//Getters and setters:	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIDloja() {
		return IDloja;
	}
			
}
