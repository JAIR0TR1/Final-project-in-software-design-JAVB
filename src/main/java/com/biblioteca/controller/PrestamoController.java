package com.biblioteca.controller;

import com.biblioteca.model.Prestamo;
import com.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> listar() { return prestamoService.obtenerTodos(); }

    @GetMapping("/usuario/{usuarioId}")
    public List<Prestamo> listarPorUsuario(@PathVariable String usuarioId) { return prestamoService.obtenerPorUsuario(usuarioId); }

    @GetMapping("/activos")
    public List<Prestamo> listarActivos() { return prestamoService.obtenerActivos(); }

    @PostMapping("/prestar")
    public Prestamo prestar(@RequestBody Map<String, String> request) {
        return prestamoService.prestarLibro(request.get("usuarioId"), request.get("libroId"));
    }

    @PutMapping("/devolver/{prestamoId}")
    public Prestamo devolver(@PathVariable String prestamoId) {
        return prestamoService.devolverLibro(prestamoId);
    }
}
