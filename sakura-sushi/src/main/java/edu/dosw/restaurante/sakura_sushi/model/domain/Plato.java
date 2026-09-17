package edu.dosw.restaurante.sakura_sushi.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder  
public class Plato {
    
    private Long id;
    private String nombre;
    private Double precio;
    private String categoria;
    private Boolean disponible;

    public Boolean esValido() {
        return Boolean.TRUE.equals(disponible);
    }

    public void activar() { this.disponible = true; }
    public void desactivar() { this.disponible = false; }
}
