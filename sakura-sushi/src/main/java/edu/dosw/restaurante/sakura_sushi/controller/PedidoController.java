package edu.dosw.restaurante.sakura_sushi.controller;

import edu.dosw.restaurante.sakura_sushi.mapper.PedidoMapper;
import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;
import edu.dosw.restaurante.sakura_sushi.model.dto.request.PedidoRequestDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.PedidoResponseDTO;
import edu.dosw.restaurante.sakura_sushi.service.IPedidoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/pedidos")
@RequiredArgsConstructor
@Slf4j
@RestController
public class PedidoController {

    private final IPedidoService pedidoService;
    private final PedidoMapper pedidoMapper;

    @PostMapping
    @Operation(summary = "Crear un pedido")
    public ResponseEntity<PedidoResponseDTO> crear(@RequestBody @Valid PedidoRequestDTO dto) {
        Pedido pedido = pedidoMapper.toDomain(dto);
        Pedido creado = pedidoService.confirmar(pedido);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(pedidoMapper.toResponseDTO(creado));
    }
}
