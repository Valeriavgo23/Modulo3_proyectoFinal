package com.veterinary_clinic.Model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprueba la creación, validación y actualización de los datos de Patient.
 */
class PatientTest {

    @Test
    @DisplayName("Debe crear un paciente correctamente con datos válidos")
    void shouldCreatePatientWithValidData() {
        // Preparo los datos del paciente.
        String name = "Fido";
        String species = "Perro";
        int age = 3;
        String ownerName = "Carlos Ruiz";
        Long ownerPhone = 5551234L;

        // Creo el paciente con esos datos.
        Patient patient = new Patient(name,species,age,ownerName,ownerPhone);

        // Compruebo que los datos se hayan guardado correctamente.
        assertEquals(name, patient.getName(), "El nombre del paciente no coincide");
        assertEquals(species, patient.getSpecies(), "La especie del paciente no coincide");
        assertEquals(age, patient.getAge(), "La edad del paciente no coincide");
        assertEquals(ownerName, patient.getOwnerName(), "El nombre del propietario no coincide");
        assertEquals(ownerPhone, patient.getOwnerPhone(), "El teléfono del propietario no coincide");
    }

    @Test
    @DisplayName("Debe rechazar nombre o especie nulos")
    void shouldThrowExceptionWhenNameOrSpeciesIsNull() {
        // Compruebo que el constructor rechace los datos obligatorios cuando son nulos.
        assertThrows(
            IllegalArgumentException.class,
            () -> new Patient(null, "Perro", 3, "Carlos Ruiz", 5551234L)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> new Patient("Fido", null, 3, "Carlos Ruiz", 5551234L)
        );
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException al crear paciente con edad negativa")
    void shouldThrowExceptionWhenCreatingPatientWithNegativeAge() {
        // Preparo un paciente con una edad que no es válida.
        String name = "Luna";
        String species = "Gato";
        int age = -1;
        String ownerName = "Maria Gomez";
        Long ownerPhone = 5555678L;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Patient(name, species, age, ownerName, ownerPhone);
        }, "Se esperaba IllegalArgumentException por edad negativa");

        // Verifico el tipo de error y que explique el problema con la edad.
        assertTrue(thrown.getMessage().contains("negativa"), "El mensaje de error debe indicar edad negativa");
    }

    @Test
    @DisplayName("Debe rechazar una edad nula al crear un paciente")
    void shouldThrowExceptionWhenCreatingPatientWithNullAge() {
        // La edad es obligatoria, por eso el constructor debe rechazar null.
        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> new Patient("Luna", "Gato", null, "Maria Gomez", 5555678L)
        );

        assertTrue(thrown.getMessage().contains("nula"));
    }

    @Test
    @DisplayName("Debe actualizar la edad del paciente correctamente")
    void shouldUpdatePatientAgeCorrectly() {
        // Preparo un paciente y una nueva edad válida.
        Patient patient = new Patient("Leo", "León", 1, "Zoo", 9999999L);
        int newAge = 2;

        // Actualizo la edad.
        patient.setAge(newAge);

        // Compruebo que se haya guardado el nuevo valor.
        assertEquals(newAge, patient.getAge(), "La edad no se actualizó correctamente");
    }

    @Test
    @DisplayName("No debe permitir actualizar la edad a un valor negativo")
    void shouldThrowExceptionWhenUpdatingPatientWithNegativeAge() {
        Patient patient = new Patient("Leo", "León", 1, "Zoo", 9999999L);

        // Si la edad no es válida, el paciente debe conservar el valor anterior.
        assertThrows(IllegalArgumentException.class, () -> patient.setAge(-1));
        assertEquals(1, patient.getAge(), "La edad debe conservarse si la actualización falla");
    }

    @Test
    @DisplayName("No debe permitir actualizar la edad a nulo")
    void shouldThrowExceptionWhenUpdatingPatientWithNullAge() {
        Patient patient = new Patient("Leo", "León", 1, "Zoo", 9999999L);

        // Una edad nula no debe reemplazar la edad que ya tenía el paciente.
        assertThrows(IllegalArgumentException.class, () -> patient.setAge(null));
        assertEquals(1, patient.getAge(), "La edad debe conservarse si la actualización falla");
    }

    @Test
    @DisplayName("Debe actualizar los demás datos del paciente")
    void shouldUpdatePatientDetails() {
        Patient patient = new Patient("Leo", "León", 1, "Zoo", 9999999L);

        // Actualizo los campos que no tienen validaciones adicionales.
        patient.setPatientId("P-1");
        patient.setName("Milo");
        patient.setSpecies("Gato");
        patient.setOwnerName("Ana Ruiz");
        patient.setOwnerPhone(5551111L);

        // Compruebo que cada setter haya actualizado el dato correspondiente.
        assertEquals("P-1", patient.getPatientId());
        assertEquals("Milo", patient.getName());
        assertEquals("Gato", patient.getSpecies());
        assertEquals("Ana Ruiz", patient.getOwnerName());
        assertEquals(5551111L, patient.getOwnerPhone());
    }
}
