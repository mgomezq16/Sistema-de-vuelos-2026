package com.sistema.reservas.model;

public class ReservaConfirmada extends EstadoReserva {
    @Override
    public String obtenerNombreEstado() { return "CONFIRMADA"; }

    @Override
    public boolean esActiva() { return true; }
}