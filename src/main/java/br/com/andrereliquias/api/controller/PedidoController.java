package br.com.andrereliquias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrereliquias.service.PedidoService;

@RestController
@RequestMapping("/api/clientes")
public class PedidoController {
  
  private PedidoService service;

  public PedidoController(PedidoService service) {
    this.service = service;
  }

  

}
