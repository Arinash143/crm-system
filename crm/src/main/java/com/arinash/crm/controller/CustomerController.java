package com.arinash.crm.controller;

import com.arinash.crm.entity.Customer;
import com.arinash.crm.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/search")
    public ResponseEntity<Customer> searchByEmail(@RequestParam String email) {
        Customer customer = customerRepo.findByEmail(email);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }
}
