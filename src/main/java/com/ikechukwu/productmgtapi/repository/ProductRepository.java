package com.ikechukwu.productmgtapi.repository;

import com.ikechukwu.productmgtapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findByProductName(String productName);
}
