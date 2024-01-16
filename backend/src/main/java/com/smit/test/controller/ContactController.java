package com.smit.test.controller;

import com.smit.test.model.ContactModel;
import com.smit.test.service.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public Page<ContactModel> findAllContacts(
            @RequestParam(required = false) String searchQuery,
            @RequestParam(defaultValue = "firstName") String sortField,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        return contactService.searchAndSortContacts(searchQuery, sortField, sortDirection, page, size);
    }


    @PostMapping
    public ContactModel addContact(@RequestBody ContactModel contact) {
        return this.contactService.addContact(contact);
    }
}
