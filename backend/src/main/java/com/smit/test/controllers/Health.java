package com.smit.test.controllers;

import com.smit.test.dto.HealthStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class Health {
    @GetMapping
    public HealthStatus health() {
        return new HealthStatus("Alive");
    }

}
