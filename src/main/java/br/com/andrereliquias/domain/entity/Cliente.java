package br.com.andrereliquias.domain.entity;

public class Cliente {

    private Integer id;
    private String nome;

    public Cliente() {
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " - Cliente: "+ nome;
    }
}
