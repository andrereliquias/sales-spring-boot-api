package br.com.andrereliquias.service.impl;

import org.springframework.stereotype.Service;

import br.com.andrereliquias.domain.repository.Pedidos;
import br.com.andrereliquias.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
  
  private Pedidos repository;

  public PedidoServiceImpl(Pedidos repository) {
    this.repository = repository;
  }


}
