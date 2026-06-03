package com.biblioteca.model;

import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "usuarios")
public class Usuario extends Persona {
    private String numeroCarnet;
    private LocalDate fechaRegistro;

    public Usuario() {}

    public Usuario(String id, String nombre, String email, String telefono, String numeroCarnet, LocalDate fechaRegistro) {
        super(id, nombre, email, telefono);
        this.numeroCarnet = numeroCarnet;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNumeroCarnet() { return numeroCarnet; }
    public void setNumeroCarnet(String numeroCarnet) { this.numeroCarnet = numeroCarnet; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
