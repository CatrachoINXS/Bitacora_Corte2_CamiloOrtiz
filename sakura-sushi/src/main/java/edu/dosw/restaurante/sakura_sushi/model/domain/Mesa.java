package edu.dosw.restaurante.sakura_sushi.model.domain;

import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoMesa;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter 
@RequiredArgsConstructor 
public class Mesa {
    private final Long id;
    private final Integer numero;
    private final Integer capacidad;
    private final EstadoMesa estado;
    private final Boolean mesaAbierta;

    public Boolean estaDisponible() {
        return false;
    }

    public void abrirCuenta() {

    }

    public void cerrarCuenta() {

    }
}
