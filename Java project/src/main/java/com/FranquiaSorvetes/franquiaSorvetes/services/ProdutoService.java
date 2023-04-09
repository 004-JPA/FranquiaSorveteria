package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired //Injeção de dependências.
	ProdutoRepository produtoRepository;
	
	public ProdutoService() {

	}
	//Query 2
	public HashMap<Integer,Double> query2(String nome) {
		return produtoRepository.query2(nome);
	}
	//Query 3
	public String query3() {
		return produtoRepository.query3();
	}
}
