package com.FranquiaSorvetes.franquiaSorvetes.services;

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
	public int query4(String nomeLoja) {
		return funcionarioRepository.query4(nomeLoja);
	}
}
