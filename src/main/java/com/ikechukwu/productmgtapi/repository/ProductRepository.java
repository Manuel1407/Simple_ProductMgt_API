package com.ikechukwu.productmgtapi.repository;

import com.ikechukwu.productmgtapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
