# Proyecto: Library

## Descripción

Este proyecto tiene como objetivo desarrollar una aplicación Java que actúe como un catálogo de libros, permitiendo a los usuarios interactuar textualmente a través de la consola. Utilizaremos el framework Spring para la estructura de la aplicación y PostgreSQL como base de datos. Los libros serán buscados mediante una API específica, y el catálogo ofrecerá varias opciones de interacción para los usuarios.

## Características

- **Búsqueda de Libros:** Los usuarios pueden buscar libros utilizando una API externa.
- **Opciones de Interacción:** Varias opciones de interacción disponibles para los usuarios.
- **Inserción en Base de Datos:** Los datos de los libros serán almacenados en una base de datos PostgreSQL.
- **Consulta de Base de Datos:** Los usuarios pueden consultar la base de datos para obtener información sobre los libros y autores.
- **Exhibición de Resultados:** Los resultados serán mostrados de manera clara y detallada a través de la consola.

## Requisitos

- Java 11 o superior
- Spring Boot 2.5.0 o superior
- PostgreSQL 12 o superior


## Instalación

### Configurar el Ambiente Java

- Asegúrate de tener Java 11 o superior instalado.
- Configura las variables de entorno JAVA_HOME y PATH correctamente.

### Crear el Proyecto

Usa Spring Initializr para crear un nuevo proyecto Spring Boot con las siguientes dependencias:
- Spring Data JPA
- PostgreSQL Driver

### Configurar la Base de Datos

- Instala PostgreSQL y crea una base de datos llamada `library5`.
- Configura las credenciales de la base de datos en `src/main/resources/application.properties`:

```properties
spring.application.name=library
spring.datasource.url=jdbc:postgresql://${DB_HOST}/library5
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.HSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true
``` 


### Consumo de la API

Implementa un servicio para consumir la API externa de libros, "GUTENDEX". Usa `HttpRequest` para hacer las solicitudes HTTP y `HttpResponse` obtener la respuesta en formato JSON.

### Análisis de la Respuesta JSON

Crea una clase modelo que represente la estructura de los datos del libro y mapea la respuesta JSON a esta clase.

### Inserción y Consulta en la Base de Datos

Usa Spring Data JPA para crear un repositorio que permita insertar y consultar datos en la base de datos.

### Exhibición de Resultados

Implementa métodos en el controlador para interactuar con los usuarios a través de la consola y mostrar los resultados de manera clara.

## Ejecución

Una vez la aplicación esté rodando, podrás interactuar con ella a través de la consola, utilizando las opciones disponibles para buscar libros y realizar consultas en la base de datos.

## Opciones de Interacción

1. Buscar Libro por Título
2. Listar Libros Registrados
3. Listar Autores Registrados
4. Buscar Autores Vivos Según Año
5. Listar Libros Según Idioma
6. Salir de la Aplicación
