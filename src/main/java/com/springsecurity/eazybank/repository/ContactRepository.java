package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.ContactDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends MongoRepository<ContactDetails, Long> {
    List<ContactDetails> findAllByContactId(Long contactId);
}
