package com.smit.test.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "employees")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private String secretCode;

    private String phoneNumber;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    private EmployeeModel() {}

    public EmployeeModel(String firstName, String lastName, String secretCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secretCode = secretCode;
        this.phoneNumber = phoneNumber;
    }

}