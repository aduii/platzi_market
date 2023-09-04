package com.platzi.marketv2.domain.repository;

import com.platzi.marketv2.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    List<Product> getAll();
    Optional<List<Product>> getByCategoryId(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProductById(int productId);
    void delete(int productId);
}
