package com.FranquiaSorvetes.franquiaSorvetes.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FranquiaSorvetes.franquiaSorvetes.repositories.FornecedorRepository;
import com.FranquiaSorvetes.model.Fornecedor;
@Service
public class FornecedorService {
	@Autowired //Injeção de dependências.
	FornecedorRepository fornecedorRepository;
	

	public FornecedorService() {
		// TODO Auto-generated constructor stub
	}
	
	//Query 5
	public List<HashMap<String,String>> query5(int idLoja){
		return fornecedorRepository.query5(idLoja);
	}
	//Query 9
	public List<Fornecedor> query9(){
		return fornecedorRepository.query9();
	}
}
