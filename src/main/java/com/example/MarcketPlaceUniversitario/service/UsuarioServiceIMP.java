package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Usuario;
import com.example.MarcketPlaceUniversitario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
public class UsuarioServiceIMP implements UsuarioService{
    private final UsuarioRepository usuarioRepository;
    public UsuarioServiceIMP(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Usuario findById(long id) {
        return  usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario,long id) {
        Usuario existente=findById(id);
        existente.setNombre(usuario.getNombre());
        existente.setEstado(usuario.getEstado());
        existente.setCompras(usuario.getCompras());
        existente.setCorreo(usuario.getCorreo());
        existente.setFotoPerfil(usuario.getFotoPerfil());
        existente.setPassword(usuario.getPassword());
        return usuarioRepository.save(existente);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void delete(long id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }
}
