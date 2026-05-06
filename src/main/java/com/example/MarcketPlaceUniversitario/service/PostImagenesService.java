package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.PostImagenes;

import java.util.List;

public interface PostImagenesService {
    PostImagenes save(PostImagenes postImagenes);
    PostImagenes findById(Long id);
    PostImagenes update(PostImagenes postImagenes,long id);
    List<PostImagenes> findAll();
    void delete(Long id);
}
