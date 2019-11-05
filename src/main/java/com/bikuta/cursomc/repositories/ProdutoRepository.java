package com.bikuta.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikuta.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
