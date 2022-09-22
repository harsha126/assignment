package com.test.assignment.api.v1.model;

import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class InventoryDTO {
    private Long id;
    private Product product;
    private String batch;
    private Long stock;
    private Long deal;
    private Long free;
    private Float mrp;
    private Float rate;
    private Date expDate;

}
