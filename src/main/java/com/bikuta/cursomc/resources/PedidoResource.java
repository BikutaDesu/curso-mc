package com.bikuta.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bikuta.cursomc.domain.Pedido;
import com.bikuta.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;

	// ResponseEntity - Encapsula varios dados de uma informação http
	// PathVariable - Indica que a variável do método vai receber o value informado
	// no RequestMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido pedido = service.find(id);
		return ResponseEntity.ok(pedido);
	}

}
