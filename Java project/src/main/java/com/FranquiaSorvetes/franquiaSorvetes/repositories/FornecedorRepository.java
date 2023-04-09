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
import com.FranquiaSorvetes.model.Fornecedor;
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
		public HashMap<String,String> query5(int idLoja) {
			PreparedStatement query = null;	
			ResultSet queryResult = null;
			HashMap<String,String> answer = new HashMap<String,String>();
			try {
				query = connection.prepareStatement("select Nome, fornecedor.Endereco from possui join fornecedor on"
													+ " possui.IDFornecedor = fornecedor.IDFornecedor where IDLoja = ?;");
				query.setInt(1,idLoja);// Parâmetro nome loja
				queryResult = query.executeQuery();
				while(queryResult.next()) {
					answer.put(queryResult.getString(1), queryResult.getString(2));
				}			
			} catch (SQLException e) {		
				throw new RuntimeException (e.getMessage());
			}					
			return answer;
		}
		
	
}
