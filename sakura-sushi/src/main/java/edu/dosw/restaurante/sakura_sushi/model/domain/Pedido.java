package edu.dosw.restaurante.sakura_sushi.model.domain;

import java.time.LocalDateTime;
import java.util.List;

import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoPedido;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {
    
    private Long id;
    private Long idMesa;
    private List<ItemPedido> items;
    private EstadoPedido estado;
    private LocalDateTime timestamp;

    public Boolean puedeModificarse() {
        return false;
    }

    public void agregarItem(ItemPedido item) {
        this.items.add(item);
    }

    public void cambiarEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}
