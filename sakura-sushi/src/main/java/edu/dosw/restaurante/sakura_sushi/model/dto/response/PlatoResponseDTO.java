package edu.dosw.restaurante.sakura_sushi.model.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder 
public class PlatoResponseDTO {
    
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String categoria;
    private Boolean disponible;
}
