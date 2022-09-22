package com.test.assignment.bootstrap;

import com.test.assignment.domain.Inventory;
import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import com.test.assignment.repositories.InventoryRepository;
import com.test.assignment.repositories.ProductRepository;
import com.test.assignment.repositories.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BootStrap implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final InventoryRepository inventoryRepository;

    public BootStrap(ProductRepository productRepository, SupplierRepository supplierRepository, InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Product product0 = Product.builder().code("aaaa").company("bbbb").build();
        Product product1 = Product.builder().code("cccc").company("dddd").build();
        Product product2 = Product.builder().code("eeee").company("ffff").build();
        Product product3 = Product.builder().code("gggg").company("hhhh").build();
        Product product4 = Product.builder().code("iiii").company("jjjj").build();
        Product product5 = Product.builder().code("kkkk").company("rrrr").build();
        Product product6 = Product.builder().code("llll").company("tttt").build();
        Product product7 = Product.builder().code("qqqq").company("yyyy").build();
        Product product8 = Product.builder().code("wwww").company("hhhh").build();
        Product product9 = Product.builder().code("uuuuu").company("opop").build();

        productRepository.save(product0);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);

        System.out.println("Data Loaded Products :"+productRepository.count());

        Supplier supplier0 = Supplier.builder().name("sup1").build();
        Supplier supplier1 = Supplier.builder().name("sup2").build();
        Supplier supplier2 = Supplier.builder().name("sup3").build();
        Supplier supplier3 = Supplier.builder().name("sup4").build();
        Supplier supplier4 = Supplier.builder().name("sup5").build();

        System.out.println("Data Loaded Supplier    :"+productRepository.count());
        Inventory inventory1 = Inventory.builder().batch("one").product(product0).supplier(supplier0).build();
        Inventory inventory2 = Inventory.builder().batch("two").product(product1).supplier(supplier0).build();
        Inventory inventory3 = Inventory.builder().batch("three").product(product2).supplier(supplier1).build();
        Inventory inventory4 = Inventory.builder().batch("four").product(product3).supplier(supplier1).build();
        Inventory inventory5 = Inventory.builder().batch("five").product(product4).supplier(supplier2).build();
        Inventory inventory6 = Inventory.builder().batch("six").product(product5).supplier(supplier2).build();
        Inventory inventory7 = Inventory.builder().batch("seven").product(product6).supplier(supplier3).build();
        Inventory inventory8 = Inventory.builder().batch("Eight").product(product7).supplier(supplier3).build();
        Inventory inventory9 = Inventory.builder().batch("nine").product(product9).supplier(supplier4).build();
        Inventory inventory10 = Inventory.builder().batch("ten").product(product9).supplier(supplier4).build();

        inventoryRepository.save(inventory1);
        inventoryRepository.save(inventory2);
        inventoryRepository.save(inventory3);
        inventoryRepository.save(inventory4);
        inventoryRepository.save(inventory5);
        inventoryRepository.save(inventory6);
        inventoryRepository.save(inventory7);
        inventoryRepository.save(inventory8);
        inventoryRepository.save(inventory9);
        inventoryRepository.save(inventory10);

        supplier0.getInventories().add(inventory1);
        supplier0.getInventories().add(inventory2);
        supplier1.getInventories().add(inventory3);
        supplier1.getInventories().add(inventory4);
        supplier2.getInventories().add(inventory5);
        supplier2.getInventories().add(inventory6);
        supplier3.getInventories().add(inventory7);
        supplier3.getInventories().add(inventory8);
        supplier4.getInventories().add(inventory9);
        supplier4.getInventories().add(inventory10);

        supplierRepository.save(supplier0);
        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);
        supplierRepository.save(supplier3);
        supplierRepository.save(supplier4);

    }
}
