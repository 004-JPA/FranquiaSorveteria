package com.FranquiaSorvetes.franquiaSorvetes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.repositories.EncomendaRepository;
import com.FranquiaSorvetes.model.InfoQueries1e6;

@Service
public class EncomendaService {
	@Autowired //Injeção de dependências.
	EncomendaRepository encomendaRepository;
	public EncomendaService() {
	
	}
	
	//Query 1
	public InfoQueries1e6 query1(String nomeLoja){
		return encomendaRepository.query1(nomeLoja);
	}
	//Query 6
	public InfoQueries1e6 query6(String nomeCliente){
		return encomendaRepository.query6(nomeCliente);
	}
}