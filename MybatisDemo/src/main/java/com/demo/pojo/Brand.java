package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Brand {
    private Integer id;
    private String brand;
    private String companyName;
    private Integer ordered;
    private String description;
    private Integer status;
}
