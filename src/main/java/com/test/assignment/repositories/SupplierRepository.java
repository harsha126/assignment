package com.test.assignment.repositories;

import com.test.assignment.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier findByName(String name);
}
