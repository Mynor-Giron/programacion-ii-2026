package com.tuuniversidad.pedidos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PedidoRequestDTO {
    @NotBlank(message = "El cliente es obligatorio") private String cliente;
    @NotBlank(message = "La dirección es obligatoria") private String direccion;

    @NotNull(message = "El total es obligatorio")
    @PositiveOrZero(message = "El total debe ser mayor o igual a 0")
    private Double totalPedido;

    @NotNull(message = "El ID de la zona es obligatorio")
    private Long zonaEntregaId;

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Double getTotalPedido() { return totalPedido; }
    public void setTotalPedido(Double totalPedido) { this.totalPedido = totalPedido; }
    public Long getZonaEntregaId() { return zonaEntregaId; }
    public void setZonaEntregaId(Long zonaEntregaId) { this.zonaEntregaId = zonaEntregaId; }
}