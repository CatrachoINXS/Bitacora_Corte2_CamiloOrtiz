package edu.dosw.restaurante.sakura_sushi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;
import edu.dosw.restaurante.sakura_sushi.model.dto.request.PlatoRequestDTO;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.PlatoResponseDTO;

@Mapper(componentModel = "spring")
public interface PlatoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "disponible", constant = "true")
    Plato toDomain(PlatoRequestDTO dto);

    PlatoResponseDTO toResponse(Plato plato);

    List<PlatoResponseDTO> toResponseList(List<Plato> platos);
}
