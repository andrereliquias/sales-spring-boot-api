package br.com.andrereliquias.api.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Pacote lombok
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
  
  private Integer cliente;
  private BigDecimal total;
  private List<ItemPedidoDTO> items;

}
