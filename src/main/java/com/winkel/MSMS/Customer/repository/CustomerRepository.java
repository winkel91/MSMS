package com.winkel.MSMS.Customer.repository;

import com.winkel.MSMS.Customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

