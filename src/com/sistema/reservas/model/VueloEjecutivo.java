package com.sistema.reservas.model;

import java.time.LocalDateTime;

public class VueloEjecutivo extends Vuelo {
    private final boolean servicioComida;
    private final String menu;

    public VueloEjecutivo(String codigo, String origen, String destino, LocalDateTime horaSalida, String menu) {
        super(codigo, origen, destino, horaSalida, 50); // Capacidad fija de 50
        this.servicioComida = true;
        this.menu = menu;
    }

    @Override
    public String obtenerTipoVuelo() {
        return "Ejecutivo";
    }

    public String getMenu() { return menu; }
    public boolean isServicioComida() { return servicioComida; }
    
}