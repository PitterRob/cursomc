package com.codestationdev.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codestationdev.cursomc.domain.Pedido;
import com.codestationdev.cursomc.repositories.PedidoRepository;
import com.codestationdev.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

	}

	public List<Pedido> findAll() {
	    List<Pedido> estados = new ArrayList<>();
	    repo.findAll().forEach(estados::add);
	    return estados;
	}
}
