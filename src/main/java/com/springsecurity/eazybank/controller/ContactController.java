package com.springsecurity.eazybank.controller;

import com.springsecurity.eazybank.model.ContactDetails;
import com.springsecurity.eazybank.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/myContact")
    public ResponseEntity<List<ContactDetails>> getContactDetails(@RequestParam Long contactId) {
        List<ContactDetails> contactDetails = contactService.getContactDetails(contactId);
        if (Objects.isNull(contactDetails)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contactDetails);
    }
}
