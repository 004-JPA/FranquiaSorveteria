package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Model.InfoQuery2;
import Services.ProdutoService;

@RestController
@RequestMapping(value = "/produto") //Classe responsável por todas as requisições da rota /produto.
public class ProdutoController {
	//Definir métodos para subrotas: cada query da rota.
	@Autowired //Injeção de dependências.
	ProdutoService produtoService;
	
	public ProdutoController() {

	}
	
	//Query 2
	public ResponseEntity<InfoQuery2> query2(@RequestParam String nome) {
		InfoQuery2 resposta = produtoService.query2(nome);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.		
	}
	//Query 3
	public ResponseEntity<String> query3() {
		String resposta = produtoService.query3();
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}	
}
