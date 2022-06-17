package br.com.andrereliquias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.andrereliquias.domain.entity.Cliente;
import br.com.andrereliquias.domain.entity.Pedido;
import br.com.andrereliquias.domain.repository.Clientes;
import br.com.andrereliquias.domain.repository.Pedidos;

@SpringBootApplication
public class VendasApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(VendasApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos

        ) {
        return (args) -> {
            System.out.print("Salvando clientes");
            Cliente fulano = new Cliente(null, "Fulano");
            clientes.save(fulano);

            clientes.save(new Cliente(null, "Outro"));
            
            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

            // Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
            // System.out.println(cliente);

            // System.out.println(cliente.getPedidos());

            pedidos.findByCliente(fulano).forEach(
                System.out::println
            );
        };
    }
}
