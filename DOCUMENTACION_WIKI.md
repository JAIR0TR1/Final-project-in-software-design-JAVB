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

| ID | Requerimiento | Descripción |
|:---|:---|:---|
| **RF01** | **Gestión de Libros (CRUD)** | El sistema debe permitir crear, leer, actualizar y eliminar libros del catálogo. |
| **RF02** | **Gestión de Usuarios (CRUD)** | El sistema debe permitir el registro y administración de los usuarios de la biblioteca. |
| **RF03** | **Control de Disponibilidad** | El sistema debe actualizar automáticamente el estado de un libro (Disponible/Prestado) al realizar una operación. |
| **RF04** | **Registro de Préstamos** | El sistema debe permitir asignar un libro disponible a un usuario registrado. |
| **RF05** | **Gestión de Devoluciones** | El sistema debe permitir marcar un préstamo como devuelto y liberar el libro para futuros usos. |
| **RF06** | **Inicialización de Datos** | El sistema debe contar con un módulo de carga inicial de datos para pruebas. |

---

## 3. Requerimientos No Funcionales (RNF)

| ID | Requerimiento | Descripción |
|:---|:---|:---|
| **RNF01** | **Persistencia en la Nube** | El sistema debe utilizar MongoDB Atlas como base de datos externa. |
| **RNF02** | **Arquitectura Desacoplada** | El backend debe estar separado del frontend mediante una API REST. |
| **RNF03** | **Interfaz de Usuario (SPA)** | La interfaz debe ser una Single Page Application (SPA). |
| **RNF04** | **Escalabilidad** | Uso de Spring Boot para facilitar el crecimiento del sistema. |
| **RNF05** | **Diseño Responsivo** | El frontend debe ser compatible con diversos dispositivos (CSS Moderno). |

---

## 4. Historias de Usuario (HU)

### HU01: Registro de nuevos libros
**Como** bibliotecario, **quiero** ingresar los datos de un nuevo libro, **para** que esté disponible en el catálogo.

### HU02: Registro de préstamos
**Como** bibliotecario, **quiero** asignar un libro a un usuario, **para** llevar un control de posesión.

### HU03: Devolución de libros
**Como** bibliotecario, **quiero** marcar un préstamo como "Devuelto", **para** liberar el ejemplar.

### HU04: Visualización del catálogo
**Como** usuario, **quiero** ver la lista de libros y su estado, **para** saber qué puedo solicitar.

---

## 5. Tecnologías Utilizadas
- **Java 17** & **Spring Boot 3.2.5**
- **MongoDB Atlas** (Base de Datos en la Nube)
- **HTML5, CSS3 y JavaScript Vanilla**
- **Maven** (Gestión de dependencias)

---

## 6. Instrucciones de Ejecución

Para poner en marcha el proyecto localmente, siga estos pasos:

1. **Prerrequisitos:** Tener instalado Java 17 y Maven.
2. **Configuración:** El archivo `src/main/resources/application.properties` ya está configurado para conectar con el Cluster de MongoDB Atlas.
3. **Ejecución del Backend:**
   ```bash
   mvn spring-boot:run
   ```
4. **Acceso a la Aplicación:**
   Una vez que el servidor indique que ha iniciado, abra en su navegador:
   `http://localhost:8080/index.html`
