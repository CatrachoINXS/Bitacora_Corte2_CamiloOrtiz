package edu.dosw.restaurante.sakura_sushi.service;

import java.util.List;

import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;

public interface IPlatoService {

    List<Plato>  obtenerTodos();
    List<Plato>  obtenerDisponibles();
    List<Plato>  obtenerPorCategoria(String categoria);
    Plato        obtenerPorId(Long id);
    Plato        crear(Plato plato);
    Plato        actualizar(Long id, Plato plato);
    Plato        cambiarDisponibilidad(Long id, boolean disponible);
    void         eliminar(Long id);

}