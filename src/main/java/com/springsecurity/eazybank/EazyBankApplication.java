package com.springsecurity.eazybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class EazyBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazyBankApplication.class, args);
    }

}
