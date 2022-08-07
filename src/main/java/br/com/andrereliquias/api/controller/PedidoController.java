package br.com.andrereliquias.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrereliquias.api.dto.PedidoDTO;
import br.com.andrereliquias.domain.entity.Pedido;
import br.com.andrereliquias.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
  
  private PedidoService service;

  public PedidoController(PedidoService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Integer save( @RequestBody PedidoDTO dto ) {
    Pedido pedido = service.salvar(dto);

    return pedido.getId();
  }
  
}
