package com.biblioteca.repository;

import com.biblioteca.model.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LibroRepository extends MongoRepository<Libro, String> {
    List<Libro> findByDisponibleTrue();
    List<Libro> findByGenero(String genero);
}
