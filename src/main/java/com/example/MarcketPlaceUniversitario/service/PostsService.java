package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Posts;

import java.util.List;

public interface PostsService {
    Posts save(Posts posts);
    Posts update(Posts posts,long id);
    Posts findById(long id);
    void delete(long id);
    List<Posts> findAllPosts();
}
