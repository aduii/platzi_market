package com.platzi.marketv2.persistence;

import com.platzi.marketv2.domain.Product;
import com.platzi.marketv2.domain.repository.ProductRepository;
import com.platzi.marketv2.persistence.crud.ProductoCrudRepository;
import com.platzi.marketv2.persistence.entity.Producto;
import com.platzi.marketv2.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositoryImpl implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public Product save(Product product) {
        Producto producto = productoCrudRepository.save(mapper.toProducto(product));
        return mapper.toProduct(producto);
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos = productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategoryId(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(prod -> mapper.toProduct(prod));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
