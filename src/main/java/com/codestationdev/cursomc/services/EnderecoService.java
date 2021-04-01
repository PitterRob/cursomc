package com.codestationdev.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codestationdev.cursomc.domain.Endereco;
import com.codestationdev.cursomc.repositories.EnderecoRepository;
import com.codestationdev.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	public Endereco buscar(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));

	}

	public List<Endereco> findAll() {
		List<Endereco> enderecos = new ArrayList<>();
		repo.findAll().forEach(enderecos::add);
		return enderecos;
	}
}
