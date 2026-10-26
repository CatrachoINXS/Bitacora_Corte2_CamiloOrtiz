package edu.dosw.restaurante.sakura_sushi.model.dto.response;

import edu.dosw.restaurante.sakura_sushi.model.domain.ItemPedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoResponseDTO {
    private Long id;
    private Long idMesa;
    private List<ItemPedidoResponseDTO> items;
    private EstadoPedido estado;
    private LocalDateTime timestamp;
}
