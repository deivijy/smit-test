package com.smit.test.controller;

import com.smit.test.model.ContactModel;
import com.smit.test.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final ContactRepository employeeRepository;

    public EmployeeController(ContactRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public Iterable<ContactModel> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @PostMapping
    public ContactModel addOneEmployee(@RequestBody ContactModel employee) {
        return this.employeeRepository.save(employee);
    }
}
