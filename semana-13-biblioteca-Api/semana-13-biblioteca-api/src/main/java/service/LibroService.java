package com.biblioteca.semana13bibliotecaapi.service;

import com.biblioteca.semana13bibliotecaapi.dto.LibroRequestDTO;
import com.biblioteca.semana13bibliotecaapi.entity.Libro;
import com.biblioteca.semana13bibliotecaapi.exception.RecursoNoEncontradoException;
import com.biblioteca.semana13bibliotecaapi.repository.LibroRepository; // Corregido 'repository'
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> listar() {
        return repository.findAll();
    }

    public Libro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado con ID: " + id));
    }

    public Libro registrar(LibroRequestDTO dto) {
        Libro libro = new Libro();
        mapearDtoAEntidad(dto, libro);
        return repository.save(libro);
    }

    public Libro actualizar(Long id, LibroRequestDTO dto) {
        Libro libro = buscarPorId(id);
        mapearDtoAEntidad(dto, libro);
        return repository.save(libro);
    }

    public void eliminar(Long id) {
        Libro libro = buscarPorId(id);
        repository.delete(libro);
    }

    private void mapearDtoAEntidad(LibroRequestDTO dto, Libro libro) {
        libro.setCodigo(dto.getCodigo());
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setCategoria(dto.getCategoria());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setPrecio(dto.getPrecio());
        libro.setDisponible(dto.getDisponible());
    }
}