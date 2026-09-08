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

}
