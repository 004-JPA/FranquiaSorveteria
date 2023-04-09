package com.FranquiaSorvetes.franquiaSorvetes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;

@Repository
public class ProdutoRepository {
	private Connection connection;
	
		
	public ProdutoRepository() {
		this.connection = DBManager.getConnection();
	}
	//Query 2!
	public HashMap<Integer,Double> query2(String nome) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		HashMap<Integer,Double> answer = new HashMap<Integer,Double>();
		try {
			query = connection.prepareStatement("select COUNT(IDproduto), SUM(Preco) from produto join funcionario on produto.IDFuncionario"
												+ " = funcionario.IDFuncionario where funcionario.Nome = ? group by Nome;");
			query.setString(1, nome);
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				answer.put(queryResult.getInt(1),queryResult.getDouble(2));
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
			query = connection.prepareStatement("SELECT Tipo as quantity FROM produto "
					+ "GROUP BY Tipo "
					+ "ORDER BY quantity "
					+ "DESC LIMIT 1;");			
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
