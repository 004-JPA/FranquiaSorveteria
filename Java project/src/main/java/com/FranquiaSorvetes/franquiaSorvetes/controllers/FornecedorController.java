package com.FranquiaSorvetes.franquiaSorvetes.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FranquiaSorvetes.franquiaSorvetes.services.FornecedorService;
import com.FranquiaSorvetes.model.Fornecedor;

@CrossOrigin
@RestController
@RequestMapping(value = "/fornecedor") //Classe responsável por todas as requisições da rota /fornecedor.
public class FornecedorController {
	//Definir métodos para subrotas: cada query da rota.
	@Autowired //Injeção de dependências.
	FornecedorService fornecedorService;
	
	public FornecedorController() {
	
	}
	
	//Query 5
	@GetMapping(value="/query5")
	public ResponseEntity<List<HashMap<String,String>> > query5(@RequestParam String nomeLoja) { //ResponseEntity: classe responsável por dar resposta na web
		List<HashMap<String,String>> resposta = fornecedorService.query5(nomeLoja);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	//Query 9
	@GetMapping(value="/query9")
	public ResponseEntity<List<Fornecedor>> query9(){
		List<Fornecedor> resposta = fornecedorService.query9();
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	
}
