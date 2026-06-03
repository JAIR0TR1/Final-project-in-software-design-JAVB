package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listar() { return libroService.obtenerTodos(); }

    @GetMapping("/{id}")
    public Libro obtener(@PathVariable String id) { return libroService.obtenerPorId(id).orElse(null); }

    @GetMapping("/disponibles")
    public List<Libro> listarDisponibles() { return libroService.obtenerDisponibles(); }

    @PostMapping
    public Libro crear(@RequestBody Libro libro) { return libroService.crear(libro); }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable String id, @RequestBody Libro libro) { return libroService.actualizar(id, libro); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) { libroService.eliminar(id); }
}
