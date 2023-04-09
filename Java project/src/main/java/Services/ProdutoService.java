package Services;

import org.springframework.beans.factory.annotation.Autowired;

import Model.InfoQuery2;
import Repositories.ProdutoRepository;

public class ProdutoService {
	@Autowired //Injeção de dependências.
	ProdutoRepository produtoRepository;
	
	public ProdutoService() {

	}
	//Query 2
	public InfoQuery2 query2(String nome) {
		return produtoRepository.query2(nome);
	}
	//Query 3
	public String query3() {
		return produtoRepository.query3();
	}
}
