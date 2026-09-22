package edu.dosw.restaurante.sakura_sushi.validator;

import java.util.Collection;

import org.springframework.stereotype.Component;

import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;

@Component 
public class PlatoValidatorImpl implements IPlatoValidator {

    @Override
    public void validarNombreUnico(String nombre, Collection<Plato> platosExistentes) {
        // TODO Auto-generated method stub
    }

    @Override
    public void validarSinPedidosActivos(Long idPlato, Collection<Pedido> pedidosActivos) {
        // TODO Auto-generated method stub
    }
    
}
