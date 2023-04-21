package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.model.Fornecedor;
import com.FranquiaSorvetes.franquiaSorvetes.repositories.FornecedorRepository;
@Service
public class FornecedorService {
	@Autowired //Injeção de dependências.
	FornecedorRepository fornecedorRepository;
	

	public FornecedorService() {
		// TODO Auto-generated constructor stub
	}
	
	//Query 5
	public List<HashMap<String,String>> query5(String nomeLoja){
		return fornecedorRepository.query5(nomeLoja);
	}
	//Query 9
	public List<Fornecedor> query9(){
		return fornecedorRepository.query9();
	}
}
