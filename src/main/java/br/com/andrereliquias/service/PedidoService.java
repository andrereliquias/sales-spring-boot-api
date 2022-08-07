package br.com.andrereliquias.service;

import br.com.andrereliquias.api.dto.PedidoDTO;
import br.com.andrereliquias.domain.entity.Pedido;

public interface PedidoService {
  Pedido salvar( PedidoDTO dto );
}
