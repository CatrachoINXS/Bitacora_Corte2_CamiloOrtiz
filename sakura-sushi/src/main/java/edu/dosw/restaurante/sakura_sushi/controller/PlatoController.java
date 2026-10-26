package edu.dosw.restaurante.sakura_sushi.controller;

import java.util.List;

import edu.dosw.restaurante.sakura_sushi.service.IPlatoService;
import edu.dosw.restaurante.sakura_sushi.mapper.PlatoMapper;
import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;
import edu.dosw.restaurante.sakura_sushi.model.dto.request.PlatoRequestDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.PlatoResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/{id}")
    @Operation(summary = "Actualizar plato")
    public ResponseEntity<PlatoResponseDTO> actualizar(@PathVariable Long id,
                                                       @RequestBody @Valid PlatoRequestDTO dto) {
        log.info("PUT /api/v1/platos/{id}");

        Plato actualizado = platoService.actualizar(id, platoMapper.toDomain(dto));
        return ResponseEntity.ok(platoMapper.toResponse(actualizado));
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