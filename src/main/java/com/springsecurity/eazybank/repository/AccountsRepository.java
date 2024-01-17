package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends MongoRepository<Accounts, Long> {

    Accounts findByCustomerId(Long id);
}
