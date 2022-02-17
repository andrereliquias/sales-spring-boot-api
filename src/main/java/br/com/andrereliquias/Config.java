package br.com.andrereliquias;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    // Aqui eu digo para o spring criar esse bin no contexto da aplicação
    // Para eu utilizar em  qualquer lugar
    // A anotacao bean eu digo para o spring que esse metodo produz um bean para ser gerenciado pelo container do spring
    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema de Vendas";
    }

}
