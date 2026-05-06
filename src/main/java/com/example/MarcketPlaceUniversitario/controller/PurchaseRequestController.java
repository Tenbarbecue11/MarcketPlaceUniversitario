package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.model.PurchaseRequest;
import com.example.MarcketPlaceUniversitario.service.PurchaseRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/api/Request")
@RestController
public class PurchaseRequestController {

    private final PurchaseRequestService purchaseRequestService;
    public PurchaseRequestController(PurchaseRequestService purchaseRequestService) {
        this.purchaseRequestService = purchaseRequestService;
    }

    @PostMapping
    public PurchaseRequest save(@RequestBody PurchaseRequest purchaseRequest){
        return purchaseRequestService.save(purchaseRequest);
    }
    @GetMapping
    public List<PurchaseRequest> findAll(){
        return purchaseRequestService.findAllPurchaseRequests();
    }
    @GetMapping("/{id}")
    public PurchaseRequest findById(@PathVariable long id){
        return purchaseRequestService.findById(id);
    }
    @PutMapping ("/{id}")
    public PurchaseRequest update(@PathVariable long id, @RequestBody PurchaseRequest purchaseRequest){
        return purchaseRequestService.update(purchaseRequest,id);
    }
    @DeleteMapping ("/{id}")
    public void delete(@PathVariable long id){
        purchaseRequestService.delete(id);
    }

}
