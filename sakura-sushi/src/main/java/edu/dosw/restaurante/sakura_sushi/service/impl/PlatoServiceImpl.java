package edu.dosw.restaurante.sakura_sushi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;
import edu.dosw.restaurante.sakura_sushi.persistence.entity.PlatoEntity;
import edu.dosw.restaurante.sakura_sushi.service.IPlatoService;
import edu.dosw.restaurante.sakura_sushi.validator.IPlatoValidator;
import jakarta.transaction.Transactional;
import edu.dosw.restaurante.sakura_sushi.repository.PlatoRepository;
import edu.dosw.restaurante.sakura_sushi.mapper.PlatoEntityMapper;
import edu.dosw.restaurante.sakura_sushi.exception.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j 
@RequiredArgsConstructor 
public class PlatoServiceImpl implements IPlatoService {

    private final PlatoRepository platoRepository;
    private final PlatoEntityMapper entityMapper;
    private final IPlatoValidator validator;
    
    @Override
    public List<Plato> obtenerTodos() {
        return platoRepository.findAll().stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Plato> obtenerDisponibles() {
        return platoRepository.findByDisponibleTrue().stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public Plato obtenerPorId(Long id) {
        return platoRepository.findById(id)
                .map(entityMapper::toDomain)
                .orElseThrow(() -> new RecursoNoEncontradoException("Plato", id));
    }

    @Override
    public Plato crear(Plato plato) {
        validator.validarNombreUnico(plato.getNombre());
        PlatoEntity guardado = platoRepository.save(entityMapper.toEntity(plato));
        log.info("Plato creado: id={}, nombre={}", guardado.getId(), guardado.getNombre());
        return entityMapper.toDomain(guardado);
    }

    @Override
    @Transactional  // findById + save en una sola transacción — evita inconsistencias
    public Plato actualizar(Long id, Plato nuevosDatos) {
        PlatoEntity existente = platoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Plato", id));
        validator.validarNombreUnicoExcluyendo(nuevosDatos.getNombre(), id);
        existente.setNombre(nuevosDatos.getNombre());
        existente.setPrecio(nuevosDatos.getPrecio());
        existente.setCategoria(nuevosDatos.getCategoria());
        existente.setDescripcion(nuevosDatos.getDescripcion());
        return entityMapper.toDomain(platoRepository.save(existente));
    }

    @Override
    public Plato cambiarDisponibilidad(Long id, boolean disponible) {
        PlatoEntity entidad = platoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Plato", id));
        entidad.setDisponible(disponible);
        return entityMapper.toDomain(platoRepository.save(entidad));
    }

    @Override
    public void eliminar(Long id) {
        if (!platoRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Plato", id);
        }
        platoRepository.deleteById(id);
        log.info("Plato eliminado: id={}", id);
    }

	@Override
	public List<Plato> obtenerPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'obtenerPorCategoria'");
	}
}