package br.com.andrereliquias.domain.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.andrereliquias.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String string);

    boolean existsByNome(String nome);
}
