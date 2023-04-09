package Services;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Repositories.ClienteRepository;

public class ClienteService {
	@Autowired //Injeção de dependências.
	ClienteRepository clienteRepository;
			
	public ClienteService() {

	}
	//Service query 8
	public List<String> query8(double valor){
		return clienteRepository.query8(valor);
	}
	//Service query 7
	public HashMap<String, Date> query7(Date dataLimite){
		return clienteRepository.query7(dataLimite);
	}
}
