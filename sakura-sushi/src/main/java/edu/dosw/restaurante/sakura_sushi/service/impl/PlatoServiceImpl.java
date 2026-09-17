package edu.dosw.restaurante.sakura_sushi.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;
import edu.dosw.restaurante.sakura_sushi.service.IPlatoService;
import edu.dosw.restaurante.sakura_sushi.validator.IPlatoValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j 
@RequiredArgsConstructor 
public class PlatoServiceImpl implements IPlatoService {

    private final  Map<Long, Plato> platos  = new ConcurrentHashMap<>();
    private final AtomicLong          contador = new AtomicLong(1);
    private final IPlatoValidator      validator;
    
    @Override
    public List<Plato> obtenerTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
    }
    @Override
    public List<Plato> obtenerDisponibles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDisponibles'");
    }
    @Override
    public List<Plato> obtenerPorCategoria(String categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorCategoria'");
    }
    @Override
    public Plato obtenerPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorId'");
    }
    @Override
    public Plato crear(Plato plato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }
    @Override
    public Plato actualizar(Long id, Plato plato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }
    @Override
    public Plato cambiarDisponibilidad(Long id, boolean disponible) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarDisponibilidad'");
    }
    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
    
}