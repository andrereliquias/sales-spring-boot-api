package br.com.andrereliquias.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andrereliquias.domain.entity.ItemPedido;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
  
}
