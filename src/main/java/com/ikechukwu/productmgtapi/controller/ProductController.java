package com.ikechukwu.productmgtapi.controller;

import com.ikechukwu.productmgtapi.dto.ProductDTO;
import com.ikechukwu.productmgtapi.entity.Product;
import com.ikechukwu.productmgtapi.response.APIResponse;
import com.ikechukwu.productmgtapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("create-product")
    public ResponseEntity<APIResponse<Product>> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.saveProduct(productDTO), HttpStatus.CREATED);
    }

    @PostMapping("update-product/{id}")
    public ResponseEntity<APIResponse<Product>> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){
        return new ResponseEntity<>(productService.updateProduct(id, productDTO), HttpStatus.OK);
    }

    @GetMapping("fetch-product/{code}")
    public ResponseEntity<APIResponse<Product>> getProductByCode(@PathVariable String code){
        return new ResponseEntity<>(productService.getProduct(code), HttpStatus.OK);
    }

    @GetMapping("fetch-products-by-name/")
    public ResponseEntity<APIResponse<List<Product>>> getProducts(@RequestParam String name) {
        return ResponseEntity.ok(productService.searchProductByName(name));
    }

    public ResponseEntity<APIResponse<Product>> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

}
