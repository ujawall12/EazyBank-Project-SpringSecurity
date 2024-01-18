package com.springsecurity.eazybank.controller;

import com.springsecurity.eazybank.model.AccountTransactions;
import com.springsecurity.eazybank.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping("/myBalance")
    public ResponseEntity<List<AccountTransactions>> getBalanceDetails(@RequestParam Long customerId) {
        List<AccountTransactions> accountTransactions = balanceService.getBalance(customerId);
        if (Objects.isNull(accountTransactions)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountTransactions);
    }
}
