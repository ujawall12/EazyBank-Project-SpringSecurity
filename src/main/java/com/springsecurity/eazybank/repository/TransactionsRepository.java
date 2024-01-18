package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.AccountTransactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends MongoRepository<AccountTransactions, String> {

    @Query("Select t from AccountTransactions t where t.customerId=?1 order by t.transactionDt desc")
    List<AccountTransactions> findByCustomerIdOrOrderByTransactionDtDesc(Long customerId);
}
