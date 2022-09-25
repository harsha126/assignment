package com.test.assignment.helper;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Input {
    private String code;
    private String name;
    private String batch;
    private Long stock;
    private Long deal;
    private Long free;
    private Float mrp;
    private Float rate;
    private String exp;
    private String company;
    private String supplier;

}
