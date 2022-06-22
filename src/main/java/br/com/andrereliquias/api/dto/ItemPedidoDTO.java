package br.com.andrereliquias.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Pacote lombok
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
  
  private Integer produto;
  private Integer quantidade;

}
