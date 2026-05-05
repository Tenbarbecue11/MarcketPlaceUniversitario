package com.example.MarcketPlaceUniversitario.repository;

import com.example.MarcketPlaceUniversitario.model.PostImagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImagenesRepository extends JpaRepository<PostImagenes, Long> {
}
