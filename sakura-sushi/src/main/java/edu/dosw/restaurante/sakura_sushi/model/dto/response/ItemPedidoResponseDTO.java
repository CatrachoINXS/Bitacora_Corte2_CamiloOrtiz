package edu.dosw.restaurante.sakura_sushi.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPedidoResponseDTO {

    private Long id;
    private Long idPlato;
    private String nombrePlato;
    private Double precioCongelado;
    private Integer cantidad;
}
