package Model;

public class Cliente {
	int IDcliente;
	String nome, endereco, email;
	
	public Cliente(int id,String n,String end, String email) {
		this.IDcliente = id;
		this.endereco = end;
		this.nome = n;
		this.email = email;
	}

	public Cliente() {
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIDcliente() {
		return IDcliente;
	}
	
}
