package com.veterinary_clinic.Model;

import java.sql.Date;

/**
 * Guarda los datos básicos de una visita veterinaria.
 */
public class Visit {
    private String visitId;
    private String patientId;
    private Date date;
    private String description; 
    private Long cost;

    

    /**
     * Crea una visita asociada a un paciente.
     *
     * @param visitId identificador de la visita
     * @param patientId identificador del paciente
     * @param date fecha de la visita
     * @param description descripción de la visita
     * @param cost costo de la visita
     * @throws IllegalArgumentException si algún identificador es nulo o la descripción está vacía
     */
    public Visit(String visitId, String patientId, Date date, String description, Long cost) {
        if(visitId == null || patientId == null){
            throw new IllegalArgumentException(
                "Error: el id no puede ser vacio"
            );
        }
        if (description.isBlank()){
            throw new IllegalArgumentException(
                "Error: descripción no puede estar vacio"
            );
        }
        this.cost = cost;
        this.date = date;
        this.description = description;
        this.patientId = patientId;
        this.visitId = visitId;

        }
    
    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCost(Long cost) {
        this.cost = cost;
    }
    /**
     * Crea una visita vacía, útil cuando se completan los datos después.
     */
    public Visit() {
    }
    @Override
    public String toString() {
        return "Visit [visitId=" + visitId + ", patientId=" + patientId + ", date=" + date + ", description="
                + description + ", cost=" + cost + "]";
    }

   

    

    

}
