package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.sql.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.repositories.EncomendaRepository;

@Service
public class EncomendaService {
	@Autowired //Injeção de dependências.
	EncomendaRepository encomendaRepository;
	public EncomendaService() {
	
	}
	
	//Query 1
	public HashMap<String,Date> query1(String nomeLoja){
		return encomendaRepository.query1(nomeLoja);
	}
	//Query 6
	public HashMap<String,String> query6(String nomeCliente){
		return encomendaRepository.query6(nomeCliente);
	}
}