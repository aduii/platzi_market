package com.platzi.marketv2.domain.service;

import com.platzi.marketv2.domain.Purchase;
import com.platzi.marketv2.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClientId(String clientId){
        return purchaseRepository.getByClientId(clientId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
