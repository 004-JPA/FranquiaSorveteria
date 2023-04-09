package com.FranquiaSorvetes.franquiaSorvetes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;
import com.FranquiaSorvetes.model.InfoQueries1e6;
@Repository
public class EncomendaRepository {
	private Connection connection;
	
	
	public EncomendaRepository() {
		this.connection = DBManager.getConnection();
	}
	//Query 1: select cliente.Nome, loja.Nome,  from encomenda, cliente, lojawhere IDloja = X;
	public InfoQueries1e6 query1(String nomeLoja){
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		InfoQueries1e6 encomendasLoja = new InfoQueries1e6();
		try {
			query = connection.prepareStatement("SELECT cliente.Nome, encomenda.DataPedido, encomenda.Valor" 
												+ " FROM encomenda JOIN cliente ON" 
												+ " encomenda.IDCliente = cliente.IDCliente JOIN loja ON encomenda.IDLoja = loja.IDLoja WHERE loja.IDLoja = ?;");
			query.setString(1,nomeLoja);// Parâmetro nome do cliente
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				encomendasLoja.setNome(queryResult.getString(1));
				encomendasLoja.setDataPedido(queryResult.getDate(2));
				encomendasLoja.setValor(queryResult.getDouble(3));				
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return encomendasLoja;
	}
	
	
	//Query 6:
	public InfoQueries1e6 query6(String nomeCliente){
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		InfoQueries1e6 encomendasCliente = new InfoQueries1e6();
		try {
			query = connection.prepareStatement("SELECT encomenda.DataPedido, encomenda.Valor, loja.Nome\r\n"
					+ "FROM encomenda JOIN cliente ON encomenda.IDCliente = cliente.IDCliente\r\n"
					+ "JOIN loja ON encomenda.IDLoja = loja.IDLoja\r\n"
					+ "WHERE cliente.Nome = ?;\r\n"
					+ "");
			query.setString(1,nomeCliente);// Parâmetro nome do cliente
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				encomendasCliente.setDataPedido(queryResult.getDate(1));
				encomendasCliente.setValor(queryResult.getDouble(2));
				encomendasCliente.setNome(queryResult.getString(3));
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return encomendasCliente;
	}
	
}
