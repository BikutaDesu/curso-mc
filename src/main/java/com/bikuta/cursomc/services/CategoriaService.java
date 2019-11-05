package com.bikuta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikuta.cursomc.domain.Categoria;
import com.bikuta.cursomc.repositories.CategoriaRepository;
import com.bikuta.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	//Autowired - indica que essa dependência vai ser instanciada automaticamente pelo Spring
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
