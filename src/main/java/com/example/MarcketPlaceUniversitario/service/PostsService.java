package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.PostRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.PostResponseDTO;

import java.util.List;

public interface PostsService {
    PostResponseDTO save(PostRequestDTO dto);
    PostResponseDTO update(PostRequestDTO dto, long id);
    PostResponseDTO findById(long id);
    void delete(long id);
    List<PostResponseDTO> findAllPosts();
}