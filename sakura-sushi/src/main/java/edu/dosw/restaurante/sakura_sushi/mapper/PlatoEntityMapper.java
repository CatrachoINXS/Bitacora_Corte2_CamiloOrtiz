package edu.dosw.restaurante.sakura_sushi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.dosw.restaurante.sakura_sushi.persistence.entity.PlatoEntity;
import edu.dosw.restaurante.sakura_sushi.model.domain.Plato;

@Mapper(componentModel = "spring")
public interface PlatoEntityMapper {

    @Mapping(target = "creadoEn", ignore = true)
    PlatoEntity toEntity(Plato plato);

    Plato toDomain(PlatoEntity entidad);
}
