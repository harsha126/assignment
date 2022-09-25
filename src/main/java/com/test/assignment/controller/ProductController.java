package com.test.assignment.controller;

import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.ProductListDTO;
import com.test.assignment.services.ProductService;
import com.test.assignment.services.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/api/v1/products/")
public class ProductController {
    private final ProductService productService;
    private final SupplierService supplierService;

    public ProductController(ProductService productService, SupplierService supplierService) {
        this.productService = productService;
        this.supplierService = supplierService;
    }
    @GetMapping
    public ResponseEntity<ProductListDTO> getAllProducts(){
        return new ResponseEntity<ProductListDTO>(new ProductListDTO(productService.getAllProducts()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String name){
        try{
            Long al = Long.parseLong(name);
            return new ResponseEntity<ProductDTO>(productService.getProductById(al),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ProductDTO>(productService.getProductByName(name),HttpStatus.OK);
        }
    }

    @GetMapping({"{id}"})
    public ResponseEntity<ProductListDTO> getProducts(@PathVariable Long id, @RequestParam(name = "exp",defaultValue = "false") boolean bool){
        log.debug("WENT INTO BOOL CONTROLLER -------------------------------");
        System.out.println("WENT INTO BOOL CONTROLLER -------------------------------");
        return new ResponseEntity<ProductListDTO>(new ProductListDTO(supplierService.getAllProductsNotExpiredById(id)),HttpStatus.OK);
    }
}
