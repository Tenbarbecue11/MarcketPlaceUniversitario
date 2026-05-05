package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Ratings;
import com.example.MarcketPlaceUniversitario.repository.RatingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsServiceIMP implements RatingsService {
    private final RatingsRepository ratingsRepository;
    public RatingsServiceIMP(RatingsRepository ratingsRepository) {
        this.ratingsRepository = ratingsRepository;
    }


    @Override
    public Ratings findById(long id) {
        return ratingsRepository.findById(id).orElseThrow(()->new RuntimeException("Ratings not found"));
    }

    @Override
    public Ratings save(Ratings ratings) {
        return ratingsRepository.save(ratings);
    }

    @Override
    public Ratings update(Ratings ratings, long id) {
        Ratings extistente= findById(id);
        extistente.setComentario(ratings.getComentario());
        extistente.setDate(ratings.getDate());
        extistente.setTo(ratings.getTo());
        extistente.setFrom(ratings.getFrom());
        return ratingsRepository.save(extistente);
    }

    @Override
    public void delete(long id) {
        findById(id);
        ratingsRepository.deleteById(id);
    }

    @Override
    public List<Ratings> listar() {
        return ratingsRepository.findAll();
    }
}
