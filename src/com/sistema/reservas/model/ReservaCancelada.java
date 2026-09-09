package com.sistema.reservas.model;

public class ReservaCancelada extends EstadoReserva {
    @Override
    public String obtenerNombreEstado() { return "CANCELADA"; }

    @Override
    public boolean esActiva() { return false; }
}