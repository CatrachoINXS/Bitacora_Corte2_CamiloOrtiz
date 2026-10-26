package edu.dosw.restaurante.sakura_sushi.service.impl;

import edu.dosw.restaurante.sakura_sushi.mapper.PedidoEntityMapper;
import edu.dosw.restaurante.sakura_sushi.mapper.PedidoMapper;
import edu.dosw.restaurante.sakura_sushi.model.domain.ItemPedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;
import edu.dosw.restaurante.sakura_sushi.model.dto.request.PedidoRequestDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.PedidoResponseDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.PlatoResponseDTO;
import edu.dosw.restaurante.sakura_sushi.persistence.entity.PedidoEntity;
import edu.dosw.restaurante.sakura_sushi.repository.PedidoRepository;
import edu.dosw.restaurante.sakura_sushi.service.IPedidoService;
import edu.dosw.restaurante.sakura_sushi.service.IPlatoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoServiceImpl implements IPedidoService {

    private final IPlatoService platoService;
    private final PedidoEntityMapper entityMapper;
    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido confirmar(Pedido pedido) {
        log.info("Confirmando pedido para mesa {}", pedido.getIdMesa());

        List<ItemPedido> items = pedido.getItems().stream()
            .map(i -> {
                Plato plato = platoService.obtenerPorId(i.getIdPlato());

                i.setIdPlato(plato.getId());
                i.setNombrePlato(plato.getNombre());
                i.setPrecioCongelado(plato.getPrecio());

                return i;
            })
            .toList();

        pedido.setItems(items);
        PedidoEntity entidad = entityMapper.toEntity(pedido);
        PedidoEntity guardado = pedidoRepository.save(entidad);
        return entityMapper.toDomain(guardado);
    }
}
