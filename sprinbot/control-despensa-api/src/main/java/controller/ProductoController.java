package com.estudiante.despensa.controller;

import model.Producto;
import model.ResumenInventario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        productos.add(new Producto(1L, "Leche Entera", "Lácteos", 5, 2.50));
        productos.add(new Producto(2L, "Queso Fresco", "Lácteos", 2, 4.00));
        productos.add(new Producto(3L, "Arroz", "Granos", 4, 8.50));
        productos.add(new Producto(4L, "Frijol Negro", "Granos", 10, 3.20));
        productos.add(new Producto(5L, "Detergente Liquido", "Limpieza", 1, 15.00));
        productos.add(new Producto(6L, "Jabón Corporal", "Higiene", 3, 1.80));
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        Optional<Producto> productoEncontrado = productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        return productoEncontrado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> buscarPorCategoria(@PathVariable String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    @GetMapping("/stock-bajo")
    public List<Producto> obtenerStockBajo() {
        return productos.stream()
                .filter(p -> p.getCantidad() <= 3)
                .collect(Collectors.toList());
    }

    @GetMapping("/mayor-valor")
    public ResponseEntity<Producto> obtenerMayorValor() {
        Optional<Producto> productoMayorValor = productos.stream()
                .max((p1, p2) -> Double.compare(p1.calcularSubtotal(), p2.calcularSubtotal()));

        return productoMayorValor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/resumen")
    public ResumenInventario obtenerResumen() {
        int cantidadProductos = productos.size();
        int totalUnidades = productos.stream().mapToInt(Producto::getCantidad).sum();
        double valorTotal = productos.stream().mapToDouble(Producto::calcularSubtotal).sum();

        return new ResumenInventario(cantidadProductos, totalUnidades, valorTotal);
    }
}
