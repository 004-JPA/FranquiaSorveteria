package com.FranquiaSorvetes.franquiaSorvetes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;

@Repository
public class VendaRepository {
	private Connection connection;
	
		
	public VendaRepository() {
		this.connection = DBManager.getConnection();
	}
	//Query 2!
	public HashMap<String,Number> query2(String nome) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		HashMap<String,Number> answer = new HashMap<String,Number>();
		try {
			query = connection.prepareStatement("SELECT COUNT(produto.IDproduto), SUM(Preço) FROM venda \r\n"
					+ "JOIN funcionario ON venda.IDFuncionario = funcionario.IDFuncionario \r\n"
					+ "JOIN produto ON produto.IDProduto=venda.IDProduto \r\n"
					+ "WHERE funcionario.Nome = ?\r\n"
					+ "GROUP BY funcionario.Nome;\r\n"
					+ "");
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
	public String query3() {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		//String answer = null;
		try {
			query = connection.prepareStatement("select Tipo as quantity from produto p, venda v where  p.IDProduto = v.IDProduto group by Tipo order by quantity desc limit 1;");			
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
