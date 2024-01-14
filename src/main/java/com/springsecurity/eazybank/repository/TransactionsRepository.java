package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.AccountTransactions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionsRepository extends MongoRepository<AccountTransactions, String> {

    List<AccountTransactions> findByCustomerIdOrOrderByTransactionDtDesc(Long customerId);
}
