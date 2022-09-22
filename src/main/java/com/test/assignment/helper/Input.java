package com.test.assignment.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Input {
    private String code;
    private String name;
    private String batch;
    private Long stock;
    private Long deal;
    private Long free;
    private Float mrp;
    private Float rate;
    private Date date;
    private String company;
    private String supplier;

}
