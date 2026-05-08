package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.UsuarioRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.UsuarioResponseDTO;
import com.example.MarcketPlaceUniversitario.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findById(long id);
    UsuarioResponseDTO save(UsuarioRequestDTO dto);
    Usuario update(Usuario usuario,long id);
    List<Usuario> listarUsuarios();
    void delete(long id);
}
