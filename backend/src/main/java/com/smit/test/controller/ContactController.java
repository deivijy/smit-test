package com.smit.test.controller;

import com.smit.test.model.ContactModel;
import com.smit.test.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("contacts")
public class ContactController {
    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping
    public Iterable<ContactModel> findAllEmployees() {
        return this.contactRepository.findAll();
    }

    @PostMapping
    public ContactModel addOneContact(@RequestBody ContactModel contact) {
        return this.contactRepository.save(contact);
    }
}
