package com.platzi.marketv2.domain.service;

import com.platzi.marketv2.domain.Product;
import com.platzi.marketv2.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProductById(int productId) {
        return productRepository.getProductById(productId);
    }

    public Optional<List<Product>> getByCategoryId(int categoryId) {
        return productRepository.getByCategoryId(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProductById(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
