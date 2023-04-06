package com.drag.demo.service;

import com.drag.demo.model.Product;
import com.drag.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> readProducts() {
        return productRepository.findAll();
    }
}
