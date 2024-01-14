package com.springsecurity.eazybank.service;

import com.springsecurity.eazybank.model.Cards;
import com.springsecurity.eazybank.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsService {

    private final CardRepository cardRepository;

    public List<Cards> getCardsDetails(Long customerId){
        return cardRepository.findAllByCustomerId(customerId);
    }

}
