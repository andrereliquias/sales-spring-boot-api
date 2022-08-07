package br.com.andrereliquias.service;

import java.util.Optional;

import br.com.andrereliquias.api.dto.PedidoDTO;
import br.com.andrereliquias.domain.entity.Pedido;

public interface PedidoService {
  Pedido salvar( PedidoDTO dto );

  Optional<Pedido> obterPedidoCompleto(Integer id);
}
