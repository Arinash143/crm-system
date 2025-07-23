package com.arinash.crm.controller;

import com.arinash.crm.entity.Customer;
import com.arinash.crm.entity.Lead;
import com.arinash.crm.repository.CustomerRepository;
import com.arinash.crm.repository.LeadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadRepository leadRepo;

    @Autowired
    private CustomerRepository customerRepo;

    // Create Lead
    @PostMapping
    public Lead createLead(@RequestBody Lead lead) {
        return leadRepo.save(lead);
    }

    // Convert Lead to Customer
    @PostMapping("/convertLead/{leadId}")
    public ResponseEntity<Customer> convertLeadToCustomer(@PathVariable Long leadId) {
        Lead lead = leadRepo.findById(leadId)
                      .orElseThrow(() -> new RuntimeException("Lead not found"));

        Customer customer = new Customer();
        customer.setName(lead.getName());
        customer.setEmail(lead.getEmail());
        customer.setPhone(lead.getPhone());
        customer.setStatus("Active");

        customerRepo.save(customer);
        leadRepo.delete(lead);

        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadRepo.findAll();
    }

    @GetMapping("/{id}")
    public Lead getLeadById(@PathVariable Long id) {
        return leadRepo.findById(id).orElseThrow(() -> new RuntimeException("Lead not found"));
    }
}


