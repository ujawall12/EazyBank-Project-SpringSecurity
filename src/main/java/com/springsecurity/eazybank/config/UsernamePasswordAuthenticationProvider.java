package com.springsecurity.eazybank.config;

import com.springsecurity.eazybank.model.Authorities;
import com.springsecurity.eazybank.model.Customer;
import com.springsecurity.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        Customer customer = customerRepository.findByEmail(userName);
        if (customer != null) {
            if (passwordEncoder.matches(password, customer.getPassword())) {
                return new UsernamePasswordAuthenticationToken(userName, password, getGrantedAuthorities(customer.getAuthorities()));
            } else {
                throw new BadCredentialsException("Incorrect Password");
            }
        } else {
            throw new BadCredentialsException("No user found with username: " + userName);
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<Authorities> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return authorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
