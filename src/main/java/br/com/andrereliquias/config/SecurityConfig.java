package br.com.andrereliquias.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.andrereliquias.service.impl.UsuarioServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private UsuarioServiceImpl usuarioService;

  @Bean // criptografa e descriptografa a senha de usuário
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override // traz obg que vai fazer a autenticacao dos usuarios
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // auth.inMemoryAuthentication()
    //     .passwordEncoder(passwordEncoder())
    //     .withUser("user")
    //     .password(passwordEncoder().encode("user"))
    //     .roles("USER");

    auth.
        userDetailsService(usuarioService)
        .passwordEncoder(passwordEncoder());
  }

  @Override //parte de autorizacao
  protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable()
        .authorizeRequests()
          .antMatchers("/api/clientes/**") // pra acessar isso
            // .hasAuthority("MANTER USUARIO") // tem q ter a authorit manter usuario
            // .authenticated()
            .hasAnyRole("USER", "ADMIN")
          .antMatchers("/api/pedidos/**")
            .hasAnyRole("USER", "ADMIN")
          .antMatchers("/api/produtos/**")
            .hasRole("ADMIN")
          .and()
          .httpBasic();

    // super.configure(http);
  }

}
