package com.test.assignment.batch;

import com.test.assignment.domain.Batch;
import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import com.test.assignment.helper.Triple;
import com.test.assignment.repositories.BatchRepository;
import com.test.assignment.repositories.ProductRepository;
import com.test.assignment.repositories.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class InsertBulk implements ItemWriter<Triple> {
    private ProductRepository repository;
    private SupplierRepository supplierRepository;
    private BatchRepository batchRepository;

    public InsertBulk(ProductRepository repository, SupplierRepository supplierRepository, BatchRepository batchRepository) {
        this.repository = repository;
        this.supplierRepository = supplierRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public void write(List<? extends Triple> list) throws Exception {
        List<Supplier> list1 = new ArrayList<Supplier>();
        List<Product> list2 = new ArrayList<Product>();
        List<Batch> list3 = new ArrayList<Batch>();
        list.stream().forEach(triple -> {
            list1.add(triple.getSupplier());
            list2.add(triple.getProduct());
            list3.add(triple.getBatch());
        });

        repository.saveAll(list2);
        supplierRepository.saveAll(list1);
        batchRepository.saveAll(list3);
        log.info("THE PRODUCT REPO COUNT ---> "+repository.count());
        log.info("THE SUPPLIER REPO COUNT ---> "+supplierRepository.count());
        log.info("THE BATCH REPO COUNT ---> "+batchRepository.count());
    }
}
