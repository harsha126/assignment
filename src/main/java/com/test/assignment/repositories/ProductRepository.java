package com.test.assignment.repositories;

import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByName(String name,Pageable pageable);
    Page<Product> findById(Long id,Pageable pageable);
    @Query("select p from Product p")
    Page<Product> findAll(Pageable pageable);
}
