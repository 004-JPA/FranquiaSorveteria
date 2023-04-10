package com.FranquiaSorvetes.franquiaSorvetes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;

@Repository
public class ProdutoRepository {
	private Connection connection;
	
		
	public ProdutoRepository() {
		this.connection = DBManager.getConnection();
	}
	//Query 2!
	public HashMap<String,Number> query2(String nome) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		HashMap<String,Number> answer = new HashMap<String,Number>();
		try {
			query = connection.prepareStatement("select COUNT(IDproduto), SUM(Preço) from produto join funcionario on produto.IDFuncionario"
												+ " = funcionario.IDFuncionario where funcionario.Nome = ? group by funcionario.Nome;");
			query.setString(1, nome);
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				answer.put("Quantidade",queryResult.getInt(1));
				answer.put("Valor",queryResult.getDouble(2));
			}
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}
		return answer;
	}
	//Query 3:
	public Map<String, String> query3() {
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
				Map<String, String> answer = new HashMap<>();
				answer.put("tipo", queryResult.getString(1));
				return answer;
				//answer = queryResult.getString(1);				
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return null;
		//return answer;
	}
}
