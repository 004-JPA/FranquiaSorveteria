package com.FranquiaSorvetes.franquiaSorvetes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;
@Repository
public class FuncionarioRepository {
	
		
	private Connection connection;
		
	public FuncionarioRepository() {
		this.connection = DBManager.getConnection();
	}
	
	//Metodo que retorna a query 4!
	public HashMap<String,Integer> query4(String nomeLoja) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		HashMap<String,Integer> answer = new HashMap<String,Integer>();
		try {
			query = connection.prepareStatement("select funcionario.Nome, funcionario.CPF as quantidade_funcionarios"
												+ " from funcionario, loja where loja.IDloja = funcionario.IDloja and"
												+ " loja.nome = ?;");
			query.setString(1, nomeLoja);
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				answer.put(queryResult.getString(1), queryResult.getInt(2));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return answer;
	}
}
