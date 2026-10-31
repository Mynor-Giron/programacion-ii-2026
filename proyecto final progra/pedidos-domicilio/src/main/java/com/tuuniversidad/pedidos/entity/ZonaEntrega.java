package com.tuuniversidad.pedidos.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "zona_entrega")
public class ZonaEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private BigDecimal costo;

    public ZonaEntrega() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public BigDecimal getCosto() { return costo; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }
}
