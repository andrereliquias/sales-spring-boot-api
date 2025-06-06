package br.com.andrereliquias.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Pacote lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_pedido")
public class ItemPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column
    private Integer quantidade;
    
    // public Integer getId() {
    //     return id;
    // }
    
    // public Integer getQuantidade() {
    //     return quantidade;
    // }
    
    // public void setQuantidade(Integer quantidade) {
    //     this.quantidade = quantidade;
    // }
    
    // public Produto getProduto() {
    //     return produto;
    // }
    
    // public void setProduto(Produto produto) {
    //     this.produto = produto;
    // }
    
    // public Pedido getPedido() {
    //     return pedido;
    // }
    
    // public void setPedido(Pedido pedido) {
    //     this.pedido = pedido;
    // }
    
    // public void setId(Integer id) {
    //     this.id = id;
    // }

}
