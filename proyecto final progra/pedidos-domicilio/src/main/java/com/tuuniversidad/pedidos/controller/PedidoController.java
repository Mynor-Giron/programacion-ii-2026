package com.tuuniversidad.pedidos.controller;

import com.tuuniversidad.pedidos.dto.PedidoRequestDTO;
import com.tuuniversidad.pedidos.dto.PedidoResponseDTO;
import com.tuuniversidad.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<PedidoResponseDTO> registrar(@Valid @RequestBody PedidoRequestDTO dto) {
        return new ResponseEntity<>(service.registrar(dto), HttpStatus.CREATED);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<PedidoResponseDTO>> porEstado(@PathVariable String estado) {
        return ResponseEntity.ok(service.buscarPorEstado(estado.toUpperCase()));
    }

    @GetMapping("/zona/{zonaId}")
    public ResponseEntity<List<PedidoResponseDTO>> porZona(@PathVariable Long zonaId) {
        return ResponseEntity.ok(service.buscarPorZona(zonaId));
    }

    @GetMapping("/pendientes")
    public ResponseEntity<List<PedidoResponseDTO>> pendientes() {
        return ResponseEntity.ok(service.entregasPendientes());
    }

    @GetMapping("/facturado/{fecha}")
    public ResponseEntity<Double> facturadoPorFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(service.totalFacturado(fecha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> modificar(@PathVariable Long id, @Valid @RequestBody PedidoRequestDTO dto) {
        return ResponseEntity.ok(service.modificar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}