package br.com.andrereliquias.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// define o carregamento de usuarios atraves de uma base de dados
@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        if (!username.equals("ciclano")) {
            throw new UsernameNotFoundException("Usuario nao encontrado na base");
        }
        
        return User
                .builder()
                .username("ciclano")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("USER", "ADMIN")
                .build();
    }
    
}
