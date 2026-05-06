package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.PurchaseRequest;
import com.example.MarcketPlaceUniversitario.repository.PurchaseRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRequestServiceIMP implements PurchaseRequestService{

    private final PurchaseRequestRepository purchaseRequestRepository;
    public PurchaseRequestServiceIMP(PurchaseRequestRepository purchaseRequestRepository) {
        this.purchaseRequestRepository = purchaseRequestRepository;
    }

    @Override
    public PurchaseRequest save(PurchaseRequest purchaseRequest) {
        return purchaseRequestRepository.save(purchaseRequest);
    }

    @Override
    public PurchaseRequest findById(long id) {
        return purchaseRequestRepository.findById(id).
                orElseThrow(()->new RuntimeException("NOT FOUND"));
    }

    @Override
    public List<PurchaseRequest> findAllPurchaseRequests() {
        return purchaseRequestRepository.findAll();
    }

    @Override
    public PurchaseRequest update(PurchaseRequest purchaseRequest, long id) {
        PurchaseRequest existente=findById(id);
        existente.setPosts(purchaseRequest.getPosts());
        existente.setBuyer(purchaseRequest.getBuyer());
        existente.setEstado(purchaseRequest.getEstado());
        existente.setSeller(purchaseRequest.getSeller());
        return purchaseRequestRepository.save(existente);
    }

    @Override
    public void delete(long id) {
        findById(id);
        purchaseRequestRepository.deleteById(id);
    }
}
