package edu.dosw.restaurante.sakura_sushi.model.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter 
@RequiredArgsConstructor 
public class Reserva {
    private final Long id;
    private final Long idMesa;
    private final String cliente;
    private final LocalDateTime fechaHora;
    private final Integer comensales;

    public Boolean estaVigente() {
        return false;
    }

    public void cancelar() {

    }

    public void reprogramar() {

    }
}
