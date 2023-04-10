package com.FranquiaSorvetes.franquiaSorvetes.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FranquiaSorvetes.franquiaSorvetes.services.FuncionarioService;
import org.springframework.http.ResponseEntity;

@CrossOrigin
@RestController
@RequestMapping(value = "/funcionario") //Classe responsável por todas as requisições da rota /funcionario.
public class FuncionarioController {
	//Definir métodos para subrotas: cada query da rota.
	@Autowired //Injeção de dependências.
	FuncionarioService funcionarioService;
	
	public FuncionarioController() {

	}
	
	//Query 4
	@GetMapping(value="/query4")
	public ResponseEntity<List<HashMap<String,String>>> query4(@RequestParam String nomeLoja){
		List<HashMap<String,String>> resposta = funcionarioService.query4(nomeLoja);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	
}
