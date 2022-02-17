package br.com.andrereliquias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrereliquias.model.Cliente;
import br.com.andrereliquias.repository.ClientesRepository;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);
        repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente) {
        // aplica validacoes
    }

}
