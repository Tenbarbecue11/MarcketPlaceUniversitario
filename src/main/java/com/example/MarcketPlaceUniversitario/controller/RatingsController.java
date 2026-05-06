package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.model.Ratings;
import com.example.MarcketPlaceUniversitario.service.RatingsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/api/Ratings")
@RestController
public class RatingsController {
    private final RatingsService ratingsService;
    public RatingsController(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }

    @PostMapping
    public  Ratings save(@RequestBody Ratings ratings){
       return ratingsService.save(ratings);
    }

    @GetMapping
    public List<Ratings> findAll(){
        return ratingsService.listar();
    }
    @GetMapping ("/{id}")
    public Ratings findById(@PathVariable long id){
        return ratingsService.findById(id);
    }
    @PutMapping ("/{id}")
    public Ratings update(@PathVariable long id, @RequestBody Ratings ratings){
        return ratingsService.update(ratings, id);
    }
    @DeleteMapping ("/{id}")
    public void deleteById(@PathVariable long id){
        ratingsService.delete(id);
    }


}
