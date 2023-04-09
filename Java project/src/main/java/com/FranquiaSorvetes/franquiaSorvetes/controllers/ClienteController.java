package com.FranquiaSorvetes.franquiaSorvetes.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FranquiaSorvetes.franquiaSorvetes.services.ClienteService;
import com.FranquiaSorvetes.model.InfoQueries7e8;

@RestController
@RequestMapping(value = "/cliente") //Classe responsável por todas as requisições da rota /cliente.
public class ClienteController {
	//Definir métodos para subrotas: cada query da rota.
	@Autowired //Injeção de dependências.
	ClienteService clienteService;
			
	public ClienteController() {

	}
	
	//Query 8
	@GetMapping(value="/query8")
	public ResponseEntity<InfoQueries7e8> query8(@RequestParam double valor){ //ResponseEntity: classe responsável por dar resposta na web
		InfoQueries7e8 resposta = clienteService.query8(valor);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	//Query 7
	@GetMapping(value="/query7")
	public ResponseEntity<InfoQueries7e8> query7(@RequestParam Date dataLimite){
		InfoQueries7e8 resposta = clienteService.query7(dataLimite);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}

}
