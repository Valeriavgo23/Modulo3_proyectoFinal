package com.veterinary_clinic.Exception;

/**
 * Indica que no se encontró el paciente solicitado.
 */
public class PatientNotFoundException extends RuntimeException{

    /**
     * Crea el error con una explicación.
     *
     * @param message descripción del problema
     */
    public PatientNotFoundException(String message) {
        super(message);
    }
    

}
