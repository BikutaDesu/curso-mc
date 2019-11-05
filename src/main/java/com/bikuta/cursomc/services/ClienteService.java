package com.bikuta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikuta.cursomc.domain.Cliente;
import com.bikuta.cursomc.repositories.ClienteRepository;
import com.bikuta.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	//Autowired - indica que essa dependência vai ser instanciada automaticamente pelo Spring
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}	
