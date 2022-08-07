package br.com.andrereliquias.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.andrereliquias.api.dto.ItemPedidoDTO;
import br.com.andrereliquias.api.dto.PedidoDTO;
import br.com.andrereliquias.domain.entity.Cliente;
import br.com.andrereliquias.domain.entity.ItemPedido;
import br.com.andrereliquias.domain.entity.Pedido;
import br.com.andrereliquias.domain.entity.Produto;
import br.com.andrereliquias.domain.enums.StatusPedido;
import br.com.andrereliquias.domain.repository.Clientes;
import br.com.andrereliquias.domain.repository.ItensPedido;
import br.com.andrereliquias.domain.repository.Pedidos;
import br.com.andrereliquias.domain.repository.Produtos;
import br.com.andrereliquias.exception.PedidoNaoEncontradoException;
import br.com.andrereliquias.exception.RegraNegocioException;
import br.com.andrereliquias.service.PedidoService;
import lombok.RequiredArgsConstructor;

// Eu coloco aqui as regras de negocio
@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
  
  // estou usando o lombok para gerar o construtor sendo obrigatorio os itens que contem final
  private final Pedidos repository;
  private final Clientes clientesRepository;
  private final Produtos produtosRepository;
  private final ItensPedido itensPedidoRepository;

  @Override
  @Transactional // garante que ou ele salva tudo ou não salva nada
  public Pedido salvar(PedidoDTO dto) {
    Integer idCliente = dto.getCliente();
    Pedido pedido = new Pedido();
    Cliente cliente = clientesRepository.findById(idCliente)
      .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido"));


    pedido.setTotal(dto.getTotal());
    pedido.setDataPedido(LocalDate.now());
    pedido.setCliente(cliente);
    pedido.setStatus(StatusPedido.REALIZADO);

    List<ItemPedido> itensPedido = converterItens(pedido, dto.getItens());
    repository.save(pedido);

    itensPedidoRepository.saveAll(itensPedido);

    // TODO Auto-generated method stub
    // return null;
    
    pedido.setItens(itensPedido);

    return pedido;
  }

  @Override
  public Optional<Pedido> obterPedidoCompleto(Integer id) {
    return repository.findByIdFetchItens(id);
  }

  @Override
  @Transactional
  public void atutalizaStatus(Integer id, StatusPedido statusPedido) {
    // NAO E BOA PRATICA USAR A CAMADA DE SERVICO PARA LANCAR EXCESSOES DE API REST
      repository
              .findById(id)
              .map( pedido -> {
                pedido.setStatus(statusPedido);
                return repository.save(pedido);
              }).orElseThrow(() -> new PedidoNaoEncontradoException());
  }

  private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens) {
    if (itens == null ||  itens.isEmpty()) {
      throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
    }

    return itens
      .stream()
      .map(dto -> {
        Integer idProduto = dto.getProduto();
        Produto produto = produtosRepository.findById(idProduto)
        .orElseThrow(() -> new RegraNegocioException("Código de produto inválido: " + idProduto));

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(dto.getQuantidade());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        return itemPedido;

      }).collect(Collectors.toList());
  }

}
