package com.example.apipokemonsecure;

import com.example.apipokemonsecure.Model.AuthRole;
import com.example.apipokemonsecure.Webservices.Services.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiPokemonSecureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPokemonSecureApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
