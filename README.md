Sistema de Reservas de Vuelos

### Descripción

Sistema desarrollado en Java para gestionar vuelos, pasajeros y
reservas de asientos. El sistema permite registrar pasajeros,
registrar vuelos económicos y ejecutivos, realizar reservas y
cancelarlas, controlando la disponibilidad de los asientos.

### Objetivo

Desarrollar un sistema aplicando los principios de la Programación
Orientada a Objetos (POO), haciendo uso de encapsulamiento,
abstracción, herencia y polimorfismo.

### Funcionalidades

- Registrar pasajeros.
- Registrar vuelos.
- Registrar reservas.
- Asignar asientos a los pasajeros.
- Evitar la asignación de un mismo asiento.
- Confirmar reservas.
- Cancelar reservas.
- Consultar información de las reservas.
- Diferenciar vuelos económicos y ejecutivos.

### Tipos de vuelos

Vuelo Económico
- Capacidad de 150 pasajeros.
- No incluye servicio de comida.

Vuelo Ejecutivo
- Capacidad de 50 pasajeros.
- Incluye servicio de comida.

### Estructura del sistema

El proyecto está compuesto principalmente por:

- `Vuelo`
- `VueloEconomico`
- `VueloEjecutivo`
- `Pasajero`
- `Reserva`
- `EstadoReserva`
- `ReservaConfirmada`
- `ReservaCancelada`
- `GestorReservas`

### Principios de POO

Encapsulamiento
Los atributos de las clases se mantienen protegidos y se accede
a ellos mediante métodos.

Abstracción
Las clases `Vuelo` y `EstadoReserva` se definen como clases
abstractas.

Herencia
`VueloEconomico` y `VueloEjecutivo` heredan de `Vuelo`.
`ReservaConfirmada` y `ReservaCancelada` heredan de
`EstadoReserva`.

Polimorfismo
Los métodos abstractos pueden presentar diferentes
comportamientos dependiendo de la clase que los implemente.

### Tecnologías

- Java
- Programación Orientada a Objetos
- UML
- VS Code

### Ejecución

1. Clonar el repositorio.
2. Abrir el proyecto en el IDE.
3. Compilar el proyecto.
4. Ejecutar la clase principal.

##  Integrantes

- David Santiago Pacheco Ortega
- María de los Ángeles Gómez
- Ximena Talaga Montenegro
- Nelson Javier Escobar
