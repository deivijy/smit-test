package com.smit.test.service;

import com.smit.test.model.ContactModel;
import com.smit.test.repository.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Page<ContactModel> searchAndSortContacts(String searchQuery, String sortField, String sortDirection, int page, int size) {
        Sort sort = sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        if (searchQuery == null || searchQuery.trim().isEmpty()) {
            return contactRepository.findAll(pageable);
        } else {
            return contactRepository.findByFirstNameContainingOrLastNameContainingAllIgnoreCase(
                    searchQuery, searchQuery, pageable);
        }
    }


    public ContactModel addContact(ContactModel contact) {
        return this.contactRepository.save(contact);
    }
}
