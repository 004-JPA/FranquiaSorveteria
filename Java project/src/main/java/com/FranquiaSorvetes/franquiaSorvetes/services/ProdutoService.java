package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.util.HashMap;
import java.util.Map;

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
	public HashMap<String,Number> query2(String nome) {
		return produtoRepository.query2(nome);
	}
	//Query 3
	public Map<String, String> query3() {
		return produtoRepository.query3();
	}
}
