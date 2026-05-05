package com.example.MarcketPlaceUniversitario.repository;

import com.example.MarcketPlaceUniversitario.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Long> {
}
