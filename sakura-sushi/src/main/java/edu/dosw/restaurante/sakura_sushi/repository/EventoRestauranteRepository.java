package edu.dosw.restaurante.sakura_sushi.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import edu.dosw.restaurante.sakura_sushi.persistence.document.EventoRestauranteDocument;

@Repository
public interface EventoRestauranteRepository
        extends MongoRepository<EventoRestauranteDocument, String> {

    List<EventoRestauranteDocument> findByEntidadTipoAndEntidadId(
            String entidadTipo, Long entidadId);

    List<EventoRestauranteDocument> findByTipoAndTimestampBetween(
            String tipo, LocalDateTime desde, LocalDateTime hasta);
}