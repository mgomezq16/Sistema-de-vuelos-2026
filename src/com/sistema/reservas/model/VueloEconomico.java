package com.sistema.reservas.model;

import java.time.LocalDateTime;

public class VueloEconomico extends Vuelo {
    public VueloEconomico(String codigo, String origen, String destino, LocalDateTime horaSalida) {
        super(codigo, origen, destino, horaSalida, 150); // Capacidad fija de 150
    }

    @Override
    public String obtenerTipoVuelo() {
        return "Económico";
    }
}
