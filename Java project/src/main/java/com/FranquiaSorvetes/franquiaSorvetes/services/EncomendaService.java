package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.model.dtos.InfoQueries1e6;
import com.FranquiaSorvetes.franquiaSorvetes.repositories.EncomendaRepository;

@Service
public class EncomendaService {
	@Autowired //Injeção de dependências.
	EncomendaRepository encomendaRepository;
	public EncomendaService() {
	
	}
	
	//Query 1
	public List<InfoQueries1e6> query1(int IDLoja){
		return encomendaRepository.query1(IDLoja);
	}
	//Query 6
	public List<InfoQueries1e6> query6(String nomeCliente){
		return encomendaRepository.query6(nomeCliente);
	}
}