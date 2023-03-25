package com.ikechukwu.productmgtapi.services;

import com.ikechukwu.productmgtapi.dto.ProductDTO;
import com.ikechukwu.productmgtapi.entity.Product;

public interface ProductService {

    public String saveProduct(ProductDTO productdto);

    public String updateProduct(Product product);

    public Product getProduct(String uuid);
}
