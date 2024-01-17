package com.springsecurity.eazybank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_Id")
    private Long cardId;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "provider")
    private String provider;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "card_limit")
    private Double cardLimit;

    @Column(name = "available_balance")
    private Double availableBalance;

    @Column(name = "amount_used")
    private Double amountUsed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;
}
