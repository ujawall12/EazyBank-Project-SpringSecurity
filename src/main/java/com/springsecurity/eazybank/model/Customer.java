package com.springsecurity.eazybank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_Id")
    private Long customerId;

    private String email;

    private String password;

    private String role;

    @Column(name = "mobile_no")
    private Long mobileNo;

    @Column(name = "created_on")
    private Date createdOn;

    @OneToMany(mappedBy = "customer")
    private List<Cards> cards;

    @OneToMany(mappedBy = "customer")
    private List<Loans> loans;

}
