package com.sistema.reservas.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public abstract class Vuelo {
    protected String codigo;
    protected String origen;
    protected String destino;
    protected LocalDateTime horaSalida;
    protected int capacidad;
    protected Set<Integer> asientosOcupados;

    public Vuelo(String codigo, String origen, String destino, LocalDateTime horaSalida, int capacidad) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.capacidad = capacidad;
        this.asientosOcupados = new HashSet<>();
    }

    public boolean esAsientoDisponible(int numeroAsiento) {
        return numeroAsiento >= 1 && numeroAsiento <= capacidad && !asientosOcupados.contains(numeroAsiento);
    }

    public boolean asignarAsiento(int numeroAsiento) {
        if (esAsientoDisponible(numeroAsiento)) {
            asientosOcupados.add(numeroAsiento);
            return true;
        }
        return false;
    }

    public void liberarAsiento(int numeroAsiento) {
        asientosOcupados.remove(numeroAsiento);
    }

    public abstract String obtenerTipoVuelo();

    // Getters y Setters...
    public String getCodigo() { return codigo; }
    public int getCapacidad() { return capacidad; }
}