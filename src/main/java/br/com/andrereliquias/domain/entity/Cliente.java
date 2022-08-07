package br.com.andrereliquias.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Pacote lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity // Não é necessario utilizar a anaotation @table pois o nome da Entidade é o mesmo nome da tabela
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "Campo nome e obrigatorio")
    private String nome;

    @Column(length = 11)
    private String cpf;

    @JsonIgnore // diz para o parser ignorar essa propiedade no meu json quando eu fazer um get
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    // public Cliente() {
    // }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // public String getCpf() {
    //     return cpf;
    // }

    // public void setCpf(String cpf) {
    //     this.cpf = cpf;
    // }

    // public Set<Pedido> getPedidos() {
    //     return pedidos;
    // }

    // public void setPedidos(Set<Pedido> pedidos) {
    //     this.pedidos = pedidos;
    // }

    // public Integer getId() {
    //     return id;
    // }

    // public String getNome() {
    //     return nome;
    // }

    // public void setNome(String nome) {
    //     this.nome = nome;
    // }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

    // @Override
    // public String toString() {
    //     return id + " - Cliente: "+ nome;
    // }
}
