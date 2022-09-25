package com.test.assignment.controller;

import com.test.assignment.api.v1.model.ProductDTO;
import com.test.assignment.api.v1.model.ProductListDTO;
import com.test.assignment.services.ProductService;
import com.test.assignment.services.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public Page<ProductDTO> getAllProducts(@RequestParam(name = "page",defaultValue = "0") int page,
                                               @RequestParam(name = "size",defaultValue = "5") int size){
        System.out.println(page);
        System.out.println(size);

        return productService.getAllProducts(PageRequest.of(page,size));
    }

//    @GetMapping
//    public ResponseEntity<ProductListDTO> getAllProducts(){
//        return new ResponseEntity<ProductListDTO>(new ProductListDTO(productService.getAllProducts()), HttpStatus.OK);
//    }

    @GetMapping("{name}")
    public Page<ProductDTO> getProduct(@PathVariable String name,
                                       @RequestParam(name = "page",defaultValue = "0") int page,
                                       @RequestParam(name = "size",defaultValue = "5") int size){
        try{
            Long al = Long.parseLong(name);
            return productService.getProductById(al,PageRequest.of(page, size));
        }
        catch (Exception e){
            return productService.getProductByName(name,PageRequest.of(page, size));
        }
    }

//    @GetMapping({"{id}"})
//    public ResponseEntity<ProductListDTO> getProducts(@PathVariable Long id, @RequestParam(name = "exp",defaultValue = "false") boolean bool){
//        log.debug("WENT INTO BOOL CONTROLLER -------------------------------");
//        System.out.println("WENT INTO BOOL CONTROLLER -------------------------------");
//        return new ResponseEntity<ProductListDTO>(new ProductListDTO(supplierService.getAllProductsNotExpiredById(id)),HttpStatus.OK);
//    }
}
