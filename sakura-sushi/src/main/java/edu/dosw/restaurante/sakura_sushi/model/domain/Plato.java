package edu.dosw.restaurante.sakura_sushi.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter 
@RequiredArgsConstructor 
public class Plato {
    
    private final Long id;
    private final String nombre;
    private final Double precio;
    private final String categoria;
    private final Boolean disponible;

    public Boolean esValido() {
        return false;
    }
}
