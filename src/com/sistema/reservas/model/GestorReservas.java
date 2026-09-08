package com.sistema.reservas.model;

import com.sistema.reservas.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GestorReservas {

    private List<Vuelo> vuelos;
    private List<Reserva> reservas;
    private List<Pasajero> pasajeros;

    public GestorReservas(){
        this.vuelos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.pasajeros = new ArrayList<>();
    }
    public void registrarPasajero(Pasajero pasajero){
        pasajeros.add(pasajero);
    }

    public void registrarVuelo(Vuelo vuelo){
        vuelos.add(vuelo);
    }

    public Pasajero buscarPasajero(String cedula){
        return pasajeros.stream()
        .filter(p -> p.getCedula()equals(cedula))
        .findFirst()
        .orElse(null);
    }

    public Vuelo buscarVuelo(String codigo){
        return vuelos.stream()
        .filter(v ->v.getCodigo().equalsIgnoreCase(codigo))
        .findFirst()
        .orElse(null);
    }

    public Reserva crearReserva(String cedulaPasajero, String codigoVuelo, int numeroAsiento){
        Pasajero pasajero = buscarPasajero(cedulaPasajero);
        Vuelo vuelo = buscarVuelo(codigoVuelo);

        if (pasajero == null || vuelo == null){
            throw new IllegalArgumentException("Pasajero o vuelo no registrado.");
        }

        if(!vuelo.esAsientoDisponible(numeroAsiento)){
            throw new IllegalStateException("El asiento"+numeroAsiento+"no esta disponible.");
        }

        vuelo.asignarAsiento(numeroAsiento);
        String codigoReserva = "RES-"+ UUID.randomUUID().toString().substring(0,8);
        Reserva reserva = new Reserva (codigoReserva, pasajero, vuelo, numeroAsiento, new ReservaConfirmada());

        reservas.add(reserva);
        return reserva;
    }


}
