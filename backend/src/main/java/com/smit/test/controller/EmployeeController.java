package com.smit.test.controller;

import com.smit.test.model.EmployeeModel;
import com.smit.test.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public Iterable<EmployeeModel> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeModel addOneEmployee(@RequestBody EmployeeModel employee) {
        return this.employeeRepository.save(employee);
    }
}
