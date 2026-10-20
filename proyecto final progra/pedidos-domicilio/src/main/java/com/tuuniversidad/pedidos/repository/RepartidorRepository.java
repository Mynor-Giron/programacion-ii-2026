package com.tuuniversidad.pedidos.repository;

import com.tuuniversidad.pedidos.entity.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartidorRepository extends JpaRepository<Repartidor, Long> {
}