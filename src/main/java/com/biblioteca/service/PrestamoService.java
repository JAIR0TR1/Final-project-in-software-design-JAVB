package com.biblioteca.service;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.repository.PrestamoRepository;
import com.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Prestamo> obtenerTodos() { return prestamoRepository.findAll(); }
    public List<Prestamo> obtenerPorUsuario(String usuarioId) { return prestamoRepository.findByUsuarioId(usuarioId); }
    public List<Prestamo> obtenerActivos() { return prestamoRepository.findByEstado("ACTIVO"); }

    public Prestamo prestarLibro(String usuarioId, String libroId) {
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        
        if (!libro.isDisponible()) {
            throw new RuntimeException("Libro no disponible");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Prestamo prestamo = new Prestamo();
        prestamo.setUsuarioId(usuarioId);
        prestamo.setLibroId(libroId);
        prestamo.setNombreUsuario(usuario.getNombre());
        prestamo.setTituloLibro(libro.getTitulo());
        prestamo.setFechaPrestamo(LocalDateTime.now());
        prestamo.setEstado("ACTIVO");

        libro.setDisponible(false);
        libroRepository.save(libro);

        return prestamoRepository.save(prestamo);
    }

    public Prestamo devolverLibro(String prestamoId) {
        Prestamo prestamo = prestamoRepository.findById(prestamoId)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        if ("DEVUELTO".equals(prestamo.getEstado())) {
            throw new RuntimeException("El libro ya fue devuelto");
        }

        Libro libro = libroRepository.findById(prestamo.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        prestamo.setEstado("DEVUELTO");
        prestamo.setFechaDevolucion(LocalDateTime.now());
        
        libro.setDisponible(true);
        libroRepository.save(libro);

        return prestamoRepository.save(prestamo);
    }
    
    public void eliminar(String id) { prestamoRepository.deleteById(id); }
}
