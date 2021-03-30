package com.codestationdev.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codestationdev.cursomc.domain.Categoria;
import com.codestationdev.cursomc.repositories.CategoriaRepository;
import com.codestationdev.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 

	}

}
