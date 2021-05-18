package com.example.teste_h2.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste_h2.entitites.Pessoa;
import com.example.teste_h2.services.PessoaServices;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaServices service;
		
	@RequestMapping(value = "/cadastrar", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa cadastroPessoa(@RequestBody Pessoa obj) {
		return service.cadastrarPessoa(obj);
	}
	
	@RequestMapping(value = "/buscar/id/{id}", method = GET, produces = APPLICATION_JSON_VALUE )
	@ResponseStatus(HttpStatus.OK)
	public Pessoa buscaPessoaId(@PathVariable Integer id) {
		return service.buscarPessoaPeloId(id);
	}
	
	@RequestMapping(value = "/buscar/nome/{nome}", method = GET, produces = APPLICATION_JSON_VALUE )
	@ResponseStatus(HttpStatus.OK)
	public List<Pessoa> buscaPessoaNome(@PathVariable String nome) {
		return service.buscarPessoaPeloNome(nome);
	}
	
	@RequestMapping(value = "/remover/id/{id}", method = DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletarPessoa(@PathVariable Integer id) {
		service.removerPessoa(id);
	}

}
