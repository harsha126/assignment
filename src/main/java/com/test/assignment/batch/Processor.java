package com.test.assignment.batch;

import com.test.assignment.domain.Batch;
import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import com.test.assignment.helper.Input;
import com.test.assignment.helper.Triple;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;

@Component
public class Processor implements ItemProcessor<Input, Triple> {
    static HashMap<String,Supplier> supplierHashMap = new HashMap<>();
    static HashMap<String,Product> productHashMap = new HashMap<>();
//    static HashMap<String,Batch> batchHashMap = new HashMap<>();

    @Override
    public Triple process(Input input) throws Exception {
        Supplier supplier;
        Product product;
        Batch batch;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        if(!supplierHashMap.containsKey(input.getSupplier())){
            supplierHashMap.put(input.getSupplier(), Supplier.builder().name(input.getSupplier()).build());
            supplier = supplierHashMap.get(input.getSupplier());
            supplier.setProducts(new HashSet<>());
        }
        else supplier = supplierHashMap.get(input.getSupplier());
        if(!productHashMap.containsKey(input.getName())){
            productHashMap.put(input.getName(),Product.builder().code(input.getCode()).name(input.getName()).company(input.getCompany()).build());
            product = productHashMap.get(input.getName());
            product.setSuppliers(new HashSet<>());
            product.setBatches(new HashSet<>());
        }
        else product = productHashMap.get(input.getName());
        supplier.getProducts().add(product);
        product.getSuppliers().add(supplier);
        batch = Batch.builder().batchId(input.getBatch()).deal(input.getDeal()).free(input.getFree()).stock(input.getStock()).product(product).rate(input.getRate()).mrp(input.getMrp()).build();
        try{
            batch.setExpDate(format.parse(input.getExp()));
        }
        catch (Exception e){
            batch.setExpDate(null);
        }
        product.getBatches().add(batch);
        return new Triple(supplier,product,batch);
    }
}
