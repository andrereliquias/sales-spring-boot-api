package br.com.andrereliquias.domain.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.andrereliquias.domain.entity.Cliente;

@Repository
public class Clientes {
  
    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String SELECT_ALL = "select * from cliente";
    private static String UPDATE = "update cliente set nome = ? where id = ?";
    private static String DELETE = "delete from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
   
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) {
        
        jdbcTemplate.update(UPDATE, new Object[]{
            cliente.getNome(),
            cliente.getId()
        });

        return cliente;
    }

    public void deletar(Cliente cliente) {
        
        deletar(cliente.getId());
       
    }

    public void deletar(Integer id) {
        
        jdbcTemplate.update(DELETE, new Object[]{id});

    }

    public List<Cliente> buscarPorNome(String nome) {

        return jdbcTemplate.query(
                SELECT_ALL.concat(" where nome like ? "),
                obterClienteMapper(),
                new Object[]{"%" + nome + "%"}
        );
    
    }

    public List<Cliente> obterTodos() {

        /**
         * RowMapper -> Mapeia o resultado do banco de dados para uma classe
         * ResultSet -> Todo resultado que veio do banco de dados
         * mapRow -> Mapeio cada item para uma classe Cliente e retorno uma lista de clientes
         */

        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Cliente(resultSet.getInt("id"), resultSet.getString("nome")); // getString -> Pega o valor em string de uma coluna que veio do resultado do  select
            }
        };
    }
}
