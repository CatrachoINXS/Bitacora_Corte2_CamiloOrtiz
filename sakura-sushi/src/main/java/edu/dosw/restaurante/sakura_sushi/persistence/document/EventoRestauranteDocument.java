package edu.dosw.restaurante.sakura_sushi.persistence.document;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "eventos_restaurante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoRestauranteDocument {

    @Id
    private String id;  // Mongo usa String por defecto (ObjectId en BSON)

    private String        tipo;         // "PEDIDO_CREADO", "PLATO_AGOTADO", etc.
    private String        entidadTipo;  // "Pedido", "Plato", "Mesa"
    private Long          entidadId;
    private String        descripcion;
    private String        usuario;
    private LocalDateTime timestamp;

    // Mongo permite campos opcionales — los que no aplican simplemente no van
    private Map<String, Object> metadatos;
}