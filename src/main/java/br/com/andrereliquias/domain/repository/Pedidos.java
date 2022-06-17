package br.com.andrereliquias.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andrereliquias.domain.entity.Cliente;
import br.com.andrereliquias.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    
    List<Pedido> findByCliente(Cliente  cliente);
}
