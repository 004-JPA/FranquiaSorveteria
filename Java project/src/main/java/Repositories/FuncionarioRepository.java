package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Services.DBManager;

public class FuncionarioRepository {
	
		
	private Connection connection;
		
	public FuncionarioRepository() {
		this.connection = DBManager.getConnection();
	}
	
	//Metodo que retorna a query 4!
	public int query4(String nomeLoja) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		int answer = 0;
		try {
			query = connection.prepareStatement("select COUNT(*) as quantidade_funcionarios from funcionario, loja where loja.IDloja = funcionario.IDloja and loja.nome = ?;");
			query.setString(1, nomeLoja);
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				answer = queryResult.getInt(1);
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return answer;
	}
}
