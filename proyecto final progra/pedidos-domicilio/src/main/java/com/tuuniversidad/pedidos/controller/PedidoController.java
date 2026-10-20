package com.tuuniversidad.pedidos.controller;

import com.tuuniversidad.pedidos.dto.PedidoRequestDTO;
import com.tuuniversidad.pedidos.dto.PedidoResponseDTO;
import com.tuuniversidad.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired private PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> registrar(@RequestBody PedidoRequestDTO dto) {
        return new ResponseEntity<>(service.registrar(dto), HttpStatus.CREATED);
    }
}