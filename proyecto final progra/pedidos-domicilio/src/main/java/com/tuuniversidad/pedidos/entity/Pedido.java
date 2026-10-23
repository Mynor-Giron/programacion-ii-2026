package com.tuuniversidad.pedidos.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String direccion;
    private LocalDateTime fechaPedido = LocalDateTime.now();
    private Double totalPedido;
    private Double costoEnvio;
    private Double totalFinal;
    private String estado = "RECIBIDO";

    @ManyToOne
    @JoinColumn(name = "zona_entrega_id")
    private ZonaEntrega zonaEntrega;

    public Pedido() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public LocalDateTime getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDateTime fechaPedido) { this.fechaPedido = fechaPedido; }
    public Double getTotalPedido() { return totalPedido; }
    public void setTotalPedido(Double totalPedido) { this.totalPedido = totalPedido; }
    public Double getCostoEnvio() { return costoEnvio; }
    public void setCostoEnvio(Double costoEnvio) { this.costoEnvio = costoEnvio; }
    public Double getTotalFinal() { return totalFinal; }
    public void setTotalFinal(Double totalFinal) { this.totalFinal = totalFinal; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public ZonaEntrega getZonaEntrega() { return zonaEntrega; }
    public void setZonaEntrega(ZonaEntrega zonaEntrega) { this.zonaEntrega = zonaEntrega; }
}