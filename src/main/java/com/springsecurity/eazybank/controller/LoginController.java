package com.springsecurity.eazybank.controller;

import com.springsecurity.eazybank.model.Customer;
import com.springsecurity.eazybank.service.LoginService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@NonNull @RequestBody Customer customer){
        if(loginService.checkIfUserExist(customer.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist with email: "+customer.getEmail());
        }
        loginService.registerUser(customer);
        return new ResponseEntity<>("User registered with email "+customer.getEmail(),HttpStatus.CREATED);
    }
}
