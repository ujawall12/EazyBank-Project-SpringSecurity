package com.springsecurity.eazybank.repository;
import com.springsecurity.eazybank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    Boolean existsByEmail(String email);
}
