package br.com.andrereliquias.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Pacote lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @Column(name = "preco_unitario", precision = 20, scale = 2)
    @NotNull(message = "{campo.preco.obrigatorio}")
    private BigDecimal preco;

    // public Integer getId() {
    //     return id;
    // }
    
    // public BigDecimal getPreco() {
    //     return preco;
    // }
    
    // public void setPreco(BigDecimal preco) {
    //     this.preco = preco;
    // }
    
    // public String getDescricao() {
    //     return descricao;
    // }
    
    // public void setDescricao(String descricao) {
    //     this.descricao = descricao;
    // }
    
    // public void setId(Integer id) {
    //     this.id = id;
    // }

}
