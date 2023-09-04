package com.platzi.marketv2.persistence;

import com.platzi.marketv2.domain.Purchase;
import com.platzi.marketv2.domain.repository.PurchaseRepository;
import com.platzi.marketv2.persistence.crud.CompraCrudRepository;
import com.platzi.marketv2.persistence.entity.Compra;
import com.platzi.marketv2.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepositoryImpl implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases(compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClientId(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto-> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
