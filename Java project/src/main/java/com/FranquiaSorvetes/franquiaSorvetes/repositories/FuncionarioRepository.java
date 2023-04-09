package com.FranquiaSorvetes.franquiaSorvetes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;
@Repository
public class FuncionarioRepository {
	
		
	private Connection connection;
		
	public FuncionarioRepository() {
		this.connection = DBManager.getConnection();
	}
	
	//Metodo que retorna a query 4!
	public List<HashMap<String,String>> query4(String nomeLoja) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		List<HashMap<String,String>> answerList = new ArrayList<>();
		try {
			query = connection.prepareStatement("select funcionario.Nome, funcionario.CPF as quantidade_funcionarios"
												+ " from funcionario, loja where loja.IDloja = funcionario.IDloja and"
												+ " loja.nome = ?;");
			query.setString(1, nomeLoja);
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				HashMap<String,String> answer = new HashMap<String,String>();
				answer.put("Nome", queryResult.getString(1));
				answer.put("CPF", queryResult.getString(2));
				answerList.add(answer);
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return answerList;
	}
}
