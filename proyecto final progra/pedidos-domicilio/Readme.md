# PF-14 - Sistema de Pedidos de Entrega a Domicilio

**Estudiante:** Mynor Adolfo Girón Muralles**Carné:** 9941-25-8300
**Curso:** Programación II

## Descripción del Proyecto
Sistema backend y frontend para la gestión de pedidos a domicilio. Calcula automáticamente el costo de envío según la zona seleccionada, determina el total final, y permite el seguimiento de estados con transiciones controladas.

## Tecnologías Utilizadas
- **Backend:** Java, Spring Boot, Maven, Spring Data JPA.
- **Base de Datos:** PostgreSQL.
- **Frontend:** HTML, CSS, JavaScript (Fetch API).

## Funcionalidades y Reglas de Negocio
- **CRUD de Pedidos:** Registrar, listar, modificar y eliminar.
- **Gestión de Zonas:** CRUD completo para las zonas de entrega.
- **Transiciones de estado controladas:**
    - De `RECIBIDO` solo puede pasar a `EN_RUTA` o `CANCELADO`.
    - De `EN_RUTA` solo puede pasar a `ENTREGADO` o `CANCELADO`.
    - Un pedido `ENTREGADO` o `CANCELADO` no puede ser modificado (estado final).
- **BigDecimal:** Uso de tipos de datos precisos para montos de dinero.
- **Indicador:** Total facturado del día (excluyendo pedidos cancelados).
- **Seguridad:** Implementación de `escapeHTML` en el Frontend para evitar inyecciones y contraseña de base de datos manejada fuera del control de versiones.

## Instrucciones para Ejecutar
1. Ejecutar el script `database.sql` (incluido en la raíz) en PostgreSQL para crear las tablas y datos de prueba.
2. Configurar las credenciales en `src/main/resources/application.properties`.
3. Ejecutar `PedidosDomicilioApplication.java`.
4. Abrir el navegador en `http://localhost:8080/index.html`.