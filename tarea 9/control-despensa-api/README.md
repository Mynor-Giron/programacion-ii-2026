# 🏠🥫 API REST - Despensa del Hogar

**Estudiante:** Mynor Adolfo Girón Muralles
**Carnet:** 9941-25-8300
📦 API REST - Gestión de Despensa Doméstica
Sistema para el control y análisis de inventario en memoria desarrollado con Spring Boot. Permite consultar el stock disponible, identificar ítems críticos y generar métricas consolidadas de la despensa.

🛠️ Tecnologías y Requisitos
Java: 17

Framework: Spring Boot (Spring Web)

Gestor de dependencias: Maven

IDE recomendado: IntelliJ IDEA

Servidor: Apache Tomcat (Puerto 8080)

Herramientas de prueba: Postman / Browser / cURL

📂 Estructura del Proyecto
Plaintext
src/main/java/com/estudiante/despensa/
├── ControlDespensaApiApplication.java   // Punto de entrada de la aplicación
├── controller/
│   └── ProductoController.java          // Endpoints y lógica del inventario
└── model/
├── Producto.java                    // Entidad base del ítem
└── ResumenInventario.java           // DTO para métricas de inventario
🌐 Endpoints HTTP
Acción	Método	Endpoint	HTTP Code
Obtener catálogo completo	GET	/api/productos	200
Consultar producto por ID	GET	/api/productos/{id}	200 / 404
Filtrar por categoría	GET	/api/productos/categoria/{categoria}	200
Listar ítems con bajo stock	GET	/api/productos/stock-bajo	200
Obtener el producto más costoso	GET	/api/productos/mayor-valor	200
Métricas generales del inventario	GET	/api/productos/resumen	200
🚀 Guía de Puesta en Marcha (IntelliJ IDEA)
Abre el proyecto en IntelliJ IDEA (File > Open).

Espera a que el entorno sincronice automáticamente las dependencias de Maven.

Inicia el servidor mediante una de las siguientes opciones:

Opción A (IDE): Haz clic derecho en ControlDespensaApiApplication.java y selecciona Run.

Opción B (Terminal): Ejecuta ./mvnw spring-boot:run.

Verifica en la consola que la aplicación esté corriendo sobre el puerto 8080.

📄 Respuestas de Ejemplo (JSON)
1. Listado de Inventario (GET /api/productos)
   JSON
   [
   {
   "id": 1,
   "nombre": "Leche Entera",
   "categoria": "Lácteos",
   "cantidad": 5,
   "precioUnitario": 2.5
   },
   {
   "id": 2,
   "nombre": "Queso Fresco",
   "categoria": "Lácteos",
   "cantidad": 2,
   "precioUnitario": 4.0
   }
   ]
2. Métrica Consolidada (GET /api/productos/resumen)
   JSON
   {
   "cantidadProductos": 6,
   "totalUnidades": 29,
   "valorTotal": 69.7
   }