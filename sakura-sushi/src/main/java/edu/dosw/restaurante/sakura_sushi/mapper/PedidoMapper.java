package edu.dosw.restaurante.sakura_sushi.mapper;

import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoPedido;
import edu.dosw.restaurante.sakura_sushi.model.dto.request.PedidoRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", constant = "RECIBIDO")
    Pedido toDomain(PedidoRequestDTO dto);


}
