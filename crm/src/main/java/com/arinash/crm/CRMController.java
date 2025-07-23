package com.arinash.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arinash.crm.entity.Customer;
import com.arinash.crm.entity.Lead;
import com.arinash.crm.repository.CustomerRepository;
import com.arinash.crm.repository.LeadRepository;

@RestController
@RequestMapping("/api/crm")
public class CRMController {

    private final CustomerRepository customerRepository;
    private final LeadRepository leadRepository;

    @Autowired
    public CRMController(CustomerRepository customerRepository, LeadRepository leadRepository) {
        this.customerRepository = customerRepository;
        this.leadRepository = leadRepository;
    }

    @PostMapping("/convert")
    public ResponseEntity<Customer> convertLeadToCustomer(@RequestParam Long leadId) {
        Lead lead = leadRepository.findById(leadId)
                .orElseThrow(() -> new RuntimeException("Lead not found"));

        Customer customer = new Customer();
        customer.setName(lead.getName());
        customer.setEmail(lead.getEmail());
        customer.setPhone(lead.getPhone()); // include phone
        customer.setStatus("Active");

        customerRepository.save(customer);
        leadRepository.delete(lead);

        return ResponseEntity.ok(customer);
    }

    @GetMapping("/search")
    public ResponseEntity<Customer> searchCustomerByEmail(@RequestParam String email) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


