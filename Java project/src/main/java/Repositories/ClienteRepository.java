package Repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Services.DBManager;

public class ClienteRepository {

	private Connection connection;
	
	public ClienteRepository() {
		this.connection = DBManager.getConnection();
	}

	//Query 8!
	public List<String> query8(String valor) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		List<String> nomes = new ArrayList<String>();
		try {
			query = connection.prepareStatement("select nome from Cliente c, Encomenda e, Produto p where c.IDcliente = e.IDcliente and p.IDproduto = e.IDproduto\r\n"
					+ "group by c.IDcliente having SUM(preço) > ?;");
			query.setString(1, valor); //Substitui o i-ésimo '?' pelo segundo argumento passado.
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				nomes.add(queryResult.getString(1));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return nomes;
	}
	
	
	//Query 7!
	public HashMap<String, Date> query7(Date dataLimite) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		HashMap<String, Date> encomendas = new HashMap<String, Date>();
		try {
			query = connection.prepareStatement("SELECT Nome, DataPedido FROM Encomendas JOIN Clientes ON Encomendas.IDCliente = Clientes.ID WHERE DataPedido > ?;");
			query.setDate(1, dataLimite); //Substitui o i-ésimo '?' pelo segundo argumento passado.
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				encomendas.put(queryResult.getString(1), queryResult.getDate(2));
				//nomes.add(queryResult.getString(1));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return encomendas;
	}
	
}
