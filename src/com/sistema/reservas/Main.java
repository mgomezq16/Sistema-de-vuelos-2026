package com.sistema.reservas;

import com.sistema.reservas.exception.*;
import com.sistema.reservas.model.*;
import com.sistema.reservas.service.GestorReservas;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE RESERVAS DE VUELOS (V1.0) ===\n");

        GestorReservas gestor = new GestorReservas();

        // 1. Crear y registrar Vuelos
        Vuelo vueloEco = new VueloEconomico("AV123", "Bogotá", "Medellín", LocalDateTime.now().plusDays(2));
        Vuelo vueloEje = new VueloEjecutivo("AV999", "Bogotá", "Miami", LocalDateTime.now().plusDays(5), "Cena Gourmet con Vino");

        gestor.registrarVuelo(vueloEco);
        gestor.registrarVuelo(vueloEje);

        // 2. Crear y registrar Pasajeros
        Pasajero pasajero1 = new Pasajero("1001", "David Santiago", "david@email.com");
        Pasajero pasajero2 = new Pasajero("1002", "Luisa Fernanda", "luisa@email.com");

        gestor.registrarPasajero(pasajero1);
        gestor.registrarPasajero(pasajero2);

        System.out.println("--- PRUEBA 1: Creación de Reservas Exitosas ---");
        try {
            // Reservar asiento 10 en Vuelo Económico (Capacidad 150)
            Reserva r1 = gestor.crearReserva("1001", "AV123", 10);
            System.out.println("Reserva 1 Creada con Éxito: " + r1.getCodigoReserva() + 
                               " | Pasajero: " + r1.getPasajero().getNombre() + 
                               " | Asiento: " + r1.getNumeroAsiento() + 
                               " | Tipo: " + r1.getVuelo().obtenerTipoVuelo());

            // Reservar asiento 1 en Vuelo Ejecutivo (Capacidad 50)
            Reserva r2 = gestor.crearReserva("1002", "AV999", 1);
            System.out.println("Reserva 2 Creada con Éxito: " + r2.getCodigoReserva() + 
                               " | Pasajero: " + r2.getPasajero().getNombre() +
                               " | Asiento: " + r2.getNumeroAsiento() + 
                               " | Tipo: " + r2.getVuelo().obtenerTipoVuelo() + 
                               " | Menú: " + ((VueloEjecutivo) r2.getVuelo()).getMenu());

        } catch (Exception e) {
            System.err.println("Error inesperado en Prueba 1: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA 2: Intento de Asignar Asiento Duplicado ---");
        try {
            // Intentar asignar nuevamente el asiento 10 en AV123 a otro pasajero
            gestor.crearReserva("1002", "AV123", 10);
        } catch (AsientoNoDisponibleException e) {
            System.out.println("Excepción capturada correctamente -> " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error no esperado: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA 3: Búsqueda de Vuelo Inexistente ---");
        try {
            gestor.crearReserva("1001", "VUELO_FANTASMA", 5);
        } catch (VueloNoEncontradoException e) {
            System.out.println("Excepción capturada correctamente -> " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error no esperado: " + e.getMessage());
        }

        System.out.println("\n=== PRUEBAS FINALIZADAS CON ÉXITO EN V1.0 ===");
    }
}
