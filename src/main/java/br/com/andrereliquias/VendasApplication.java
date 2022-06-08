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

            clientes.save(new Cliente(null, "Andre"));
            clientes.save(new Cliente(null, "Outro"));
            
            boolean exists = clientes.existsByNome("Andre");
            System.out.println("Existe um cliente com o nome Andre? " + exists);
        };
    }
}
