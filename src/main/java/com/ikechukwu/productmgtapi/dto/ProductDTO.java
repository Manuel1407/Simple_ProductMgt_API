package com.ikechukwu.productmgtapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

    private String productName;
    private double price;
    private String manufacturer;
    private String status;
    private int quantityInStore;

}
