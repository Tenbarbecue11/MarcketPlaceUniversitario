package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.model.Usuario;
import com.example.MarcketPlaceUniversitario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/api/Usuario")
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario save(Usuario usuario){
        return usuarioService.save(usuario);
    }
    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.listarUsuarios();

    }
    @GetMapping ("/{id}")
    public Usuario findById(@PathVariable long id){
        return usuarioService.findById(id);
    }
    @PutMapping ("/{id}")
    public Usuario update(@PathVariable long id, @RequestBody Usuario usuario){
        return usuarioService.update(usuario, id);
    }
    @DeleteMapping ("/{id}")
    public void deleteById(@PathVariable long id){
        usuarioService.delete(id);
    }
}
