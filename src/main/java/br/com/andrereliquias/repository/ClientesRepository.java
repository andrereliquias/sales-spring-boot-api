package br.com.andrereliquias.repository;

import org.springframework.stereotype.Repository;

import br.com.andrereliquias.model.Cliente;

@Repository
public class ClientesRepository {
    
    public void persistir(Cliente cliente) {
        // acessa a base e salva o cliente
    }
}
