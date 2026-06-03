package com.biblioteca.service;

import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> obtenerTodos() { return libroRepository.findAll(); }
    public List<Libro> obtenerDisponibles() { return libroRepository.findByDisponibleTrue(); }
    public Optional<Libro> obtenerPorId(String id) { return libroRepository.findById(id); }
    public Libro crear(Libro libro) { return libroRepository.save(libro); }
    public Libro actualizar(String id, Libro libro) {
        libro.setId(id);
        return libroRepository.save(libro);
    }
    public void eliminar(String id) { libroRepository.deleteById(id); }
}
