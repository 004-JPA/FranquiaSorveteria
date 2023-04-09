package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.repositories.ClienteRepository;
import com.FranquiaSorvetes.model.InfoQueries7e8;
@Service
public class ClienteService {
	@Autowired //Injeção de dependências.
	ClienteRepository clienteRepository;
			
	public ClienteService() {

	}
	//Service query 8
	public InfoQueries7e8 query8(double valor){
		return clienteRepository.query8(valor);
	}
	//Service query 7
	public InfoQueries7e8 query7(Date dataLimite){
		return clienteRepository.query7(dataLimite);
	}
}
