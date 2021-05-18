package com.example.teste_h2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste_h2.entitites.Pessoa;
import com.example.teste_h2.repositories.PessoaRepository;

@Service
public class PessoaServices {

	@Autowired
	private PessoaRepository repositorio;
	
	// cadastrar pessoa
	public Pessoa cadastrarPessoa(Pessoa obj) {
		return repositorio.save(obj);
	}
	
	public Pessoa buscarPessoaPeloId(Integer id) {
		Pessoa encontrada = repositorio.findById(id).get();
		
		return encontrada;
	}
	
	// buscar pessoa -> nome
	public List<Pessoa> buscarPessoaPeloNome(String nome) {
		List<Pessoa> encontrada = repositorio.findByNome(nome);
		
		return encontrada;
	}
		
	// remover pessoa -> id
	public void removerPessoa(Integer id) {
		Pessoa encontrada = repositorio.findById(id).get();		
		repositorio.delete(encontrada);
	}

}
