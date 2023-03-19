package com.ikechukwu.productmgtapi.services;

import com.ikechukwu.productmgtapi.dto.ProductDTO;
import com.ikechukwu.productmgtapi.entity.Product;
import com.ikechukwu.productmgtapi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public String saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductCode(UUID.randomUUID());
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setStatus(productDTO.getStatus());
        product.setManufacturer(productDTO.getManufacturer());
        product.setQuantityInStore(productDTO.getQuantityInStore());
        productRepository.save(product);
        return "Product: " + product.getProductName() + ", has been added successfully";
    }
}
