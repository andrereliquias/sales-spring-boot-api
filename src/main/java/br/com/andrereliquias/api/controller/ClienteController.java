package br.com.andrereliquias.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.andrereliquias.domain.entity.Cliente;
import br.com.andrereliquias.domain.repository.Clientes;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

  // Aqui eu estou injetando o cliente
  private Clientes clientes;

  // Aqui o construtor que recebe a injeção dos clientes
  public ClienteController(Clientes clientes) {
    this.clientes = clientes;
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity getClienteById( @PathVariable Integer id ) {
    
    // Instancia de option quer dizer que pode existir ou não um cliente,  eh retornado pelo findById
    Optional<Cliente> cliente = clientes.findById(id);

    if(cliente.isPresent()) {
      return ResponseEntity.ok( cliente.get() );
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity save( @RequestBody Cliente cliente ) {
    
    Cliente clienteSalvo = clientes.save(cliente);  
    
    return ResponseEntity.ok(clienteSalvo);
  
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity delete( @PathVariable Integer id ) {
    
    // Instancia de option quer dizer que pode existir ou não um cliente,  eh retornado pelo findById
    Optional<Cliente> cliente = clientes.findById(id);

    if(cliente.isPresent()) {
      clientes.delete(cliente.get());

      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  @ResponseBody
  public ResponseEntity update( @PathVariable Integer id, @RequestBody Cliente cliente ) {
    
    return clientes
            .findById(id)
            .map(clienteExistente -> {
              cliente.setId(clienteExistente.getId());
              clientes.save(cliente);

              return ResponseEntity.noContent().build();
            }).orElseGet(() -> ResponseEntity.notFound().build());

  }

  @GetMapping
  @ResponseBody
  public ResponseEntity find( Cliente filtro ) {

    ExampleMatcher matcher = ExampleMatcher
                              .matching()
                              .withIgnoreCase()
                              .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

    Example example = Example.of(filtro, matcher);

    List<Cliente> lista = clientes.findAll(example);

    return ResponseEntity.ok(lista);
  }

}
