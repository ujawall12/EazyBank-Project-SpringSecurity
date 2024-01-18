package com.springsecurity.eazybank.service;

import com.springsecurity.eazybank.model.Loans;
import com.springsecurity.eazybank.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoansRepository loanRepository;

    public Loans getLoansDetails(Long loanNumber) {
        return loanRepository.findById(loanNumber).orElse(null);
    }
}
