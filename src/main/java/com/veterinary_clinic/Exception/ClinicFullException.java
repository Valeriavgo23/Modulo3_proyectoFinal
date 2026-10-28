package com.veterinary_clinic.Exception;

/**
 * Representa el error que se utiliza cuando la clínica está llena.
 */
public class ClinicFullException extends RuntimeException{

    /**
     * Crea el error con una explicación.
     *
     * @param message descripción del problema
     */
    public ClinicFullException(String message) {
        super(message);
    }

    

}
