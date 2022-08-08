package br.com.andrereliquias.api.controller;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.andrereliquias.api.dto.AtualizacaoStatusPedidoDTO;
import br.com.andrereliquias.api.dto.InformacaoItemPedidoDTO;
import br.com.andrereliquias.api.dto.InformacoesPedidoDTO;
import br.com.andrereliquias.api.dto.PedidoDTO;
import br.com.andrereliquias.domain.entity.ItemPedido;
import br.com.andrereliquias.domain.entity.Pedido;
import br.com.andrereliquias.domain.enums.StatusPedido;
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
  public Integer save( @RequestBody @Valid PedidoDTO dto ) {
    Pedido pedido = service.salvar(dto);

    return pedido.getId();
  }
  
  @GetMapping("/{id}")
  public InformacoesPedidoDTO getById(@PathVariable Integer id) {
    return service
                  .obterPedidoCompleto(id)
                  .map(p -> converter(p))
                  .orElseThrow(() -> 
                          new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido nao encontrado"));
  }

  @PatchMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateStatus(@PathVariable Integer id, @RequestBody AtualizacaoStatusPedidoDTO dto) {
    
    String novoStatus = dto.getNovoStatus();
    service.atutalizaStatus(id, StatusPedido.valueOf(novoStatus));
  }

  private InformacoesPedidoDTO converter(Pedido pedido) {
    return InformacoesPedidoDTO
              .builder().codigo(pedido.getId())
              .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
              .cpf(pedido.getCliente().getCpf())
              .nomeCliente(pedido.getCliente().getNome())
              .total(pedido.getTotal())
              .status(pedido.getStatus().name())
              .Itens(converter(pedido.getItens()))
              .build();
  }

  private List<InformacaoItemPedidoDTO> converter(List<ItemPedido> itens) {
    // se os itens do pedido estiver vazio
    if(CollectionUtils.isEmpty(itens)) {
      return Collections.emptyList(); //retorna um array nulo
    }

    return itens.stream().map(item -> InformacaoItemPedidoDTO
                                        .builder()
                                        .descricaoProduto(item.getProduto().getDescricao())
                                        .precoUnitario(item.getProduto().getPreco())
                                        .quantidade(item.getQuantidade())
                                        .build()
    ).collect(Collectors.toList());
  }
}
