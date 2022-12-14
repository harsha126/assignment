package com.test.assignment.repositories;

import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    //without Pagination
    Optional<Supplier> findByName(String name);
    Page<Supplier> findByName(String name, Pageable pageable);
    //without Pagination

    @Query("SELECT p from Supplier s join s.products p where s.id = ?2 and p.name like %?1% ")
    List<Product> findAll(String name, Long id);
    @Query("SELECT p from Supplier s join s.products p where s.id = ?2 and p.name like %?1% ")
    Page<Product> findAll(String name, Long id,Pageable pageable);
    //without Pagination

    @Query("SELECT p from Supplier s join s.products p where s.name = ?2 and p.name like %?1% ")
    List<Product> findAll(String name, String supp_name);
    @Query("SELECT p from Supplier s join s.products p where s.name = ?2 and p.name like %?1% ")
    Page<Product> findAll(String name, String supp_name,Pageable pageable);
    //without Pagination

//    @Query("SELECT Product FROM Product WHERE Product .id in (SELECT Product .id from Product join Supplier .products on Supplier .products.id = Product .id Join Supplier on Product .id = Supplier .products.id Join Batch on Batch .product.id = Product .id Where Batch .expDate > current_timestamp )")
//    @Query("SELECT p FROM Product p where p.id in (select p.id from Supplier s join s.products sp on sp.id = s.id join Product p on p.id = Supplier .products .id join Batch b on b.product.id = Product .id where b.expDate > current_timestamp and s.id = ?1)")
    @Query(value = "SELECT * FROM PRODUCTS WHERE PRODUCTS.ID IN ( SELECT PRODUCTS.ID FROM SUPPLIER\n" +
            " JOIN \n" +
            "SUPPLIER_PRODUCT ON SUPPLIER_PRODUCT.SUPP_ID = SUPPLIER.ID\n" +
            " JOIN \n" +
            "PRODUCTS ON PRODUCTS.ID = SUPPLIER_PRODUCT.PROD_ID\n" +
            " JOIN \n" +
            "BATCH ON BATCH.PRODUCT_ID = PRODUCTS.ID\n" +
            " WHERE BATCH.EXP_DATE> CURRENT_TIMESTAMP()\n" +
            " AND \n" +
            "SUPPLIER.ID = 3 )",
            nativeQuery = true
    )
//    @Query("select p from Product p")
    List<Product> findAll(Long id,Date date);
    @Query(value = "SELECT * FROM PRODUCTS WHERE PRODUCTS.ID IN ( SELECT PRODUCTS.ID FROM SUPPLIER\n" +
            " JOIN \n" +
            "SUPPLIER_PRODUCT ON SUPPLIER_PRODUCT.SUPP_ID = SUPPLIER.ID\n" +
            " JOIN \n" +
            "PRODUCTS ON PRODUCTS.ID = SUPPLIER_PRODUCT.PROD_ID\n" +
            " JOIN \n" +
            "BATCH ON BATCH.PRODUCT_ID = PRODUCTS.ID\n" +
            " WHERE BATCH.EXP_DATE> CURRENT_TIMESTAMP()\n" +
            " AND \n" +
            "SUPPLIER.ID = 3 )",
            nativeQuery = true
    )
//    @Query("select p from Product p")
    Page<Product> findAll(Long id,Date date,Pageable pageable);
    //without Pagination

    @Query("SELECT p from Supplier s join s.products p where s.id = ?1 ")
    List<Product> findAllById(Long id);
    //without Pagination
    @Query("SELECT p from Supplier s join s.products p where s.id = ?1 ")
    Page<Product> findAllById(Long id,Pageable pageable);
    @Query("SELECT p from Supplier s join s.products p where s.name = ?1 ")
    List<Product> findAllByName(String name);
    @Query("SELECT p from Supplier s join s.products p where s.name = ?1 ")
    Page<Product> findAllByName(String name,Pageable pageable);
    //without Pagination


    @Query("SELECT p from Supplier s join s.products p join p.batches b where s.name = ?1 and  b.expDate >=current_date ")
    List<Product> findAll(String str);
    @Query("SELECT p from Supplier s join s.products p join p.batches b where s.name = ?1 and  b.expDate >=current_date ")
    Page<Product> findAll(String str,Pageable pageable);
    //without Pagination

    @Query("SELECT p from Supplier s join s.products p join p.batches b where s.id = ?1 and  b.expDate >=current_date ")
    List<Product> findAll(Long id);
    @Query("SELECT p from Supplier s join s.products p join p.batches b where s.id = ?1 and  b.expDate >=current_date ")
    Page<Product> findAll(Long id,Pageable pageable);


    Page<Supplier> findById(Long id,Pageable pageable);


}
