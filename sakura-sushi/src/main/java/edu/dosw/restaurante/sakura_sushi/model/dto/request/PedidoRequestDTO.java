package edu.dosw.restaurante.sakura_sushi.model.dto.request;

import edu.dosw.restaurante.sakura_sushi.model.domain.ItemPedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoPedido;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {

    @NotNull(message = "El id de la mesa es obligatorio")
    @Min(value = 1, message = "El número de mesa debe ser mayor a 0")
    private Long idMesa;

    @NotEmpty(message = "El pedido debe tener al menos un item")
    private List<ItemPedidoRequestDTO> items;

    @NotBlank(message = "Las notas del pedido no pueden ser solo espacios")
    @Size(max = 200)
    private String notas;
}
