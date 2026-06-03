package com.biblioteca.service;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos() { return usuarioRepository.findAll(); }
    public Optional<Usuario> obtenerPorId(String id) { return usuarioRepository.findById(id); }
    public Usuario crear(Usuario usuario) { return usuarioRepository.save(usuario); }
    public Usuario actualizar(String id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }
    public void eliminar(String id) { usuarioRepository.deleteById(id); }
}
