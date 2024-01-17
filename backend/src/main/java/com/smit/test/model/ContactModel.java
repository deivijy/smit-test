package com.smit.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "contacts")
public class ContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private String secretCode;

    private String phoneNumber;
}