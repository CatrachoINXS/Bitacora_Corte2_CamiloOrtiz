package edu.dosw.restaurante.sakura_sushi.mapper;

import edu.dosw.restaurante.sakura_sushi.model.domain.ItemPedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;
import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoPedido;
import edu.dosw.restaurante.sakura_sushi.model.dto.request.ItemPedidoRequestDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.request.PedidoRequestDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.ItemPedidoResponseDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.PedidoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", constant = "RECIBIDO")
    @Mapping(target = "timestamp", ignore = true)
    Pedido toDomain(PedidoRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nombrePlato", ignore = true)
    @Mapping(target = "precioCongelado", ignore = true)
    ItemPedido toDomain(ItemPedidoRequestDTO dto);

    PedidoResponseDTO toResponseDTO(Pedido pedido);

    ItemPedidoResponseDTO toResponseDTO(ItemPedido item);
}
