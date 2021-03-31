package com.codestationdev.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codestationdev.cursomc.domain.Estado;
import com.codestationdev.cursomc.repositories.EstadoRepository;
import com.codestationdev.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	public Estado buscar(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));

	}

	public List<Estado> findAll() {
	    List<Estado> estados = new ArrayList<>();
	    repo.findAll().forEach(estados::add);
	    return estados;
	}
}
