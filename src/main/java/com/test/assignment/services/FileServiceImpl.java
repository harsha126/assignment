package com.test.assignment.services;

import com.test.assignment.helper.Input;
import com.test.assignment.helper.csvhelper;
import com.test.assignment.repositories.InventoryRepository;
import com.test.assignment.repositories.ProductRepository;
import com.test.assignment.repositories.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Service
public class FileServiceImpl implements FileService {
    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;
    private final SupplierRepository supplierRepository;

    private csvhelper csvhelper = new csvhelper();

    public FileServiceImpl(ProductRepository productRepository, InventoryRepository inventoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void save(MultipartFile file) throws IOException {
        List<Input> inputs = csvhelper.csvToInputs(file.getInputStream());
    }

    @Override
    public List<Input> getAllInputs() {
        return null;
    }
}