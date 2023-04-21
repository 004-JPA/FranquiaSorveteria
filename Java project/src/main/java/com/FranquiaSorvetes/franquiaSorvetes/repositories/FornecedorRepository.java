package com.FranquiaSorvetes.franquiaSorvetes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.model.entities.Fornecedor;
import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;
@Repository
public class FornecedorRepository {

	private Connection connection;
	
	public FornecedorRepository() {
		this.connection = DBManager.getConnection();
	}
	
	//Query 9!
		public List<Fornecedor> query9() {
			PreparedStatement query = null;	
			ResultSet queryResult = null;
			List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
			try {
				query = connection.prepareStatement("	select *\r\n"
						+ "	from fornecedor\r\n"
						+ "");
				//query.setString(a,b); Aqui nao tem parâmetro
				queryResult = query.executeQuery();
				while(queryResult.next()) {
					fornecedores.add(new Fornecedor(queryResult.getInt(1), queryResult.getString(2), queryResult.getString(3), queryResult.getString(4)));
				}			
			} catch (SQLException e) {		
				throw new RuntimeException (e.getMessage());
			}					
			return fornecedores;
		}
		
	//Query 5:
		public List<HashMap<String,String>> query5(String endereco) {
			PreparedStatement query = null;	
			ResultSet queryResult = null;
			List<HashMap<String,String>> answerList = new ArrayList<>();
			try {
				query = connection.prepareStatement("select fornecedor.Nome, fornecedor.Endereço from possui "
						+ "join fornecedor on possui.IDFornecedor = fornecedor.IDFornecedor join loja on possui.IDLoja = loja.IDLoja "
						+ "where loja.Nome= ?;");
				query.setString(1,endereco);// Parâmetro nome loja
				queryResult = query.executeQuery();
				while(queryResult.next()) {
					HashMap<String,String> answer = new HashMap<String,String>();
					answer.put("nome", queryResult.getString(1));
					answer.put("endereco", queryResult.getString(2));
					answerList.add(answer);
				}			
			} catch (SQLException e) {		
				throw new RuntimeException (e.getMessage());
			}					
			return answerList;
		}
		
	
}
