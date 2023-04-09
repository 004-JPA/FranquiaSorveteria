package com.FranquiaSorvetes.franquiaSorvetes.repositories;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;
import com.FranquiaSorvetes.model.InfoQueries7e8;

@Repository
public class ClienteRepository {

	private Connection connection = DBManager.getConnection();
	
	public ClienteRepository() {
	}
	
	//Query 8!
	public InfoQueries7e8 query8(double valor) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		InfoQueries7e8 answer = new InfoQueries7e8();
		try {
			query = connection.prepareStatement("select c.nome c.Email, e.DataPedido from cliente c, encomenda e, produto p where c.IDcliente = e.IDcliente and p.IDproduto = e.IDproduto group by c.IDcliente having SUM(preco) > ?;");
			query.setDouble(1, valor); //Substitui o i-ésimo '?' pelo segundo argumento passado.
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				answer.setNomeCliente(queryResult.getString(1)); 
				answer.setEmail(queryResult.getString(2));
				answer.setDataPedido(queryResult.getDate(3));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return answer;
	}
	
	
	//Query 7!
	public InfoQueries7e8 query7(Date dataLimite) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		InfoQueries7e8 encomendas = new InfoQueries7e8();
		try {
			query = connection.prepareStatement("SELECT cliente.Nome, cliente.Email, encomenda.DataPedido \r\n"
					+ "FROM encomenda\r\n"
					+ "JOIN cliente ON encomenda.IDCliente = cliente.IDCliente \r\n"
					+ "WHERE DataPedido > ?; \r\n"
					+ "");
			query.setDate(1, dataLimite); //Substitui o i-ésimo '?' pelo segundo argumento passado.
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				encomendas.setNomeCliente(queryResult.getString(1));
				encomendas.setEmail(queryResult.getString(2));
				encomendas.setDataPedido(queryResult.getDate(3));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return encomendas;
	}
	
}
