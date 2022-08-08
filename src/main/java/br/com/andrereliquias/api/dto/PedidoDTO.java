package br.com.andrereliquias.api.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.andrereliquias.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Pacote lombok
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

  @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
  private Integer cliente;

  @NotNull(message = "{campo.total-pedido.obrigatorio}")
  private BigDecimal total;

  @NotEmptyList(message = "{campo.itens-pedido.obrigatorio}")
  private List<ItemPedidoDTO> itens;

}
