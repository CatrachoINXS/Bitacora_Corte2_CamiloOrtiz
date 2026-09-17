package edu.dosw.restaurante.sakura_sushi.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter 
@RequiredArgsConstructor
public class ItemPedido {
    
    private final Long id;
    private final Long idPlato;
    private final String nombrePlato;
    private final Double precioCongelado;
    private final Integer cantidad;

    public Double subtotal() {
        // TODO
        return 0.0;
    }
}
