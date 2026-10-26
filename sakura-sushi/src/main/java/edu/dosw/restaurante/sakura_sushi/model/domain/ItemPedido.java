package edu.dosw.restaurante.sakura_sushi.model.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedido {
    
    private Long id;
    private Long idPlato;
    private String nombrePlato;
    private Double precioCongelado;
    private Integer cantidad;

    public Double subtotal() {
        return precioCongelado * cantidad;
    }
}
