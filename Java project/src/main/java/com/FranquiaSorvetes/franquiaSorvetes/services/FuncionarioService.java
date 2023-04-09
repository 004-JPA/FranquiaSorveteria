package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.repositories.FuncionarioRepository;
@Service
public class FuncionarioService {
	@Autowired //Injeção de dependências.
	FuncionarioRepository funcionarioRepository;
	public FuncionarioService() {
		
	}

	//Query 4
	public HashMap<String,Integer> query4(String nomeLoja) {
		return funcionarioRepository.query4(nomeLoja);
	}
}
