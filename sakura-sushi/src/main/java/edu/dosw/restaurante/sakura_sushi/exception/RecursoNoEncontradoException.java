package edu.dosw.restaurante.sakura_sushi.exception;

public class RecursoNoEncontradoException extends RuntimeException {
     public RecursoNoEncontradoException(String recurso, Long id) {
        super("No existe " + recurso + " con id=" + id);
    }
}
