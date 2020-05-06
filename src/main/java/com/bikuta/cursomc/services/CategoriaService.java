package com.bikuta.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bikuta.cursomc.domain.Categoria;
import com.bikuta.cursomc.repositories.CategoriaRepository;
import com.bikuta.cursomc.services.exceptions.DataIntegrityException;
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
	
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return repo.save(categoria);
	}
	
	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return (Categoria) repo.save(categoria);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria com produtos!");
		}	
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
}
