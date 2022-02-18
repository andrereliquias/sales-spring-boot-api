package br.com.andrereliquias;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development // Essa anotation herdou as anotations da interface Development.java
public class Config {

    // Aqui eu digo para o spring criar esse bin no contexto da aplicação
    // Para eu utilizar em  qualquer lugar
    // A anotacao bean eu digo para o spring que esse metodo produz um bean para ser gerenciado pelo container do spring
    // @Bean(name = "applicationName")
    // public String applicationName() {
    //     return "Sistema de Vendas";
    // }

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("Rodando a configuração de desenvolvimento");
        };
    }

}
