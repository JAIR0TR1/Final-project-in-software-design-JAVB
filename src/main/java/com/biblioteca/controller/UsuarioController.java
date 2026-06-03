package com.biblioteca.controller;

import com.biblioteca.model.Usuario;
import com.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() { return usuarioService.obtenerTodos(); }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable String id) { return usuarioService.obtenerPorId(id).orElse(null); }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) { return usuarioService.crear(usuario); }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable String id, @RequestBody Usuario usuario) { return usuarioService.actualizar(id, usuario); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) { usuarioService.eliminar(id); }
}
