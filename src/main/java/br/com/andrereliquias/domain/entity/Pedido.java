package br.com.andrereliquias.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.andrereliquias.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Pacote lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens; 

    public List<ItemPedido> getItens() {
        if (this.itens == null) {
            this.itens = new ArrayList<>();
        }
        return itens;
    }

    // public List<ItemPedido> getItens() {
    //     return itens;
    // }

    // public void setItens(List<ItemPedido> itens) {
    //     this.itens = itens;
    // }

    // public Integer getId() {
    //     return id;
    // }
    
    // public BigDecimal getTotal() {
    //     return total;
    // }
    
    // public void setTotal(BigDecimal total) {
    //     this.total = total;
    // }
    
    // public LocalDate getDataPedido() {
    //     return dataPedido;
    // }
    
    // public void setDataPedido(LocalDate dataPedido) {
    //     this.dataPedido = dataPedido;
    // }
    
    // public Cliente getCliente() {
    //     return cliente;
    // }
    
    // public void setCliente(Cliente cliente) {
    //     this.cliente = cliente;
    // }
    
    // public void setId(Integer id) {
    //     this.id = id;
    // }

    // @Override
    // public String toString() {
    //     return "Pedido(" +
    //             "id=" + id + 
    //             ", dataPedido=" + dataPedido +
    //             ", total=" + total +
    //             ")";
    // }

}
