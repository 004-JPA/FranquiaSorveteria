package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.repositories.VendaRepository;

@Service
public class VendaService {
	@Autowired //Injeção de dependências.
	VendaRepository produtoRepository;
	
	public VendaService() {

	}
	//Query 2
	public HashMap<String,Number> query2(String nome) {
		return produtoRepository.query2(nome);
	}
	//Query 3
	public String query3() {
		return produtoRepository.query3();
	}
}
