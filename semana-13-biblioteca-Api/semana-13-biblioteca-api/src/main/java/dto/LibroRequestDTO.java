package com.biblioteca.semana13bibliotecaapi.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class LibroRequestDTO {

    @NotBlank(message = "El código es obligatorio")
    @Size(max = 20, message = "El código admite máximo 20 caracteres")
    private String codigo;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 120, message = "El título admite máximo 120 caracteres")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    @NotNull(message = "El año de publicación es obligatorio")
    @Positive(message = "El año debe ser mayor que cero")
    private Integer anioPublicacion;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que cero")
    private BigDecimal precio;

    @NotNull(message = "El campo disponible es obligatorio")
    private Boolean disponible;

    public LibroRequestDTO() {}

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Integer getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(Integer anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
}