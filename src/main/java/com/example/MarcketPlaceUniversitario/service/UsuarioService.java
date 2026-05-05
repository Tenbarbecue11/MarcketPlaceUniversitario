package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario findById(long id);
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario,long id);
    List<Usuario> listarUsuarios();
    void delete(long id);
}
