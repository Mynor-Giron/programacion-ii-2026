# PF-14 - Pedidos de Entrega a Domicilio

**Nombre:** Mynor Adolfo Girón Muralles
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

## Reglas de Negocio Implementadas
1. Los montos (total_pedido, costo_envio) deben ser mayores o iguales a cero.
2. El sistema calcula el `totalFinal` automáticamente sumando el valor del pedido más el costo de la zona.
3. Los estados manejados son: RECIBIDO, EN_RUTA, ENTREGADO, CANCELADO.

## Endpoints de la API
- `GET /api/pedidos` (Consulta general)
- `POST /api/pedidos` (Registrar pedido y calcular total final)
- `GET /api/pedidos/zona/{id}` (Filtro por zona)
- `GET /api/pedidos/estado/{estado}` (Filtro por estado)
- `GET /api/pedidos/pendientes` (Entregas pendientes)
- `GET /api/pedidos/facturado/{fecha}` (Indicador: total facturado en una fecha)

## Configuración y Ejecución
1. Crear la base de datos `pedidos_db` en PostgreSQL.
2. Configurar credenciales en `src/main/resources/application.properties`.
3. Ejecutar `PedidosDomicilioApplication.java`.