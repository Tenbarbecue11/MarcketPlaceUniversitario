package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.model.PostImagenes;
import com.example.MarcketPlaceUniversitario.service.PostImagenesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/postImagenes")
public class PostImagenesController {
    private final PostImagenesService postImagenesService;
    public PostImagenesController(PostImagenesService postImagenesService) {
        this.postImagenesService = postImagenesService;
    }

    @PostMapping
    public PostImagenes guardar(@RequestBody PostImagenes postImagenes){
        return postImagenesService.save(postImagenes);
    }
    @GetMapping
    public List<PostImagenes> listar(){
        return postImagenesService.findAll();
    }
    @GetMapping("/{id}")
    public PostImagenes buscar(@PathVariable long id){
        return postImagenesService.findById(id);
    }
    @PutMapping ("/{id}")
    public PostImagenes actualizar(@PathVariable long id, @RequestBody PostImagenes postImagenes) {
        return postImagenesService.update(postImagenes,id);
    }
    @DeleteMapping ("/{id}")
    public void eliminar(@PathVariable long id){
        postImagenesService.delete(id);
    }

}
