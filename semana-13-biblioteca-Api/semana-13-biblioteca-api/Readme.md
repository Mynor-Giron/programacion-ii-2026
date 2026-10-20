# 📚 Sistema de Gestión - Biblioteca Personal (API REST)

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-DB-blue?style=flat-square&logo=postgresql)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5-purple?style=flat-square&logo=bootstrap)

Plataforma web full-stack desarrollada para administrar el catálogo general de una biblioteca personal. Cuenta con una arquitectura en capas basada en **Spring Boot** para los servicios RESTful y una interfaz dinámica con **JavaScript ES6+** y **Bootstrap 5**.

---

## 👤 Datos de Identificación

* **Desarrollador/a:** Mynor Girón
* **Carné / Registro:** 9941-25-8300

---

## 🛠️ Stack Tecnológico

| Componente | Tecnología Seleccionada |
| :--- | :--- |
| **Lenguaje de Programación** | Java 17 / 21 (JDK) |
| **Backend Framework** | Spring Boot 3.x (Spring Web, Spring Data JPA) |
| **Motor de Base de Datos** | PostgreSQL & pgAdmin 4 |
| **Frontend UI** | HTML5, CSS3, Bootstrap 5, JavaScript (Fetch API) |
| **Gestión de Proyecto** | Apache Maven |
| **Herramientas de Pruebas** | Postman / cURL |
| **Entorno de Desarrollo** | IntelliJ IDEA |

---

## 🏗️ Estructura del Proyecto

La aplicación aplica el patrón de diseño MVC simplificado, organizando las clases dentro del directorio `src/main/java/com/tuproyecto/`:

```text
src/main/java/com/tuproyecto/
├── controller/
│   └── LibroController.java          # Exposición de endpoints REST (@RestController)
├── model/
│   └── Libro.java                    # Mapeo de la entidad JPA (@Entity)
├── repository/
│   └── LibroRepository.java          # Capa de persistencia (JpaRepository)
└── BibliotecaPersonalApplication.java # Clase principal de arranque