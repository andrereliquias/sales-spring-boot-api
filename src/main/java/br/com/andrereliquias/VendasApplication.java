package br.com.andrereliquias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Container IOC - Inversão de controle
 * Conseguimos delegar para o spring algumas tarefas que ele deve executar
 * Component anotation  -> É uma classe que contem metodos e operacoes que sao uteis para operacoes
 * Components se dividem em: Controller, Repository e Service
 */

 /**
  * Injeção de dependencias
  * É um padrao de projeto onde eu delego outras classes que instancie minhas depedencias
  * e injete nas classes onde eu preciso
  */

@SpringBootApplication
@RestController // Essa anotation diz que essa classe vai ser um controlador Rest
public class VendasApplication 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(VendasApplication.class, args);
    }

    @GetMapping("/hello")
    public String helloWorld()  {
        return applicationName;
    }

    @Autowired // Aqui eu estou fazendo uma injeção de dependência, no caso vou injetar uma bean de configuração
    @Qualifier("applicationName") // Essa anotation eu evito ambiguidade quando o spring encontrar multiplos beans com o mesmo tipo
    private String applicationName;
}
