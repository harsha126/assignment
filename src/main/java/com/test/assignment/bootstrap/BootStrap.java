package com.test.assignment.bootstrap;

import com.test.assignment.domain.Batch;
import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import com.test.assignment.repositories.BatchRepository;
import com.test.assignment.repositories.ProductRepository;
import com.test.assignment.repositories.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class BootStrap implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final BatchRepository batchRepository;

    public BootStrap(ProductRepository productRepository, SupplierRepository supplierRepository, BatchRepository batchRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String before_date = "02-02-2000";
        String after_date = "02-02-2024";
        Batch Batch1 = Batch.builder().batchId("one").expDate(format.parse(before_date)).build();
        Batch Batch2 = Batch.builder().batchId("two").expDate(format.parse(after_date)).build();
        Batch Batch3 = Batch.builder().batchId("three").expDate(format.parse(before_date)).build();
        Batch Batch4 = Batch.builder().batchId("four").expDate(format.parse(after_date)).build();
        Batch Batch5 = Batch.builder().batchId("five").expDate(format.parse(before_date)).build();
        Batch Batch6 = Batch.builder().batchId("six").expDate(format.parse(after_date)).build();
        Batch Batch7 = Batch.builder().batchId("seven").expDate(format.parse(before_date)).build();
        Batch Batch8 = Batch.builder().batchId("Eight").expDate(format.parse(after_date)).build();
        Batch Batch9 = Batch.builder().batchId("nine").expDate(format.parse(before_date)).build();
        Batch Batch10 = Batch.builder().batchId("ten").expDate(format.parse(after_date)).build();



        log.debug("Added Batches to repo of size : "+ batchRepository.count());

        Supplier supplier0 = Supplier.builder().name("sup1").build();
        Supplier supplier1 = Supplier.builder().name("sup2").build();
        Supplier supplier2 = Supplier.builder().name("sup3").build();
        Supplier supplier3 = Supplier.builder().name("sup4").build();
        Supplier supplier4 = Supplier.builder().name("sup5").build();

        Product product0 = Product.builder().name("dolo").code("aaaa").company("bbbb").build();
        Product product1 = Product.builder().name("aspirin").code("cccc").company("dddd").build();
        Product product2 = Product.builder().name("paracetamol").code("eeee").company("ffff").build();
        Product product3 = Product.builder().name("zincovit").code("gggg").company("hhhh").build();
        Product product4 = Product.builder().name("zerodol").code("iiii").company("jjjj").build();
        Product product5 = Product.builder().name("citrizen").code("kkkk").company("rrrr").build();
        Product product6 = Product.builder().name("oflox-oz").code("llll").company("tttt").build();
        Product product7 = Product.builder().name("supracal").code("qqqq").company("yyyy").build();
        Product product8 = Product.builder().name("Zofor").code("wwww").company("hhhh").build();
        Product product9 = Product.builder().name("pan").code("uuuuu").company("opop").build();
        product1.getSuppliers().add(supplier1);
        product2.getSuppliers().add(supplier1);
        product3.getSuppliers().add(supplier2);
        product4.getSuppliers().add(supplier2);

        supplier1.getProducts().add(product1);
        supplier1.getProducts().add(product2);
        supplier2.getProducts().add(product3);
        supplier2.getProducts().add(product4);

        product1.getBatches().add(Batch1);
        product2.getBatches().add(Batch2);
        product3.getBatches().add(Batch3);
        product4.getBatches().add(Batch4);
        product5.getBatches().add(Batch5);
        product6.getBatches().add(Batch6);
        product7.getBatches().add(Batch7);
        product9.getBatches().add(Batch8);
        product0.getBatches().add(Batch9);
        product8.getBatches().add(Batch10);

        Batch1.setProduct(product1);
        Batch2.setProduct(product2);
        Batch3.setProduct(product3);
        Batch4.setProduct(product4);
        Batch5.setProduct(product5);
        Batch6.setProduct(product6);
        Batch7.setProduct(product7);
        Batch10.setProduct(product8);
        Batch8.setProduct(product9);
        Batch9.setProduct(product0);

        batchRepository.save(Batch1);
        batchRepository.save(Batch2);
        batchRepository.save(Batch3);
        batchRepository.save(Batch4);
        batchRepository.save(Batch5);
        batchRepository.save(Batch6);
        batchRepository.save(Batch7);
        batchRepository.save(Batch8);
        batchRepository.save(Batch9);
        batchRepository.save(Batch10);

        productRepository.save(product0);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product8);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product9);

        System.out.println("Data Loaded Products :"+productRepository.count());


        supplier0.getProducts().add(product0);
        supplier0.getProducts().add(product1);
        supplier2.getProducts().add(product4);
        supplier2.getProducts().add(product5);
        supplier3.getProducts().add(product6);
        supplier3.getProducts().add(product7);
        supplier4.getProducts().add(product8);
        supplier4.getProducts().add(product9);

        supplierRepository.save(supplier0);
        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);
        supplierRepository.save(supplier3);
        supplierRepository.save(supplier4);

        log.debug("Added suppliers to repo of size : "+ supplierRepository.count());


    }
}
