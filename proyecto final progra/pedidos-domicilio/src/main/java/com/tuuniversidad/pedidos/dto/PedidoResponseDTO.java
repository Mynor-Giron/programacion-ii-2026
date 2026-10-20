package com.tuuniversidad.pedidos.dto;

import java.time.LocalDateTime;

public class PedidoResponseDTO {
    private Long id;
    private String cliente;
    private String direccion;
    private LocalDateTime fechaPedido;
    private Double total;
    private String estado;
    private String nombreRepartidor;

    public PedidoResponseDTO(Long id, String cliente, String direccion, LocalDateTime fechaPedido, Double total, String estado, String nombreRepartidor) {
        this.id = id;
        this.cliente = cliente;
        this.direccion = direccion;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
        this.nombreRepartidor = nombreRepartidor;
    }

    public Long getId() { return id; }
    public String getCliente() { return cliente; }
    public String getDireccion() { return direccion; }
    public LocalDateTime getFechaPedido() { return fechaPedido; }
    public Double getTotal() { return total; }
    public String getEstado() { return estado; }
    public String getNombreRepartidor() { return nombreRepartidor; }
}