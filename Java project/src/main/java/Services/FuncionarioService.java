package Services;

import org.springframework.beans.factory.annotation.Autowired;

import Repositories.FuncionarioRepository;

public class FuncionarioService {
	@Autowired //Injeção de dependências.
	FuncionarioRepository funcionarioRepository;
	public FuncionarioService() {
		
	}

	//Query 4
	public int query4(String nomeLoja) {
		return funcionarioRepository.query4(nomeLoja);
	}
}
