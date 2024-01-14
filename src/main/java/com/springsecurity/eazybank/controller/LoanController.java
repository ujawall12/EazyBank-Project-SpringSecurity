package com.springsecurity.eazybank.controller;

import com.springsecurity.eazybank.model.Loans;
import com.springsecurity.eazybank.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/myLoan")
    public ResponseEntity<Loans> getLoanDetails(@RequestParam Long loanNumber) {
        if (Objects.isNull(loanService.getLoansDetails(loanNumber))) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loanService.getLoansDetails(loanNumber));
    }
}
