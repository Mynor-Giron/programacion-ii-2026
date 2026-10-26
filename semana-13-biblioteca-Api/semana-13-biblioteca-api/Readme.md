# semana-13-biblioteca-api

Nombre: Mynor Girón
Carnet: 9941-25-8300

## Nombre de la actividad
Evolución del proyecto final: Implementación de DTO, Validaciones y Manejo de Excepciones.

## Descripción del problema
Se requiere actualizar la API REST de la biblioteca personal para mejorar la organización y confiabilidad del backend. Para ello, se implementó una arquitectura por capas añadiendo la capa Service, se creó un DTO (Data Transfer Object) para recibir datos del cliente de forma segura, se agregaron validaciones a los campos y se implementó un manejo global de excepciones para devolver respuestas HTTP claras y profesionales.

## Tecnologías utilizadas
* Java 17
* Spring Boot 3.x
* Spring Web
* Spring Data JPA
* Spring Boot Starter Validation
* PostgreSQL
* Maven

## Estructura del proyecto
```text
src/main/java/com/biblioteca/semana13bibliotecaapi/
├── controller/
│   └── LibroController.java
├── dto/
│   └── LibroRequestDTO.java
├── entity/
│   └── Libro.java
├── exception/
│   ├── GlobalExceptionHandler.java
│   └── RecursoNoEncontradoException.java
├── repository/
│   └── LibroRepository.java
├── service/
│   └── LibroService.java
└── Semana13BibliotecaApiApplication.java