package com.FranquiaSorvetes.franquiaSorvetes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FranquiaSorvetes.franquiaSorvetes.model.InfoQueries1e6;
import com.FranquiaSorvetes.franquiaSorvetes.services.EncomendaService;

@CrossOrigin
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
	public ResponseEntity<List<InfoQueries1e6>> query1(@RequestParam int IDLoja){
		List<InfoQueries1e6> resposta = encomendaService.query1(IDLoja);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	//Query 6:
	@GetMapping(value="/query6")
	public ResponseEntity<List<InfoQueries1e6>> query6(@RequestParam String nomeCliente){
		List<InfoQueries1e6> resposta = encomendaService.query6(nomeCliente);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	
	
	
}
