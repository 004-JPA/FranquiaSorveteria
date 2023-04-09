package Controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Services.ClienteService;

@RestController
@RequestMapping(value = "/cliente") //Classe responsável por todas as requisições da rota /cliente.
public class ClienteController {
	//Definir métodos para subrotas: cada query da rota.
	@Autowired //Injeção de dependências.
	ClienteService clienteService;
			
	public ClienteController() {

	}
	
	//Query 8
	public ResponseEntity<List<String>> query8(@RequestParam double valor){ //ResponseEntity: classe responsável por dar resposta na web
		List<String> resposta = clienteService.query8(valor);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}
	//Query 7
	public ResponseEntity<HashMap<String, Date>> query7(@RequestParam Date dataLimite){
		HashMap<String,Date> resposta = clienteService.query7(dataLimite);
		return ResponseEntity.ok().body(resposta); //resposta = resultado da chamada de método do service.
	}

}
