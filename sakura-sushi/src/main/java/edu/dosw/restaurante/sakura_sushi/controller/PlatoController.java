package edu.dosw.restaurante.sakura_sushi.controller;

import java.util.List;

import edu.dosw.restaurante.sakura_sushi.service.IPlatoService;
import edu.dosw.restaurante.sakura_sushi.mapper.PlatoMapper;
import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;
import edu.dosw.restaurante.sakura_sushi.model.dto.request.PlatoRequestDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.PlatoResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/v1/platos")
@RequiredArgsConstructor 
@Slf4j 

public class PlatoController {

    private final IPlatoService platoService;
    private final PlatoMapper platoMapper;

    @GetMapping
    @Operation(summary = "Obtener todos lor platos")
    public ResponseEntity<List<PlatoResponseDTO>> obtenerTodos() {
        log.info("GET /api/v1/platos");
        List<Plato> platos = platoService.obtenerTodos();

        return ResponseEntity.ok(
            platos.stream().map(platoMapper::toResponse).toList()
        );
    }


    @GetMapping("/{id}")
    @Operation(summary = "Obtener plato por id")
    public ResponseEntity<PlatoResponseDTO> obtenerPorId(@PathVariable Long id) {
        Plato plato = platoService.obtenerPorId(id);
        return ResponseEntity.ok(platoMapper.toResponse(plato));
    }


    @PostMapping
    @Operation(summary = "Crear un nuevo plato")
    public ResponseEntity<PlatoResponseDTO> crear(
            @RequestBody @Valid PlatoRequestDTO dto) {
        log.info("POST /api/v1/platos - nombre={}", dto.getNombre());

        Plato plato = platoMapper.toDomain(dto);
        Plato creado = platoService.crear(plato);
        
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(platoMapper.toResponse(creado));
    }


    @PatchMapping("/{id}/disponible")
    @Operation(summary = "Cambiar la disponibilidad de un plato")
    public ResponseEntity<PlatoResponseDTO> cambiarDisponibilidad(@PathVariable Long id, 
            @RequestParam boolean disponible) {

        Plato actualizado = platoService.cambiarDisponibilidad(id, disponible);
        return ResponseEntity.ok(platoMapper.toResponse(actualizado));
    }
    

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un plato")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        platoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}