package com.platzi.marketv2.domain.repository;

import com.platzi.marketv2.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClientId(String clientId);
    Purchase save(Purchase purchase);
}
