package com.tuuniversidad.pedidos.repository;

import com.tuuniversidad.pedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByEstado(String estado);
    List<Pedido> findByZonaEntregaId(Long zonaId);

    @Query("SELECT p FROM Pedido p WHERE p.estado = 'RECIBIDO' OR p.estado = 'EN_RUTA'")
    List<Pedido> findEntregasPendientes();

    @Query("SELECT SUM(p.totalFinal) FROM Pedido p WHERE DATE(p.fechaPedido) = :fecha")
    Double sumarTotalPorFecha(@Param("fecha") LocalDate fecha);
}