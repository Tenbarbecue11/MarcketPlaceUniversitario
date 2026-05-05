package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.PurchaseRequest;

import java.util.List;

public interface PurchaseRequestService {
    PurchaseRequest findById(long id);
    PurchaseRequest save(PurchaseRequest purchaseRequest);
    PurchaseRequest update(PurchaseRequest purchaseRequest,long id);
    void delete(long id);
    List<PurchaseRequest> findAllPurchaseRequests();
}
