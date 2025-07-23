package com.arinash.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arinash.crm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}

