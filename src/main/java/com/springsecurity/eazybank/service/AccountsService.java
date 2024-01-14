package com.springsecurity.eazybank.service;

import com.springsecurity.eazybank.model.Accounts;
import com.springsecurity.eazybank.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountsService {
    private final AccountsRepository accountsRepository;

    public Accounts getAccountDetails(Long id) {
        return accountsRepository.findByCustomerId(id);
    }
}
