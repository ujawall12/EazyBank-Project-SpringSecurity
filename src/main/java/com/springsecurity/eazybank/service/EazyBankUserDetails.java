package com.springsecurity.eazybank.service;


import com.springsecurity.eazybank.model.Customer;
import com.springsecurity.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EazyBankUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        String userName;
        String password = null;
        List<GrantedAuthority> authorities = null;
        Customer customer = customerRepository.findByEmail(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User details not found for the user " + username);
        } else {
            userName = customer.getEmail();
            password = customer.getPassword();
            authorities = List.of();
            authorities.add(new SimpleGrantedAuthority(customer.getRole()));
            return new User(userName, password, authorities);
        }
    }
}
