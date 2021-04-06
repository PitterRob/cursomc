package com.codestationdev.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.codestationdev.cursomc.domain.Categoria;
import com.codestationdev.cursomc.domain.Produto;
import com.codestationdev.cursomc.repositories.CategoriaRepository;
import com.codestationdev.cursomc.repositories.ProdutoRepository;
import com.codestationdev.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));

	}

	public List<Produto> findAll() {
		List<Produto> produtos = new ArrayList<>();
		repo.findAll().forEach(produtos::add);
		return produtos;
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
	return repo.search(nome, categorias, pageRequest);
	}

}
