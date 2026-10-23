package com.tuuniversidad.pedidos.service;

import com.tuuniversidad.pedidos.dto.PedidoRequestDTO;
import com.tuuniversidad.pedidos.dto.PedidoResponseDTO;
import com.tuuniversidad.pedidos.entity.Pedido;
import com.tuuniversidad.pedidos.entity.ZonaEntrega;
import com.tuuniversidad.pedidos.exception.ResourceNotFoundException;
import com.tuuniversidad.pedidos.repository.PedidoRepository;
import com.tuuniversidad.pedidos.repository.zonaEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired private PedidoRepository pedidoRepo;
    @Autowired private zonaEntregaRepository zonaRepo;

    private PedidoResponseDTO mapToDTO(Pedido p) {
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setId(p.getId());
        dto.setCliente(p.getCliente());
        dto.setDireccion(p.getDireccion());
        dto.setFechaPedido(p.getFechaPedido());
        dto.setTotalPedido(p.getTotalPedido());
        dto.setCostoEnvio(p.getCostoEnvio());
        dto.setTotalFinal(p.getTotalFinal());
        dto.setEstado(p.getEstado());
        dto.setNombreZona(p.getZonaEntrega() != null ? p.getZonaEntrega().getNombre() : "Sin zona");
        return dto;
    }

    public List<PedidoResponseDTO> listarTodos() {
        return pedidoRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PedidoResponseDTO registrar(PedidoRequestDTO dto) {
        ZonaEntrega zona = zonaRepo.findById(dto.getZonaEntregaId())
                .orElseThrow(() -> new ResourceNotFoundException("Zona no encontrada"));

        Pedido pedido = new Pedido();
        pedido.setCliente(dto.getCliente());
        pedido.setDireccion(dto.getDireccion());
        pedido.setTotalPedido(dto.getTotalPedido());
        pedido.setZonaEntrega(zona);

        // REGLA DE NEGOCIO: Calcular costo de envío y total final
        pedido.setCostoEnvio(zona.getCosto());
        pedido.setTotalFinal(dto.getTotalPedido() + zona.getCosto());
        pedido.setEstado("RECIBIDO");

        return mapToDTO(pedidoRepo.save(pedido));
    }

    public List<PedidoResponseDTO> buscarPorEstado(String estado) {
        return pedidoRepo.findByEstado(estado).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<PedidoResponseDTO> buscarPorZona(Long zonaId) {
        return pedidoRepo.findByZonaEntregaId(zonaId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<PedidoResponseDTO> entregasPendientes() {
        return pedidoRepo.findEntregasPendientes().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Double totalFacturado(LocalDate fecha) {
        Double total = pedidoRepo.sumarTotalPorFecha(fecha);
        return total != null ? total : 0.0;
    }
}