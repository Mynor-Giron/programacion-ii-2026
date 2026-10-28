# PF-14 - Sistema de Pedidos de Entrega a Domicilio

**Estudiante:** Mynor Adolfo Girón Muralles
**Carné:** 9941-25-8300
**Curso:** Programación II
**Proyecto:** PF-14

## 📝 Descripción del Problema
El sistema permite administrar pedidos de entrega a domicilio. Calcula automáticamente el costo de envío según la zona seleccionada, determina el total final a pagar, y permite dar seguimiento al estado de cada entrega (RECIBIDO, EN_RUTA, ENTREGADO, CANCELADO).

## 🛠️ Tecnologías Utilizadas
- **Backend:** Java, Spring Boot, Maven, Spring Data JPA, Jakarta Validation.
- **Base de Datos:** PostgreSQL.
- **Frontend:** HTML, CSS, JavaScript (Fetch API).

## 📂 Estructura del Sistema
El backend está organizado por capas:
- `entity`: Clases `ZonaEntrega` y `Pedido`.
- `repository`: Interfaces para la persistencia de datos.
- `service`: Lógica de negocio y cálculos automáticos.
- `controller`: Endpoints de la API REST.
- `dto`: Objetos de transferencia de datos.
- `exception`: Manejo centralizado de errores.

## ⚙️ Funcionalidades Implementadas
- **CRUD de Pedidos:** Registrar, listar, modificar y eliminar.
- **Gestión de Zonas:** API para obtener las zonas de entrega dinámicamente.
- **Cambio de Estado:** Endpoint (PATCH) para actualizar el seguimiento del pedido.
- **Reglas de Negocio:** El backend calcula el `totalFinal` sumando el pedido + costo de la zona.
- **Indicador:** Total facturado histórico.
- **Validaciones:** Protección de datos inválidos (montos negativos, campos vacíos).
- **Frontend dinámico:** Interfaz web que consume la API y muestra tablas y totales en tiempo real.

## 🔗 Endpoints Principales
- `GET /api/pedidos` (Listar todos los pedidos)
- `POST /api/pedidos` (Registrar un pedido)
- `PUT /api/pedidos/{id}` (Modificar un pedido)
- `DELETE /api/pedidos/{id}` (Eliminar un pedido)
- `PATCH /api/pedidos/{id}/estado?estado=NUEVO_ESTADO` (Cambiar estado)
- `GET /api/zonas` (Listar zonas para el Frontend)
- `GET /api/pedidos/facturado/{fecha}` (Indicador de facturación)

## 🚀 Instrucciones para Ejecutar
1. Clonar el repositorio.
2. Crear una base de datos en PostgreSQL llamada `pedidos_db`.
3. Ejecutar los scripts SQL incluidos en el repositorio.
4. Configurar las credenciales de PostgreSQL en `src/main/resources/application.properties`.
5. Ejecutar el archivo `PedidosDomicilioApplication.java`.
6. Abrir el navegador en `http://localhost:8080/index.html`.