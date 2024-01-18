package com.springsecurity.eazybank.service;

import com.springsecurity.eazybank.model.ContactDetails;
import com.springsecurity.eazybank.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<ContactDetails> getContactDetails(Long contactId) {
        return contactRepository.findAllByContactId(contactId);
    }
}
