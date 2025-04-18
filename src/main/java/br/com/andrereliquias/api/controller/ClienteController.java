package br.com.andrereliquias.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.andrereliquias.domain.entity.Cliente;
import br.com.andrereliquias.domain.repository.Clientes;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

  // Aqui eu estou injetando o cliente
  private Clientes clientes;

  // Aqui o construtor que recebe a injeção dos clientes
  public ClienteController(Clientes clientes) {
    this.clientes = clientes;
  }

  @GetMapping("/{id}")
  public Cliente getClienteById(@PathVariable Integer id) {

    // Instancia de option quer dizer que pode existir ou não um cliente, eh
    // retornado pelo findById
    // Optional<Cliente> cliente = clientes.findById(id);

    return clientes
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente save(@RequestBody @Valid Cliente cliente) {

    return clientes.save(cliente);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {

    clientes
        .findById(id)
        .map(cliente -> {
          clientes.delete(cliente);

          return cliente;
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable Integer id, @RequestBody @Valid Cliente cliente) {

    clientes
        .findById(id)
        .map(clienteExistente -> {
          cliente.setId(clienteExistente.getId());
          clientes.save(cliente);

          return clienteExistente;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

  }

  @GetMapping
  public List<Cliente> find(Cliente filtro) {

    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

    Example example = Example.of(filtro, matcher);

    return clientes.findAll(example);
  }

}
