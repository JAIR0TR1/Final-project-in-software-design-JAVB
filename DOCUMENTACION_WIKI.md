# Wiki del Proyecto: Sistema de Gestión de Biblioteca

Este documento detalla la documentación técnica, los requerimientos y las historias de usuario para el **Sistema de Gestión de Biblioteca**, desarrollado como proyecto final de la asignatura de Diseño de Software.

---

## 1. Descripción del Proyecto

El **Sistema de Gestión de Biblioteca** es una solución de software integral diseñada para optimizar y automatizar los procesos de administración de una biblioteca moderna. El objetivo principal es reemplazar los registros manuales por una plataforma digital eficiente que facilite el control de inventario de libros, el registro de usuarios y la trazabilidad de los préstamos.

### Problemática a Resolver
Muchas bibliotecas pequeñas o académicas enfrentan dificultades para mantener un control preciso sobre la disponibilidad de sus ejemplares y la puntualidad en las devoluciones. Este sistema resuelve este problema mediante la actualización en tiempo real del estado de los libros y una base de datos centralizada.

### Solución Arquitectónica
Se ha implementado una arquitectura de **n-capas** utilizando:
- **Backend:** Una API REST robusta construida con **Spring Boot** que gestiona la lógica de negocio.
- **Frontend:** Una interfaz de usuario tipo **SPA (Single Page Application)** ágil y moderna.
- **Persistencia:** Una base de datos **NoSQL (MongoDB Atlas)** que permite una alta escalabilidad y acceso desde cualquier lugar.

---

## 2. Requerimientos Funcionales (RF)

Los requerimientos funcionales describen las acciones que el sistema debe ser capaz de realizar.

| ID | Requerimiento | Descripción |
|:---|:---|:---|
| **RF01** | **Gestión de Libros (CRUD)** | El sistema debe permitir crear, leer, actualizar y eliminar libros del catálogo. |
| **RF02** | **Gestión de Usuarios (CRUD)** | El sistema debe permitir el registro y administración de los usuarios de la biblioteca. |
| **RF03** | **Control de Disponibilidad** | El sistema debe actualizar automáticamente el estado de un libro (Disponible/Prestado) al realizar una operación. |
| **RF04** | **Registro de Préstamos** | El sistema debe permitir asignar un libro disponible a un usuario registrado. |
| **RF05** | **Gestión de Devoluciones** | El sistema debe permitir marcar un préstamo como devuelto y liberar el libro para futuros usos. |
| **RF06** | **Inicialización de Datos** | El sistema debe contar con un módulo de carga inicial de datos para pruebas. |

---

## 2. Requerimientos No Funcionales (RNF)

Los requerimientos no funcionales describen las características de calidad del sistema.

| ID | Requerimiento | Descripción |
|:---|:---|:---|
| **RNF01** | **Persistencia en la Nube** | El sistema debe utilizar MongoDB Atlas como base de datos externa para garantizar la persistencia. |
| **RNF02** | **Arquitectura Desacoplada** | El backend debe estar separado del frontend mediante una API REST. |
| **RNF03** | **Interfaz de Usuario (SPA)** | La interfaz debe ser una Single Page Application (SPA) para mejorar la fluidez. |
| **RNF04** | **Escalabilidad** | El uso de Spring Boot permite que el sistema pueda crecer en funcionalidades fácilmente. |
| **RNF05** | **Diseño Responsivo** | El frontend debe adaptarse a diferentes tamaños de pantalla mediante CSS moderno. |

---

## 3. Historias de Usuario (HU)

A continuación se presentan las historias de usuario siguiendo el formato: *"Como [rol], quiero [acción], para [beneficio]"*.

### HU01: Registro de nuevos libros
**Como** bibliotecario,  
**quiero** ingresar los datos de un nuevo libro (título, autor, ISBN),  
**para** que esté disponible en el catálogo de la biblioteca.

### HU02: Registro de préstamos
**Como** bibliotecario,  
**quiero** asignar un libro específico a un usuario mediante su carnet,  
**para** llevar un control de quién tiene cada ejemplar.

### HU03: Devolución de libros
**Como** bibliotecario,  
**quiero** marcar un préstamo como "Devuelto",  
**para** que el libro vuelva a aparecer como disponible para otros usuarios.

### HU04: Visualización del catálogo
**Como** usuario/bibliotecario,  
**quiero** ver la lista de todos los libros y su estado actual,  
**para** saber qué libros puedo solicitar en préstamo.

### HU05: Administración de usuarios
**Como** administrador,  
**quiero** registrar los datos personales de los nuevos miembros,  
**para** identificarlos al momento de realizar un préstamo.

---

## 4. Tecnologías Utilizadas
- **Lenguaje:** Java 17
- **Framework:** Spring Boot 3.2.5
- **Base de Datos:** MongoDB Atlas
- **Frontend:** HTML5, CSS3, JavaScript (Vanilla)
- **Control de Versiones:** Git / GitHub
