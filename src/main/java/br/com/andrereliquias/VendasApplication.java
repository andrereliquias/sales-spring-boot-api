package br.com.andrereliquias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
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
        return "Hello  World!";
    }
}
