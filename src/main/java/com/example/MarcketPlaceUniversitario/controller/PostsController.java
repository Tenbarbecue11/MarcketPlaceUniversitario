package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.DTO.PostRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.PostResponseDTO;
import com.example.MarcketPlaceUniversitario.service.PostsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Post")
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping
    public PostResponseDTO crear(@Valid @RequestBody PostRequestDTO dto) {
        return postsService.save(dto);
    }

    @GetMapping
    public List<PostResponseDTO> findAll() {
        return postsService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDTO buscar(@PathVariable long id) {
        return postsService.findById(id);
    }

    @PutMapping("/{id}")
    public PostResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody PostRequestDTO dto) {
        return postsService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        postsService.delete(id);
    }
}