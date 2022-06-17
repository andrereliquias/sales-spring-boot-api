package br.com.andrereliquias.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andrereliquias.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer> {
  
}
