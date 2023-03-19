package com.ikechukwu.productmgtapi.controller;

import com.ikechukwu.productmgtapi.dto.ProductDTO;
import com.ikechukwu.productmgtapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("create-product")
    public String createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

}
