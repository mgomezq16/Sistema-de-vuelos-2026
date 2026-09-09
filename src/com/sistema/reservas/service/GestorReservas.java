package com.sistema.reservas.service;

import com.sistema.reservas.exception.*;
import com.sistema.reservas.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GestorReservas {
    private List<Vuelo> vuelos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Pasajero> pasajeros = new ArrayList<>();

    public void registrarPasajero(Pasajero pasajero) { pasajeros.add(pasajero); }
    public void registrarVuelo(Vuelo vuelo) { vuelos.add(vuelo); }

    public Pasajero buscarPasajero(String cedula) {
        return pasajeros.stream()
                .filter(p -> p.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    public Vuelo buscarVuelo(String codigo) {
        return vuelos.stream()
                .filter(v -> v.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    // AQUÍ ESTÁ EL CAMBIO CLAVE: Se declara throws AsientoNoDisponibleException, VueloNoEncontradoException
    public Reserva crearReserva(String cedulaPasajero, String codigoVuelo, int numeroAsiento) 
            throws AsientoNoDisponibleException, VueloNoEncontradoException {
        
        Pasajero pasajero = buscarPasajero(cedulaPasajero);
        Vuelo vuelo = buscarVuelo(codigoVuelo);

        if (vuelo == null) {
            throw new VueloNoEncontradoException("El vuelo con código " + codigoVuelo + " no existe.");
        }

        if (pasajero == null) {
            throw new IllegalArgumentException("El pasajero con cédula " + cedulaPasajero + " no está registrado.");
        }

        if (!vuelo.esAsientoDisponible(numeroAsiento)) {
            throw new AsientoNoDisponibleException("El asiento " + numeroAsiento + " ya está ocupado o no existe.");
        }

        vuelo.asignarAsiento(numeroAsiento);
        String codigoReserva = "RES-" + UUID.randomUUID().toString().substring(0, 8);
        Reserva reserva = new Reserva(codigoReserva, pasajero, vuelo, numeroAsiento, new ReservaConfirmada());
        
        reservas.add(reserva);
        return reserva;
    }
}