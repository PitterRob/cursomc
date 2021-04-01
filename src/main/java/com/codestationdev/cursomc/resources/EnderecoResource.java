package com.codestationdev.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codestationdev.cursomc.domain.Endereco;
import com.codestationdev.cursomc.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")

public class EnderecoResource {

	@Autowired
	private EnderecoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findId(@PathVariable Integer id) {

		Endereco obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);
	};
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<?> findAll(){
	   return service.findAll();
	}
	
}
