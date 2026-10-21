# PF-14 - Pedidos de Entrega a Domicilio

**Nombre:** Mynor Girón
**Carné:** 9941-25-8300
**Curso:** Programación II

## Descripción del Problema
El sistema permite administrar pedidos de entrega a domicilio, gestionando la asignación de pedidos a repartidores disponibles, controlando los estados de cada pedido y calculando indicadores de ventas.

## Tecnologías Utilizadas
- Java
- Spring Boot
- Maven
- PostgreSQL
- Spring Data JPA

## Estructura del Sistema
- `entity`: Clases Repartidor y Pedido.
- `repository`: Interfaces JPA.
- `service`: Lógica de negocio.
- `controller`: Endpoints REST.

## Configuración de PostgreSQL
Configurar la contraseña en `src/main/resources/application.properties`.

## Endpoints
- `GET /api/pedidos`
- `POST /api/pedidos`