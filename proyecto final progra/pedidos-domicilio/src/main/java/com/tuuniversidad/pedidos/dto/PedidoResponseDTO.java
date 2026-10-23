package com.tuuniversidad.pedidos.dto;

import java.time.LocalDateTime;

public class PedidoResponseDTO {
    private Long id;
    private String cliente;
    private String direccion;
    private LocalDateTime fechaPedido;
    private Double totalPedido;
    private Double costoEnvio;
    private Double totalFinal;
    private String estado;
    private String nombreZona;

    // Getters y Setters
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
    public String getNombreZona() { return nombreZona; }
    public void setNombreZona(String nombreZona) { this.nombreZona = nombreZona; }
}