package com.ikechukwu.productmgtapi.services;

import com.ikechukwu.productmgtapi.dto.ProductDTO;
import com.ikechukwu.productmgtapi.entity.Product;
import com.ikechukwu.productmgtapi.response.APIResponse;

import java.util.List;

public interface ProductService {

    APIResponse<Product> saveProduct(ProductDTO productdto);

    APIResponse<Product> updateProduct(Long id, ProductDTO productDTO);

    APIResponse<Product> getProduct(String uuid);

    APIResponse<List<Product>> searchProductByName(String name);

    APIResponse<Product> deleteProduct(Long id);

    APIResponse<List<Product>> getProductsWithPriceAboveHundred();
}
