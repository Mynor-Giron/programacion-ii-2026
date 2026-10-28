package com.tuuniversidad.pedidos.controller;

import com.tuuniversidad.pedidos.entity.ZonaEntrega;
import com.tuuniversidad.pedidos.repository.zonaEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zonas")
@CrossOrigin(origins = "*")
public class ZonaEntregaController {

    @Autowired
    private zonaEntregaRepository zonaRepo;

    @GetMapping
    public ResponseEntity<List<ZonaEntrega>> listarZonas() {
        return ResponseEntity.ok(zonaRepo.findAll());
    }
}