package edu.dosw.restaurante.sakura_sushi.controller;

import edu.dosw.restaurante.sakura_sushi.mapper.PedidoMapper;
import edu.dosw.restaurante.sakura_sushi.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/pedidos")
@RequiredArgsConstructor
@RestController
public class PedidoController {

    private final PedidoMapper pedidoMapper;
    private final IPedidoService pedidoService;
}
