package edu.dosw.restaurante.sakura_sushi.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import edu.dosw.restaurante.sakura_sushi.model.dto.response.ErrorResponseDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice  // intercepta todos los Controllers
@Slf4j
public class GlobalExceptionHandler {

    // 404 — Recurso no encontrado
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFound(
            RecursoNoEncontradoException ex,
            HttpServletRequest request) {
        log.warn("RecursoNoEncontrado: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildError(404, "Not Found",
                        ex.getMessage(), request.getRequestURI()));
    }

    // 409 — Conflicto (nombre duplicado, mesa ocupada, etc.)
    @ExceptionHandler(ConflictoException.class)
    public ResponseEntity<ErrorResponseDTO> handleConflicto(
            ConflictoException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(buildError(409, "Conflict",
                        ex.getMessage(), request.getRequestURI()));
    }

    // 422 — Regla de negocio / estado inválido
    @SuppressWarnings("deprecation")
	@ExceptionHandler({EstadoInvalidoException.class, ReglaDeNegocioException.class})
    public ResponseEntity<ErrorResponseDTO> handleNegocio(
            RuntimeException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(buildError(422, "Unprocessable Entity",
                        ex.getMessage(), request.getRequestURI()));
    }

    // 400 — Validación de input (@Valid falló)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidacion(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        String mensaje = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(buildError(400, "Bad Request",
                        mensaje, request.getRequestURI()));
    }

    // 500 — Genérico (siempre al final — el más general)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenerico(
            Exception ex, HttpServletRequest request) {
        log.error("Error inesperado: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildError(500, "Internal Server Error",
                        "Error inesperado del servidor",
                        request.getRequestURI()));
    }

    private ErrorResponseDTO buildError(int status, String error,
                                            String message, String path) {
        return ErrorResponseDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error(error)
                .message(message)
                .path(path)
                .build();
    }
}
