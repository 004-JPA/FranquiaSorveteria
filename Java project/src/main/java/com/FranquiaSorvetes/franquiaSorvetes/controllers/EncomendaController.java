package com.FranquiaSorvetes.franquiaSorvetes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FranquiaSorvetes.franquiaSorvetes.services.EncomendaService;
import com.FranquiaSorvetes.model.InfoQueries1e6;

@RestController
@RequestMapping(value="/encomenda") //Classe responsável por todas as requisições da rota /encomenda.

public class EncomendaController {
	//Definir métodos para subrotas: cada query da rota.
	@Autowired //Injeção de dependências.
	EncomendaService encomendaService;
		
	public EncomendaController() {

	}

	//Query 1:
	@GetMapping(value="/query1")
	public ResponseEntity<InfoQueries1e6> query1(@RequestParam String nomeLoja){
		InfoQueries1e6 resposta = encomendaService.query1(nomeLoja);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	//Query 6:
	@GetMapping(value="/query6")
	public ResponseEntity<InfoQueries1e6> query6(@RequestParam String nomeCliente){
		InfoQueries1e6 resposta = encomendaService.query6(nomeCliente);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	
	
	
}
