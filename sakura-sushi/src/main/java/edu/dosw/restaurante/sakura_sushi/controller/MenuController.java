package edu.dosw.restaurante.sakura_sushi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.dosw.restaurante.sakura_sushi.service.IPlatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import edu.dosw.restaurante.sakura_sushi.mapper.PlatoMapper;
import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.PlatoResponseDTO;
import edu.dosw.restaurante.sakura_sushi.exception.*;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor 

public class MenuController {

    private final IPlatoService platoService;
    private final PlatoMapper platoMapper;

    @GetMapping
    @Operation(summary = "Ver carta del restaurante")
    @ApiResponse(responseCode = "200", description = "Platos disponibles")
    public ResponseEntity<List<PlatoResponseDTO>> verCarta() {
        return ResponseEntity.ok(
            platoService.obtenerDisponibles().stream()
                .map(platoMapper::toResponse)
                .toList()
        );
    }

    
    @GetMapping("/{id}")
    @Operation(summary = "Ver detalle de un plato")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Plato encontrado"),
        @ApiResponse(responseCode = "404", description = "Plato no existe o no disponible")
    })
    public ResponseEntity<PlatoResponseDTO> verDetalle(@PathVariable Long id) {
        Plato plato = platoService.obtenerPorId(id);
        if (!(plato.getDisponible() == true)) {
            throw new PlatoNotFoundException();
        }
        return ResponseEntity.ok(platoMapper.toResponse(plato));
    }
    

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Ver carta filtrada por categoría")
    @ApiResponse(responseCode = "200", description = "Platos de la categoría")
    public ResponseEntity<List<PlatoResponseDTO>> porCategoria(
            @PathVariable String categoria) {
        return ResponseEntity.ok(
            platoService.obtenerPorCategoria(categoria).stream()
                .filter(p -> p.getDisponible() == true)
                .map(platoMapper::toResponse)
                .toList()
        );
    }
}