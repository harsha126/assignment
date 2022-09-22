package com.test.assignment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private String batch;
    private Long stock;
    private Long deal;
    private Long free;
    private Float mrp;
    private Float rate;
    private Date expDate;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;
}
