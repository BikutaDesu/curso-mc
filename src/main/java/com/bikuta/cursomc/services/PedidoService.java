package com.bikuta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikuta.cursomc.domain.Pedido;
import com.bikuta.cursomc.repositories.PedidoRepository;
import com.bikuta.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {
	
	//Autowired - indica que essa dependência vai ser instanciada automaticamente pelo Spring
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
}	
