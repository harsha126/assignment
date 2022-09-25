package com.test.assignment.repositories;

import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);
//
//    @Query("SELECT p from Supplier s join Supplier.products p where s.id = ?2 and p.name like '%?1%' and s.id = p")
//    List<Product> findAll();
}
