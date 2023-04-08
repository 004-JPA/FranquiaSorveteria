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

public class EncomendaRepository {
	private Connection connection;
	
	
	public EncomendaRepository() {
		this.connection = DBManager.getConnection();
	}
	//Query 1: select cliente.Nome, loja.Nome,  from encomenda, cliente, lojawhere IDloja = X;
	public HashMap<String,Date> query1(String nomeLoja){
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		HashMap<String,Date> encomendasLoja = new HashMap<String,Date>();
		try {
			query = connection.prepareStatement("SELECT cliente.Nome, encomenda.DataPedido\r\n"
					+ "FROM encomenda JOIN cliente ON encomenda.IDCliente = cliente.IDCliente\r\n"
					+ "JOIN loja ON encomenda.IDLoja = loja.IDLoja\r\n"
					+ "WHERE loja.IDLoja = ?;\r\n"
					+ "");
			query.setString(1,nomeLoja);// Parâmetro nome do cliente
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				encomendasLoja.put(queryResult.getString(2), queryResult.getDate(2));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return encomendasLoja;
	}
	
	
	//Query 6:
	public HashMap<String,String> query6(String nomeCliente){
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		HashMap<String,String> encomendasCliente = new HashMap<String,String>();
		try {
			query = connection.prepareStatement("SELECT cliente.Nome, loja.Nome\r\n"
					+ "FROM encomenda JOIN cliente ON encomenda.IDCliente = cliente.IDCliente\r\n"
					+ "");
			query.setString(1,nomeCliente);// Parâmetro nome do cliente
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				encomendasCliente.put(queryResult.getString(2), queryResult.getString(2));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return encomendasCliente;
	}
	
}
