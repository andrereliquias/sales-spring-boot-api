package br.com.andrereliquias.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private Integer id;
    private Cliente cliente;
    private LocalDate dataPedido;
    private BigDecimal total;
    
    public Integer getId() {
        return id;
    }
    
    public BigDecimal getTotal() {
        return total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    public LocalDate getDataPedido() {
        return dataPedido;
    }
    
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

}
