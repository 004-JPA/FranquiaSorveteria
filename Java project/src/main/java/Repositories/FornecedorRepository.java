package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Fornecedor;
import Services.DBManager;

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
						+ "	from fornecedores\r\n"
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
		public List<String> query5(String nomeLoja) {
			PreparedStatement query = null;	
			ResultSet queryResult = null;
			List<String> nomes = new ArrayList<String>();
			try {
				query = connection.prepareStatement("SELECT Nome \r\n"
						+ "FROM possui \r\n"
						+ "JOIN fornecedor ON possui.IDFornecedor = fornecedor.IDFornecedor\r\n"
						+ "WHERE IDLoja = ?;\r\n"
						+ "");
				query.setString(1,nomeLoja);// Parâmetro nome loja
				queryResult = query.executeQuery();
				while(queryResult.next()) {
					nomes.add(queryResult.getString(1));
				}			
			} catch (SQLException e) {		
				throw new RuntimeException (e.getMessage());
			}					
			return nomes;
		}
		
	
}
