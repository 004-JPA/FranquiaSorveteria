package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.InfoQuery2;
import Services.DBManager;

public class ProdutoRepository {
	private Connection connection;
	
		
	public ProdutoRepository() {
		this.connection = DBManager.getConnection();
	}
	//Query 2!
	public InfoQuery2 query2(String nome) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		InfoQuery2 answer = new InfoQuery2();
		try {
			query = connection.prepareStatement("select Nome, COUNT(IDproduto), SUM(Preço) from produto join funcionario on produto.IDFuncionario = funcionario.IDFuncionario where nome = ? group by Nome");
			query.setString(1, nome);
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				answer.setNome(queryResult.getString(1));
				answer.setNumeroVendas(queryResult.getInt(2));
				answer.setTotal(queryResult.getDouble(3));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return answer;
	}
	//Query 3:
	public String query3() {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		//String answer = null;
		try {
			query = connection.prepareStatement("FALTA A QUERY DO IZAQUE");			
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				return new String(queryResult.getString(1));
				//answer = queryResult.getString(1);				
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return null;
		//return answer;
	}
}
