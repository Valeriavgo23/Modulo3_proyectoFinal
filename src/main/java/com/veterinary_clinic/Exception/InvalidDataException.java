package com.veterinary_clinic.Exception;

/**
 * Indica que los datos recibidos no cumplen las validaciones de la aplicación.
 */
public class InvalidDataException extends RuntimeException{

    /**
     * Crea el error con una explicación del dato inválido.
     *
     * @param message descripción del problema
     */
    public InvalidDataException(String message) {
        super(message);
    }
    

}
