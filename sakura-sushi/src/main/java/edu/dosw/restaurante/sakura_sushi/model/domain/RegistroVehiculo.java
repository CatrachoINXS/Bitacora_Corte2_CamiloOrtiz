package edu.dosw.restaurante.sakura_sushi.model.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter 
@RequiredArgsConstructor 
public class RegistroVehiculo {
    
    private final Long id;
    private final String placa;
    private final LocalDateTime entrada;
    private final LocalDateTime salida;
    private final Double cobro;

    public Double calcularCobro() {
        return 0.0;
    }

    public void registrarSalida() {

    }

    public Boolean estaActivo() {
        return false;
    }
}
