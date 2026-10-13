package edu.dosw.restaurante.sakura_sushi.service.impl;

import edu.dosw.restaurante.sakura_sushi.mapper.PedidoMapper;
import edu.dosw.restaurante.sakura_sushi.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoServiceImpl implements IPedidoService {

    private final PedidoMapper pedidoMapper;
}
