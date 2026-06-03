package com.biblioteca;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.repository.PrestamoRepository;
import com.biblioteca.repository.UsuarioRepository;
import com.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private PrestamoService prestamoService;

    @Override
    public void run(String... args) throws Exception {
        if (libroRepository.count() == 0) {
            libroRepository.saveAll(Arrays.asList(
                new Libro(null, "Cien años de soledad", "García Márquez", "978-0307474728", "Novela", 1967, true),
                new Libro(null, "El código Da Vinci", "Dan Brown", "978-0307474278", "Thriller", 2003, true),
                new Libro(null, "Clean Code", "Robert Martin", "978-0132350884", "Tecnología", 2008, true),
                new Libro(null, "Harry Potter y la piedra filosofal", "J.K. Rowling", "978-8478884451", "Fantasía", 1997, true),
                new Libro(null, "El principito", "Antoine de Saint-Exupéry", "978-0156012195", "Clásico", 1943, true)
            ));
        }

        if (usuarioRepository.count() == 0) {
            usuarioRepository.saveAll(Arrays.asList(
                new Usuario(null, "Juan Pérez", "juan@mail.com", "123456789", "U001", LocalDate.now()),
                new Usuario(null, "María García", "maria@mail.com", "987654321", "U002", LocalDate.now()),
                new Usuario(null, "Carlos López", "carlos@mail.com", "456789123", "U003", LocalDate.now())
            ));
        }

        if (prestamoRepository.count() == 0) {
            Usuario juan = usuarioRepository.findByEmail("juan@mail.com").get();
            Libro cleanCode = libroRepository.findAll().stream()
                    .filter(l -> l.getTitulo().equals("Clean Code"))
                    .findFirst().get();
            
            prestamoService.prestarLibro(juan.getId(), cleanCode.getId());
        }
    }
}
