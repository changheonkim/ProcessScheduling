package com.drag.demo.repository;

import com.drag.demo.model.Company;
import com.drag.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
