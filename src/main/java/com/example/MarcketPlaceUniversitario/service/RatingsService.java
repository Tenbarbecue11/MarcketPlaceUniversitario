package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Ratings;

import java.util.List;

public interface RatingsService {
    Ratings findById(long id);
    Ratings save(Ratings ratings);
    Ratings update(Ratings ratings,long id);
    void delete(long id);
    List<Ratings> listar();
}
