package com.ikechukwu.productmgtapi.services;

import com.ikechukwu.productmgtapi.dto.ProductDTO;
import com.ikechukwu.productmgtapi.entity.Product;
import com.ikechukwu.productmgtapi.exceptions.ProductNotFoundException;
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

    @Override
    public String updateProduct(Product product) {
        Product existingProduct = productRepository.findByProductName(product.getProductName()).orElse(product);
        existingProduct.setProductCode(product.getProductCode());
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setManufacturer(product.getManufacturer());
        existingProduct.setQuantityInStore(product.getQuantityInStore());
        productRepository.save(existingProduct);
        return "Product: " + product.getProductName() + ", has been updated.";

    }

    @Override
    public Product getProduct(String uuid) {
        try{
            Product product = productRepository.findProductByCode(UUID.fromString(uuid));
            if (product == null) {
                throw new ProductNotFoundException("Product with code: " + uuid + ", not found.");
            } else {
                return product;
            }
        } catch (Exception ex){
            return getProduct(uuid);
        }
    }
}
