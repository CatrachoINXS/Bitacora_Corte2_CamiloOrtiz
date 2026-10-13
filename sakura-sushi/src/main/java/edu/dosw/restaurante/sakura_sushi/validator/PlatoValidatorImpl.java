package edu.dosw.restaurante.sakura_sushi.validator;

import java.util.Collection;

import org.springframework.stereotype.Component;

import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;
import edu.dosw.restaurante.sakura_sushi.repository.PlatoRepository;
import edu.dosw.restaurante.sakura_sushi.exception.*;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor  
public class PlatoValidatorImpl implements IPlatoValidator {

    private final PlatoRepository platoRepository;
    
    @Override
    public void validarSinPedidosActivos(Long idPlato, Collection<Pedido> pedidosActivos) {
        // TODO Auto-generated method stub
    }

    @Override
    public void validarNombreUnico(String nombre) {
        if (platoRepository.existsByNombreIgnoreCase(nombre)) {
            throw new ConflictoException("Ya existe un plato con el nombre '" + nombre + "'");
        }
    }

    @Override
    public void validarNombreUnicoExcluyendo(String nombre, Long id) {
        if (platoRepository.existsByNombreIgnoreCaseAndIdNot(nombre, id)) {
            throw new ConflictoException("Ya existe otro plato con el nombre '" + nombre + "'");
        }
    }
    
}
