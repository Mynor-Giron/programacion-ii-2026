package com.tuuniversidad.pedidos.repository;

import com.tuuniversidad.pedidos.entity.ZonaEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaEntregaRepository extends JpaRepository<ZonaEntrega, Long> {
}