package com.veterinary_clinic.Model;

/**
 * Guarda los datos de un paciente y de su propietario.
 */
public class Patient {
    private String patientId;
    private String name;
    private String species;
    private Integer age;
    private String ownerName;
    private Long ownerPhone;

    /**
     * Crea un paciente y comprueba que su nombre, especie y edad sean válidos.
     *
     * @param name nombre del paciente
     * @param species especie del paciente
     * @param age edad del paciente, en años
     * @param ownerName nombre del propietario
     * @param ownerPhone teléfono del propietario
     * @throws IllegalArgumentException si el nombre o la especie son nulos, o la edad no es válida
     */
    public Patient(
        String name, 
        String species, 
        Integer age, 
        String ownerName,
        Long ownerPhone) {
      
        if (name == null || species == null){
             throw new IllegalArgumentException(
            "Error: no puede estar vacio"
        );
       }
       validateAge(age);
       this.name = name;
       this.age = age;
       this.species = species;
       this.ownerName = ownerName;
       this.ownerPhone = ownerPhone;
    }

  
   

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        validateAge(age);
        this.age = age;
    }

    /**
     * Evita guardar una edad nula o menor que cero.
     *
     * @param age edad que se va a comprobar
     * @throws IllegalArgumentException si la edad es nula o negativa
     */
    private void validateAge(Integer age) {
        if (age == null || age < 0) {
            throw new IllegalArgumentException(
                "La edad no puede ser nula ni negativa"
            );
        }
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(Long ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    @Override
    public String toString() {
        return "ClinicManager [patientId=" + patientId + ", name=" + name + ", species=" + species + ", age=" + age
                + ", ownerName=" + ownerName + ", ownerPhone=" + ownerPhone + "]";
    }

    
    

}
