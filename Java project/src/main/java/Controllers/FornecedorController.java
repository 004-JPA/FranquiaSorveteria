package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Model.Fornecedor;
import Services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedor") //Classe responsável por todas as requisições da rota /fornecedor.
public class FornecedorController {
	//Definir métodos para subrotas: cada query da rota.
	@Autowired //Injeção de dependências.
	FornecedorService fornecedorService;
	
	public FornecedorController() {
	
	}
	
	//Query 5
	public ResponseEntity<List<String>> query5(@RequestParam String nomeLoja) { //ResponseEntity: classe responsável por dar resposta na web
		List<String> resposta = fornecedorService.query5(nomeLoja);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	//Query 9
	public ResponseEntity<List<Fornecedor>> query9(){
		List<Fornecedor> resposta = fornecedorService.query9();
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	
}
