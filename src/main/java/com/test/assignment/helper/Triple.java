package com.test.assignment.helper;

import com.test.assignment.domain.Batch;
import com.test.assignment.domain.Product;
import com.test.assignment.domain.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Triple {
    Supplier supplier;
    Product product;
    Batch batch;
}
