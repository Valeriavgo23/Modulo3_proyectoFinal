

package com.veterinary_clinic.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.veterinary_clinic.Exception.InvalidDataException;
import com.veterinary_clinic.Exception.PatientNotFoundException;
import com.veterinary_clinic.Model.Patient;
import com.veterinary_clinic.Model.Visit;

/**
 * Administra en memoria los pacientes y las visitas de la clínica.
 */
public class ClinicManager {

    private List<Patient> patients;
    private List<Visit> visits;

    private Integer patientIdCount = 0;
    private Integer visitIdCount = 0;

    /**
     * Crea las listas vacías que se usan para almacenar los registros.
     */
    public ClinicManager() {
        this.patients = new ArrayList<>();
        this.visits = new ArrayList<>();
    }

    /**
     * Valida los datos del propietario y registra un paciente.
     *
     * @param name nombre del paciente
     * @param species especie del paciente
     * @param age edad del paciente
     * @param ownerName nombre de su propietario
     * @param ownerPhone teléfono de su propietario
     * @return mensaje que confirma el registro
     * @throws InvalidDataException si los datos del propietario no son válidos
     * @throws IllegalArgumentException si los datos del paciente no son válidos
     */
    public String registerPatients(
            String name,
            String species,
            Integer age,
            String ownerName,
            Long ownerPhone) {

        // Validar los datos del propietario
        if (ownerName == null || ownerName.isBlank()) {
            throw new InvalidDataException(
                "El nombre del propietario es obligatorio"
            );
        }

        if (ownerPhone == null || ownerPhone <= 0) {
            throw new InvalidDataException(
                "El teléfono del propietario no es válido"
            );
        }

        // Crear el paciente
        // Patient valida sus propios atributos
        Patient newPatient = new Patient(
            name, species, age, ownerName, ownerPhone
        );

        patients.add(newPatient);
        patientIdCount++;

        return "Paciente registrado correctamente";
    }

    /**
     * Comprueba los datos y registra una visita para un paciente ya registrado.
     *
     * @param visitId identificador de la visita
     * @param patientId identificador del paciente atendido
     * @param date fecha de la visita
     * @param description motivo o descripción de la visita
     * @param cost costo de la visita
     * @return mensaje que confirma el registro
     * @throws InvalidDataException si falta algún dato o no cumple las validaciones
     * @throws PatientNotFoundException si no hay un paciente con ese identificador
     */
    public String registerVisit(
            String visitId,
            String patientId,
            Date date,
            String description,
            Long cost) {

        // Validar el ID del paciente
        if (patientId == null || patientId.isBlank()) {
            throw new InvalidDataException(
                "El ID del paciente es obligatorio"
            );
        }

        // Comprobar que el paciente exista
        boolean patientExists = patients.stream()
            .anyMatch(patient ->
                patientId.equals(patient.getPatientId())
            );

        if (!patientExists) {
            throw new PatientNotFoundException(
                "El paciente no fue encontrado"
            );
        }

        // Validar la fecha
        if (date == null) {
            throw new InvalidDataException(
                "La fecha es obligatoria"
            );
        }

        // Validar la descripción
        if (description == null || description.isBlank()) {
            throw new InvalidDataException(
                "La descripción no puede estar vacía"
            );
        }

        // Validar el costo
        if (cost == null || cost <= 0) {
            throw new InvalidDataException(
                "El costo debe ser mayor que cero"
            );
        }

        // Crear y guardar la visita
        Visit newVisit = new Visit(
            visitId, patientId, date, description, cost
        );

        visits.add(newVisit);
        visitIdCount++;

        return "Visita registrada correctamente";
    }

    /**
     * Devuelve la lista de pacientes registrados.
     *
     * @return pacientes almacenados en esta instancia
     */
    public List<Patient> consultarPacientes() {
        return patients;
    }

    /**
     * Devuelve la lista de visitas registradas.
     *
     * @return visitas almacenadas en esta instancia
     */
    public List<Visit> consultarVisitas() {
        return visits;
    }
}
