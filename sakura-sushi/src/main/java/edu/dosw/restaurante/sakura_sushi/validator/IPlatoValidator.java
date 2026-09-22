package edu.dosw.restaurante.sakura_sushi.validator;

import java.util.Collection;

import org.springframework.stereotype.Component;

import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;

@Component 
public interface IPlatoValidator {

    void validarNombreUnico(String nombre, Collection<Plato> platosExistentes);
    void validarSinPedidosActivos(Long idPlato, Collection<Pedido> pedidosActivos);
    
}
