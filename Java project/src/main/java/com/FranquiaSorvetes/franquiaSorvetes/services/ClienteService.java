package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.model.dtos.InfoQuery7;
import com.FranquiaSorvetes.franquiaSorvetes.model.dtos.InfoQuery8;
import com.FranquiaSorvetes.franquiaSorvetes.repositories.ClienteRepository;
@Service
public class ClienteService {
	@Autowired //Injeção de dependências.
	ClienteRepository clienteRepository;
			
	public ClienteService() {

	}
	//Service query 8
	public List<InfoQuery8> query8(double valor){
		return clienteRepository.query8(valor);
	}
	//Service query 7
	public List<InfoQuery7> query7(Date dataLimite){
		return clienteRepository.query7(dataLimite);
	}
}
