package br.com.andrereliquias.domain.entity;

public class ItemPedido {
    
    private Integer id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;
    
    public Integer getId() {
        return id;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public Pedido getPedido() {
        return pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

}
