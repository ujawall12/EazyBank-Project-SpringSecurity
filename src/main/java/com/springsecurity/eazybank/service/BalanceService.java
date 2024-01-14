package com.springsecurity.eazybank.service;

import com.springsecurity.eazybank.model.AccountTransactions;
import com.springsecurity.eazybank.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final TransactionsRepository transactionsRepository;

    public List<AccountTransactions> getBalance(Long customerId) {
        return transactionsRepository.findByCustomerIdOrOrderByTransactionDtDesc(customerId);
    }
}
