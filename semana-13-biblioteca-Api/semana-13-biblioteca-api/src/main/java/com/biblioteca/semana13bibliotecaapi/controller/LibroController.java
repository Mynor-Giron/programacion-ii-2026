package com.biblioteca.semana13bibliotecaapi.controller;

import com.biblioteca.semana13bibliotecaapi.entity.Libro;
import com.biblioteca.semana13bibliotecaapi.repository.LibroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodos() {
        List<Libro> libros = libroRepository.findAll();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        Optional<Libro> libroOpt = libroRepository.findById(id);
        if (libroOpt.isPresent()) {
            return ResponseEntity.ok(libroOpt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro) {
        Libro libroGuardado = libroRepository.save(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        Optional<Libro> libroOpt = libroRepository.findById(id);
        if (libroOpt.isPresent()) {
            Libro libroExistente = libroOpt.get();
            libroExistente.setCodigo(libroDetalles.getCodigo());
            libroExistente.setTitulo(libroDetalles.getTitulo());
            libroExistente.setAutor(libroDetalles.getAutor());
            libroExistente.setCategoria(libroDetalles.getCategoria());
            libroExistente.setAnioPublicacion(libroDetalles.getAnioPublicacion());
            libroExistente.setPrecio(libroDetalles.getPrecio());
            libroExistente.setDisponible(libroDetalles.getDisponible());

            Libro actualizado = libroRepository.save(libroExistente);
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Libro>> obtenerPorCategoria(@PathVariable String categoria) {
        List<Libro> libros = libroRepository.findByCategoriaIgnoreCase(categoria);
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Libro>> obtenerDisponibles() {
        List<Libro> disponibles = libroRepository.findByDisponibleTrue();
        return ResponseEntity.ok(disponibles);
    }
}