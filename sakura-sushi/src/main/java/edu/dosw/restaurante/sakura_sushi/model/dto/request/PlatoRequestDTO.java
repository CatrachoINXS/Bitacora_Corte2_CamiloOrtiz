package edu.dosw.restaurante.sakura_sushi.model.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class PlatoRequestDTO {

    @NotBlank(message = "El nombre del plato es obligatorio")
    @Size(min = 2, max = 80, message = "El nombre debe tener entre 2 y 80 caracteres")
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a cero")
    private Double precio;

    @NotBlank(message = "La categoría es obligatoria")
    @Pattern(
            regexp = "ENTRADA|PLATO_FUERTE|POSTRE|BEBIDA",
            message = "Categoría inválida. Opciones: ENTRADA, PLATO_FUERTE, POSTRE, BEBIDA"
    )
    private String categoria;

    @Size(max = 500, message = "La descripción no puede superar 500 caracteres")
    private String descripcion;
}
