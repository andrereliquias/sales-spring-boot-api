package br.com.andrereliquias.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.andrereliquias.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String string);

    boolean existsByNome(String nome);

    @Query(value = " select c from Cliente c where c.nome like :nome")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(" select c  from Cliente c left join fetch c.pedidos p  where c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

    
}
