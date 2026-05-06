package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.PostImagenes;
import com.example.MarcketPlaceUniversitario.repository.PostImagenesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImagenesServiceIMP implements PostImagenesService {

    private PostImagenesRepository postImagenesRepository;

    public PostImagenesServiceIMP(PostImagenesRepository postImagenesRepository) {
        this.postImagenesRepository = postImagenesRepository;
    }

    @Override
    public PostImagenes save(PostImagenes postImagenes) {
        return postImagenesRepository.save(postImagenes);
    }

    @Override
    public PostImagenes findById(Long id) {
        return postImagenesRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Esta imagen no existe"));
    }

    @Override
    public PostImagenes update(PostImagenes postImagenes,long id) {
        PostImagenes existente=findById(postImagenes.getId());
        existente.setPosts(postImagenes.getPosts());
        existente.setUrl(postImagenes.getUrl());
        existente.setOrden(postImagenes.getOrden());
        return postImagenesRepository.save(existente);
    }

    @Override
    public List<PostImagenes> findAll() {
        return postImagenesRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        postImagenesRepository.deleteById(id);
    }
}
