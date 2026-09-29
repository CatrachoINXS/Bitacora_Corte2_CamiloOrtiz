package edu.dosw.restaurante.sakura_sushi.validator;

import java.util.Collection;

import org.springframework.stereotype.Component;

import edu.dosw.restaurante.sakura_sushi.model.domain.Pedido;

@Component 
public interface IPlatoValidator {

    void validarNombreUnico(String nombre);
    void validarSinPedidosActivos(Long idPlato, Collection<Pedido> pedidosActivos);
    void validarNombreUnicoExcluyendo(String nombre, Long id);
    
}
