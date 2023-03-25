package com.ikechukwu.productmgtapi.controller;

import com.ikechukwu.productmgtapi.dto.ProductDTO;
import com.ikechukwu.productmgtapi.entity.Product;
import com.ikechukwu.productmgtapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("create-product")
    public String createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PostMapping("update-product")
    public String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("fetch-product/{code}")
    public Product fetchProductByCode(@PathVariable String code){
        return productService.getProduct(code);
    }



}
