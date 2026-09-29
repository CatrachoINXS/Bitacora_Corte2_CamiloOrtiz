package edu.dosw.restaurante.sakura_sushi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.dosw.restaurante.sakura_sushi.persistence.document.EventoRestauranteDocument;
import edu.dosw.restaurante.sakura_sushi.model.domain.EventoRestaurante;

@Mapper(componentModel = "spring")
public interface EventoMapper {
    // Dominio → Documento (para guardar en Mongo)
    // El id lo asigna Mongo al hacer save()
    @Mapping(target = "id", ignore = true)
    EventoRestauranteDocument toDocument(EventoRestaurante evento);

    // Documento → Dominio (al leer de Mongo)
    EventoRestaurante toDomain(EventoRestauranteDocument doc);
}
