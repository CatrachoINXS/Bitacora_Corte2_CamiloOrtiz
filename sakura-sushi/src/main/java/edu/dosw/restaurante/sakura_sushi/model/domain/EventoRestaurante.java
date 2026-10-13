package edu.dosw.restaurante.sakura_sushi.model.domain;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder
public class EventoRestaurante {
    private String id;

    private String        tipo; 
    private String        entidadTipo;  
    private Long          entidadId;
    private String        descripcion;
    private String        usuario;
    private LocalDateTime timestamp;

    private Map<String, Object> metadatos;
}
