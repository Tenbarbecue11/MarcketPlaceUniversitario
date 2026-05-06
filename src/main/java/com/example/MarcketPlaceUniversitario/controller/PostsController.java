package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.model.Posts;
import com.example.MarcketPlaceUniversitario.service.PostsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/api/Post")
public class PostsController {
    private final PostsService postsService;
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }
    @PostMapping
    public Posts crear(@RequestBody Posts posts){
        return postsService.save(posts);
    }
    @GetMapping
    public List<Posts> findAll(){
        return postsService.findAllPosts();
    }
    @GetMapping ("/{id}")
    public Posts buscar(@PathVariable long id){
        return postsService.findById(id);
    }
    @PutMapping ("/{id}")
    public Posts actualizar(@PathVariable long id, @RequestBody Posts posts){
        return postsService.update(posts,id);
    }
    @DeleteMapping ("/{id}")
    public void eliminar(@PathVariable long id){
        postsService.delete(id);
    }

}
