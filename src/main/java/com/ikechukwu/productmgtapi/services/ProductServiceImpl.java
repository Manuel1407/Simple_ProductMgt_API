package com.ikechukwu.productmgtapi.services;

import com.ikechukwu.productmgtapi.dto.ProductDTO;
import com.ikechukwu.productmgtapi.entity.Product;
import com.ikechukwu.productmgtapi.exceptions.ProductNotFoundException;
import com.ikechukwu.productmgtapi.repository.ProductRepository;
import com.ikechukwu.productmgtapi.response.APIResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public APIResponse<Product> saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductCode(UUID.randomUUID());
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setStatus(productDTO.getStatus());
        product.setManufacturer(productDTO.getManufacturer());
        product.setQuantityInStore(productDTO.getQuantityInStore());
        productRepository.save(product);
        return new APIResponse<>(true, "Product added successfully", product);
    }

    @Override
    public APIResponse<Product> updateProduct(Long productId, ProductDTO productDTO) {
        try {
            Product existingProduct = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException("Product Not Found"));

            existingProduct.setProductName(productDTO.getProductName());
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setStatus(productDTO.getStatus());
            existingProduct.setManufacturer(productDTO.getManufacturer());
            existingProduct.setQuantityInStore(productDTO.getQuantityInStore());
            productRepository.save(existingProduct);
            return new APIResponse<>(true, "Product added successfully", existingProduct);
        } catch (Exception ex) {
            return new APIResponse<>(true, ex.getMessage(), null);
        }

    }

    @Override
    public APIResponse<Product> getProduct(String uuid) {
        try{
            Product product = productRepository.findProductByProductCode(UUID.fromString(uuid));
            if (product == null) {
                throw new ProductNotFoundException("Product with code: " + uuid + ", not found.");
            } else {
                return new APIResponse<>(true, "Successful", product);
            }
        } catch (Exception ex){
            return new APIResponse<>(true, ex.getMessage(), null);
        }
    }

    @Override
    public APIResponse<List<Product>> searchProductByName(String name) {
        try {
            List<Product> products = productRepository.findProductsByProductNameContaining(name);
            if (products.size() == 0) {
                throw new ProductNotFoundException("There is no such product in our store.");
            }
            return new APIResponse<>(true, "Successful", products);
        } catch (Exception ex) {
            return new APIResponse<>(true, ex.getMessage(), null);
        }
    }

    @Override
    public APIResponse<Product> deleteProduct(Long id) {
         try {
             Product product = productRepository.findById(id)
                     .orElseThrow(() -> new ProductNotFoundException("Product not found."));
             productRepository.delete(product);
             return new APIResponse<Product>(true, "Product Deleted Successfully", null);
         } catch (Exception ex) {
             return new APIResponse<>(true, ex.getMessage(), null);
         }
    }
}
