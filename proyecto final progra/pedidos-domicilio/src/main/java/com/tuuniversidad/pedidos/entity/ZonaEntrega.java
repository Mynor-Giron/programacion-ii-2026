package com.tuuniversidad.pedidos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "zona_entrega")
public class ZonaEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double costo;

    public ZonaEntrega() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }
}
