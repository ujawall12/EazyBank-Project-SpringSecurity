package com.springsecurity.eazybank.controller;

import com.springsecurity.eazybank.model.Cards;
import com.springsecurity.eazybank.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsService cardsService;

    @GetMapping("/myCards")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Cards>> getCardsDetails(@RequestParam Long customerId) {
        List<Cards> cards = cardsService.getCardsDetails(customerId);
        if (Objects.isNull(cards)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cards);
    }
}
