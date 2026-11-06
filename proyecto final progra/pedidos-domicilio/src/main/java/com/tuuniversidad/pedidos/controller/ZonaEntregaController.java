package com.tuuniversidad.pedidos.controller;

import com.tuuniversidad.pedidos.entity.ZonaEntrega;
import com.tuuniversidad.pedidos.repository.ZonaEntregaRepository;
import com.tuuniversidad.pedidos.dto.ZonaEntregaRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zonas")
@CrossOrigin(origins = "*")
public class ZonaEntregaController {

    @Autowired
    private ZonaEntregaRepository zonaRepo;


    @GetMapping
    public ResponseEntity<List<ZonaEntrega>> listarZonas() {
        return ResponseEntity.ok(zonaRepo.findAll());
    }

    @PostMapping
    public ResponseEntity<ZonaEntrega> crearZona(@Valid @RequestBody ZonaEntregaRequestDTO dto) {
        ZonaEntrega zona = new ZonaEntrega();
        zona.setNombre(dto.getNombre());
        zona.setCosto(dto.getCosto());
        return ResponseEntity.ok(zonaRepo.save(zona));
    }
}