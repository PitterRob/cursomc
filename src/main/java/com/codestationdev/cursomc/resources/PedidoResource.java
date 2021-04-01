package com.codestationdev.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codestationdev.cursomc.domain.Pedido;
import com.codestationdev.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")

public class PedidoResource {

	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> findId(@PathVariable Integer id) {

		Pedido obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);
	};
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<?> findAll(){
	   return service.findAll();
	}
	
}
