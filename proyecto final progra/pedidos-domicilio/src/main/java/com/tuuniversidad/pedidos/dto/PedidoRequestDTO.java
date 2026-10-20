package com.tuuniversidad.pedidos.dto;

public class PedidoRequestDTO {
    private String cliente;
    private String direccion;
    private Double total;
    private Long repartidorId;

    public PedidoRequestDTO() {}

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public Long getRepartidorId() { return repartidorId; }
    public void setRepartidorId(Long repartidorId) { this.repartidorId = repartidorId; }
}