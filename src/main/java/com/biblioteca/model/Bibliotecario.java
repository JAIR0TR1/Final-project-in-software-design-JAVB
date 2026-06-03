package com.biblioteca.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bibliotecarios")
public class Bibliotecario extends Persona {
    private String codigoEmpleado;
    private String turno;

    public Bibliotecario() {}

    public Bibliotecario(String id, String nombre, String email, String telefono, String codigoEmpleado, String turno) {
        super(id, nombre, email, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }

    public String getCodigoEmpleado() { return codigoEmpleado; }
    public void setCodigoEmpleado(String codigoEmpleado) { this.codigoEmpleado = codigoEmpleado; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
}
