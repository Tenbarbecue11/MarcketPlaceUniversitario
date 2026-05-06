package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Posts;
import com.example.MarcketPlaceUniversitario.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceIMP implements PostsService {
    private final PostRepository postRepository;
    public PostsServiceIMP(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public Posts save(Posts posts) {
        return postRepository.save(posts);
    }

    @Override
    public Posts update(Posts posts,long id) {
        Posts existente = findById(posts.getId());
        existente.setCategoria(posts.getCategoria());
        existente.setTitulo(posts.getTitulo());
        existente.setPrecio(posts.getPrecio());
        existente.setEstado(posts.getEstado());
        existente.setDescricion(posts.getDescricion());
        return postRepository.save(existente);
    }

    @Override
    public Posts findById(long id) {
        return postRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el post"));
    }

    @Override
    public void delete(long id) {
        findById(id);
        postRepository.deleteById(id);
    }

    @Override
    public List<Posts> findAllPosts() {
        return postRepository.findAll();
    }
}
