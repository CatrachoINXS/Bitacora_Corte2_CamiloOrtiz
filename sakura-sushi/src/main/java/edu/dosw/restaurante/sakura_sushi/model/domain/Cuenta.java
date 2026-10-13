package edu.dosw.restaurante.sakura_sushi.model.domain;

import java.time.LocalDateTime;

import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoCuenta;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter 
@RequiredArgsConstructor 
public class Cuenta {
    
    private final Long id;
    private final Long idMesa;
    private final Double total;
    private final EstadoCuenta estado;
    private final LocalDateTime fechaApertura;

    public Double calcularTotal() {
        return 0.0;
    }

    public void registrarPago() {

    }

    public void cerrarCuenta() {

    }
}
