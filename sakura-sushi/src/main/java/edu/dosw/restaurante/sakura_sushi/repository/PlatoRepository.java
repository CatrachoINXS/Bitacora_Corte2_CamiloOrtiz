package edu.dosw.restaurante.sakura_sushi.repository;

import edu.dosw.restaurante.sakura_sushi.persistence.entity.PlatoEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlatoRepository extends JpaRepository<PlatoEntity, Long> {
    
    List<PlatoEntity> findByDisponibleTrue();
    List<PlatoEntity> findByCategoriaIgnoreCase(String categoria);
    boolean           existsByNombreIgnoreCase(String nombre);
    boolean           existsByNombreIgnoreCaseAndIdNot(String nombre, Long id);
}
