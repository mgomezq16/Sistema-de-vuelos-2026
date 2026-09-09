package com.sistema.reservas.model;

public class Reserva {
    private String codigoReserva;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private int numeroAsiento;
    private EstadoReserva estado;

public Reserva (String codigoReserva, Pasajero pasajero, Vuelo vuelo, int numeroAsiento, EstadoReserva estado){
 
    this.codigoReserva = codigoReserva;
    this.pasajero = pasajero;
    this.vuelo = vuelo;
    this.numeroAsiento = numeroAsiento;
    this.estado = estado;
}
public void cambiarEstado(EstadoReserva nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void cancelar() {
        if (estado == null || estado.esActiva()) {
            estado = new ReservaCancelada();
            vuelo.liberarAsiento(numeroAsiento);
        }
    }

    public boolean confirmarReserva() {

        if (estado != null && estado.esActiva()) {
            return true;
        }
        if (vuelo != null && vuelo.esAsientoDisponible(numeroAsiento)) {

            if (vuelo.asignarAsiento(numeroAsiento)) {
                estado = new ReservaConfirmada();
                return true;
            }
        }
return false;
}
    public String getCodigoReserva() {
        return codigoReserva;
    }
    public Pasajero getPasajero() {
        return pasajero;
    }
    public Vuelo getVuelo() {
        return vuelo;
    }
    public int getNumeroAsiento() {
        return numeroAsiento;
    }
    public EstadoReserva getEstado() {
        return estado;
    }
}