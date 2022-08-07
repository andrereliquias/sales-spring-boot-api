package br.com.andrereliquias.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AtualizacaoStatusPedidoDTO {
  private String novoStatus;
}
