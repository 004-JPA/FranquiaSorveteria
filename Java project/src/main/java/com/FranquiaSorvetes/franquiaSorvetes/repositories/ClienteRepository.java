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
import com.FranquiaSorvetes.model.InfoQuery7;
import com.FranquiaSorvetes.model.InfoQuery8;

@Repository
public class ClienteRepository {

	private Connection connection = DBManager.getConnection();
	
	public ClienteRepository() {
	}
	
	//Query 8!
	public List<InfoQuery8> query8(double valor) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		List<InfoQuery8> answerList = new ArrayList<>();
		try {
			query = connection.prepareStatement("select c.nome, c.Email, SUM(Preço) from cliente c, encomenda e, produto p where c.IDcliente ="
												+ " e.IDcliente and p.IDproduto = e.IDproduto group by c.IDcliente"
												+ " having SUM(Preço) > ?;");
			query.setDouble(1, valor); //Substitui o i-ésimo '?' pelo segundo argumento passado.
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				InfoQuery8 answer = new InfoQuery8();
				answer.setNome(queryResult.getString(1)); 
				answer.setEmail(queryResult.getString(2));
				answer.setValor(queryResult.getDouble(3));
				answerList.add(answer);
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return answerList;
	}
	
	
	//Query 7!
	public List<InfoQuery7> query7(Date dataLimite) {
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		List<InfoQuery7> encomendas = new ArrayList<>();
		
		try {
			query = connection.prepareStatement("SELECT cliente.Nome, cliente.Email, encomenda.DataPedido \r\n"
					+ "FROM encomenda\r\n"
					+ "JOIN cliente ON encomenda.IDCliente = cliente.IDCliente \r\n"
					+ "WHERE DataPedido > ? "
					+ "GROUP BY cliente.Nome, cliente.Email, encomenda.DataPedido;"
					+ "");
			query.setDate(1, dataLimite); //Substitui o i-ésimo '?' pelo segundo argumento passado.
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				InfoQuery7 encomenda = new InfoQuery7();
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
