package com.smit.test.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "contacts")
public class ContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private String secretCode;

    private String phoneNumber;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    private ContactModel() {}

    public ContactModel(String firstName, String lastName, String secretCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secretCode = secretCode;
        this.phoneNumber = phoneNumber;
    }

}