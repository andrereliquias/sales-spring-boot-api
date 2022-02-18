package br.com.andrereliquias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.andrereliquias.domain.entity.Cliente;
import br.com.andrereliquias.domain.repositorio.Clientes;

@SpringBootApplication
public class VendasApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(VendasApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return (args) -> {

            clientes.salvar(new Cliente(null, "Andre"));
            clientes.salvar(new Cliente(null, "Outro"));
            
            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado");
                clientes.atualizar(c);
            });

            System.out.println("Atualizando os clientes");
            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clientes.buscarPorNome("And").forEach(System.out::println);

            System.out.println("Deletando clientes");
            clientes.obterTodos().forEach(c -> {
                clientes.deletar(c);
            });

            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()) { 
                System.out.println("Nenhum cliente encontrado");
            } else { 
                todosClientes.forEach(System.out::println);
            }
        };
    }
}
