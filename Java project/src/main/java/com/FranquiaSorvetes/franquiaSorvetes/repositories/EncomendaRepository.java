package com.FranquiaSorvetes.franquiaSorvetes.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.FranquiaSorvetes.franquiaSorvetes.model.dtos.InfoQueries1e6;
import com.FranquiaSorvetes.franquiaSorvetes.services.DBManager;
@Repository
public class EncomendaRepository {
	private Connection connection;
	
	
	public EncomendaRepository() {
		this.connection = DBManager.getConnection();
	}
	//Query 1: select cliente.Nome, loja.Nome,  from encomenda, cliente, lojawhere IDloja = X;
	public List<InfoQueries1e6> query1(int IDLoja){
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		List<InfoQueries1e6> encomendasLoja = new ArrayList<>();
		try {
			query = connection.prepareStatement("SELECT cliente.Nome, encomenda.DataPedido, SUM(produto.Preço) "
					+ "FROM encomenda JOIN cliente ON encomenda.IDCliente = cliente.IDCliente "
					+ "JOIN loja ON encomenda.IDLoja = loja.IDLoja "
					+ "JOIN produto ON encomenda.IDProduto = produto.IDProduto "
					+ "WHERE loja.IDLoja = ? "
					+ "GROUP BY cliente.nome, encomenda.DataPedido;\r\n");
			query.setInt(1,IDLoja);// Parâmetro nome do cliente
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				InfoQueries1e6 encomenda = new InfoQueries1e6();
				encomenda.setNome(queryResult.getString(1));
				encomenda.setDataPedido(queryResult.getDate(2));
				encomenda.setValor(queryResult.getDouble(3));
				encomendasLoja.add(encomenda);
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}
		
		return encomendasLoja;
	}
		
	//Query 6:
	public List<InfoQueries1e6> query6(String nomeCliente){
		PreparedStatement query = null;	
		ResultSet queryResult = null;
		List<InfoQueries1e6> encomendasCliente = new ArrayList<>();
		try {
			query = connection.prepareStatement("SELECT encomenda.DataPedido, SUM(produto.Preço), loja.Nome\r\n"
					+ "FROM encomenda \r\n"
					+ "JOIN produto ON encomenda.IDProduto = produto.IDProduto\r\n"
					+ "JOIN cliente ON encomenda.IDCliente = cliente.IDCliente\r\n"
					+ "JOIN loja ON encomenda.IDLoja = loja.IDLoja\r\n"
					+ "WHERE cliente.Nome = ?\r\n"
					+ "GROUP BY encomenda.DataPedido, loja.Nome;\r\n"
					+ "");
			query.setString(1,nomeCliente);// Parâmetro nome do cliente
			queryResult = query.executeQuery();
			while(queryResult.next()) {
				InfoQueries1e6 encomenda = new InfoQueries1e6();
				encomenda.setDataPedido(queryResult.getDate(1));
				encomenda.setValor(queryResult.getDouble(2));
				encomenda.setNome(queryResult.getString(3));
				encomendasCliente.add(encomenda);
			}			
		} catch (SQLException e) {		
			throw new RuntimeException (e.getMessage());
		}					
		return encomendasCliente;
	}
	
}
