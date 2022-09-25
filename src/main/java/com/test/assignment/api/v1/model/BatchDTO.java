package com.test.assignment.api.v1.model;

import com.test.assignment.domain.Product;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BatchDTO {
    private Long id;
    private String batchId;
    private Product product;
    private Long stock;
    private Long deal;
    private Long free;
    private Float mrp;
    private Float rate;
    private Date expDate;

}
