package com.biblioteca.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "prestamos")
public class Prestamo {
    @Id
    private String id;
    private String usuarioId;
    private String libroId;
    private String nombreUsuario;
    private String tituloLibro;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private String estado; // "ACTIVO" o "DEVUELTO"

    public Prestamo() {}

    public Prestamo(String id, String usuarioId, String libroId, String nombreUsuario, String tituloLibro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.nombreUsuario = nombreUsuario;
        this.tituloLibro = tituloLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getLibroId() { return libroId; }
    public void setLibroId(String libroId) { this.libroId = libroId; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getTituloLibro() { return tituloLibro; }
    public void setTituloLibro(String tituloLibro) { this.tituloLibro = tituloLibro; }

    public LocalDateTime getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDateTime fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDateTime getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDateTime fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
