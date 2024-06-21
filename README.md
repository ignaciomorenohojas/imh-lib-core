# imh-lib-core

Librería con clases y métodos generales de los desarrollos de imh.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Tecnologías](#tecnologías)
- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Ejecución](#ejecución)
- [Pruebas](#pruebas)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

## Descripción

Esta librería contiene las clases, métodos y utilidades comunes a los desarrollos de imh.
Se utilizará en todos los desarrollos de imh para tener un código más limpio y reutilizable.

## Características

- Clase StringDic con constantes de caracteres más comúnmente utilizados.
- Excepciones comunes 
  - ServiceException: Excepción general de servicio.
- Clases de utilidades:
  - Clase de utilidades de cadenas
  - Clase de utilidades de manejo de mensajes de texto

## Tecnologías

Lista de tecnologías y herramientas utilizadas en el proyecto:

- imh-lib-base
  - Java 21
  - Maven 3.8
  - Lombok
  - MapStruct
- Apache Commons Lang
- JUnit para pruebas

## Requisitos Previos

Lista de software y herramientas que deben estar instaladas en tu sistema:

- JDK 21 o superior
- Maven 3.8

## Instalación

Pasos para clonar el repositorio e instalar las dependencias:

```sh
git clone https://github.com/ignaciomorenohojas/imh-lib-core.git
cd tuaplicacion
mvn clean install
```

## Configuración

No es necesaria ninguna configuración, basta con una compilación para posteriomnte utilizarla en otros proyectos.

## Ejecución

La aplicación no es ejecutable.

## Pruebas
Instrucciones para ejecutar las pruebas unitarias:

    ```sh
    mvn test
    ```
## Contribuir
Instrucciones para contribuir al proyecto:

1. Haz un fork del repositorio.
2. Crea una nueva rama (git checkout -b feature/nueva-feature).
3. Realiza los cambios necesarios y realiza commits (git commit -m 'Añadir nueva feature').
4. Sube tus cambios a GitHub (git push origin feature/nueva-feature).
5. Abre un Pull Request.

## Licencia
Información sobre la licencia del proyecto.

