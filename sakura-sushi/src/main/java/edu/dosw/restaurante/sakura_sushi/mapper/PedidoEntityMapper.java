package edu.dosw.restaurante.sakura_sushi.mapper;

import edu.dosw.restaurante.sakura_sushi.model.domain.ItemPedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;
import edu.dosw.restaurante.sakura_sushi.persistence.entity.ItemPedidoEntity;
import edu.dosw.restaurante.sakura_sushi.persistence.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {
    @Mapping(target = "timestamp", ignore = true)
    PedidoEntity toEntity(Pedido pedido);

    Pedido toDomain(PedidoEntity entity);

    ItemPedidoEntity toEntity(ItemPedido itemPedido);

    ItemPedido toDomain(ItemPedidoEntity itemPedidoEntity);
}
