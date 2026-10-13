package edu.dosw.restaurante.sakura_sushi.model.dto.request;

import edu.dosw.restaurante.sakura_sushi.model.domain.ItemPedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {

    @NotNull(message = "El id de la mesa es obligatorio")
    @Size(max = 100, message = "Máximo 100 caracteres")
    private Long idMesa;

    private List<ItemPedido> items;

}
