package com.springsecurity.eazybank.repository;

import com.springsecurity.eazybank.model.NoticeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoticeRepository extends MongoRepository<NoticeDetails, Long> {
    List<NoticeDetails> findByEndDateBefore(Date date);
}
