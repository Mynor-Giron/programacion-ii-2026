# PF-14 - Pedidos de Entrega a Domicilio

**Nombre:** Mynor Adolfo GIrón Muralles
**Carné:** 9941-25-8300
**Curso:** Programación II

## Descripción del Problema
El sistema permite administrar los pedidos de entrega a domicilio. Calcula automáticamente el costo de envío según la zona seleccionada, determina el total final a pagar, y permite dar seguimiento al estado de cada entrega.

## Tecnologías Utilizadas
- Java 21/25
- Spring Boot
- Maven
- PostgreSQL
- Spring Data JPA
- Validaciones (Jakarta Validation)

## Entidades y Relación
- **ZonaEntrega:** id, nombre, costo.
- **Pedido:** id, cliente, direccion, fechaPedido, totalPedido, costoEnvio, totalFinal, estado, zonaEntrega.
- **Relación:** Muchos pedidos pertenecen a una Zona de Entrega (`@ManyToOne`).

## Endpoints de la API (CRUD y Consultas)
- `GET /api/pedidos` (Consulta general)
- `POST /api/pedidos` (Registrar pedido y calcular total final)
- `PUT /api/pedidos/{id}` (Modificar pedido)
- `DELETE /api/pedidos/{id}` (Eliminar pedido)
- `GET /api/pedidos/zona/{id}` (Filtro por zona)
- `GET /api/pedidos/estado/{estado}` (Filtro por estado)
- `GET /api/pedidos/pendientes` (Entregas pendientes)
- `GET /api/pedidos/facturado/{fecha}` (Indicador: total facturado en una fecha)

## Configuración y Ejecución
1. Crear la base de datos `pedidos_db` en PostgreSQL.
2. Configurar credenciales en `src/main/resources/application.properties`.
3. Ejecutar `PedidosDomicilioApplication.java`.