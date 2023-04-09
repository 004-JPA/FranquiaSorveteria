package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Model.Fornecedor;
import Repositories.FornecedorRepository;

public class FornecedorService {
	@Autowired //Injeção de dependências.
	FornecedorRepository fornecedorRepository;
	

	public FornecedorService() {
		// TODO Auto-generated constructor stub
	}
	
	//Query 5
	public List<String> query5(String nomeLoja){
		return fornecedorRepository.query5(nomeLoja);
	}
	//Query 9
	public List<Fornecedor> query9(){
		return fornecedorRepository.query9();
	}
}
