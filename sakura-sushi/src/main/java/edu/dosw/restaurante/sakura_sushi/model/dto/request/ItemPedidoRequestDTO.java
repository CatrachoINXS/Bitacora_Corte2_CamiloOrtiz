package edu.dosw.restaurante.sakura_sushi.model.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoRequestDTO {

    private Long idPlato;

    @Positive
    private Integer cantidad;
}
