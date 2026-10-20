package com.tuuniversidad.pedidos.service;

import com.tuuniversidad.pedidos.dto.PedidoRequestDTO;
import com.tuuniversidad.pedidos.dto.PedidoResponseDTO;
import com.tuuniversidad.pedidos.entity.Pedido;
import com.tuuniversidad.pedidos.entity.Repartidor;
import com.tuuniversidad.pedidos.exception.ResourceNotFoundException;
import com.tuuniversidad.pedidos.repository.PedidoRepository;
import com.tuuniversidad.pedidos.repository.RepartidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired private PedidoRepository pedidoRepo;
    @Autowired private RepartidorRepository repartidorRepo;

    private PedidoResponseDTO mapToDTO(Pedido p) {
        String nombreRepartidor = (p.getRepartidor() != null) ? p.getRepartidor().getNombre() : "Sin asignar";
        return new PedidoResponseDTO(
                p.getId(), p.getCliente(), p.getDireccion(), p.getFechaPedido(),
                p.getTotal(), p.getEstado(), nombreRepartidor
        );
    }

    public List<PedidoResponseDTO> listarTodos() {
        return pedidoRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PedidoResponseDTO registrar(PedidoRequestDTO dto) {
        if (dto.getTotal() == null || dto.getTotal() <= 0) {
            throw new RuntimeException("El total debe ser mayor a 0");
        }

        Repartidor repartidor = repartidorRepo.findById(dto.getRepartidorId())
                .orElseThrow(() -> new ResourceNotFoundException("Repartidor no encontrado"));

        if (!repartidor.getDisponible()) {
            throw new RuntimeException("El repartidor no está disponible actualmente");
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(dto.getCliente());
        pedido.setDireccion(dto.getDireccion());
        pedido.setTotal(dto.getTotal());
        pedido.setRepartidor(repartidor);

        repartidor.setDisponible(false);
        repartidorRepo.save(repartidor);

        return mapToDTO(pedidoRepo.save(pedido));
    }
}