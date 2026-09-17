package edu.dosw.restaurante.sakura_sushi.model.domain;

import java.time.LocalDateTime;
import java.util.List;

import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoPedido;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter 
@RequiredArgsConstructor 
public class Pedido {
    
    private final Long id;
    private final Long idMesa;
    private final List<ItemPedido> items;
    private final EstadoPedido estado;
    private final LocalDateTime timestamp;

    public Boolean puedeModificarse() {
        return false;
    }

    public void agregarItem() {

    }

    public void cambiarEstado() {

    }

}
