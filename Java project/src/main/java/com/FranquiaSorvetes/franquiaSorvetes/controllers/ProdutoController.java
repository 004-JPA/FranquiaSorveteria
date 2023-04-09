package com.FranquiaSorvetes.franquiaSorvetes.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FranquiaSorvetes.franquiaSorvetes.services.ProdutoService;



@RestController
@RequestMapping(value = "/produto") //Classe responsável por todas as requisições da rota /produto.
public class ProdutoController {
	//Definir métodos para subrotas: cada query da rota.
	@Autowired //Injeção de dependências.
	ProdutoService produtoService;
	
	public ProdutoController() {

	}
	
	//Query 2
	@GetMapping(value="/query2")
	public ResponseEntity<HashMap<Integer,Double>> query2(@RequestParam String nome) {
		HashMap<Integer,Double> resposta = produtoService.query2(nome);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.		
	}
	//Query 3
	@GetMapping(value="/query3")
	public ResponseEntity<String> query3() {
		String resposta = produtoService.query3();
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}	
}