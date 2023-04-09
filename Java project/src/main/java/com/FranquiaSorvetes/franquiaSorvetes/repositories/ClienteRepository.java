package com.FranquiaSorvetes.franquiaSorvetes.repositories;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;
import com.FranquiaSorvetes.model.InfoQueries7e8;

@Repository
public class ClienteRepository {

	private Connection connection = DBManager.getConnection();
	
	public ClienteRepository() {
	}
	
	//Query 8!
	public List<InfoQueries7e8> query8(double valor) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		List<InfoQueries7e8> answerList = new ArrayList<>();
		try {
			query = connection.prepareStatement("select c.nome, c.Email, e.DataPedido from cliente c, encomenda e, produto p where c.IDcliente = e.IDcliente and p.IDproduto = e.IDproduto group by c.IDcliente, e.DataPedido having SUM(Preço) > ?;");
			query.setDouble(1, valor); //Substitui o i-ésimo '?' pelo segundo argumento passado.
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				InfoQueries7e8 answer = new InfoQueries7e8();
				answer.setNomeCliente(queryResult.getString(1)); 
				answer.setEmail(queryResult.getString(2));
				answer.setDataPedido(queryResult.getDate(3));
				answerList.add(answer);
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return answerList;
	}
	
	
	//Query 7!
	public List<InfoQueries7e8> query7(Date dataLimite) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		List<InfoQueries7e8> encomendas = new ArrayList<>();
		
		try {
			query = connection.prepareStatement("SELECT cliente.Nome, cliente.Email, encomenda.DataPedido \r\n"
					+ "FROM encomenda\r\n"
					+ "JOIN cliente ON encomenda.IDCliente = cliente.IDCliente \r\n"
					+ "WHERE DataPedido > ?; \r\n"
					+ "");
			query.setDate(1, dataLimite); //Substitui o i-ésimo '?' pelo segundo argumento passado.
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				InfoQueries7e8 encomenda = new InfoQueries7e8();
				encomenda.setNomeCliente(queryResult.getString(1));
				encomenda.setEmail(queryResult.getString(2));
				encomenda.setDataPedido(queryResult.getDate(3));
				encomendas.add(encomenda);
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return encomendas;
	}
	
}
