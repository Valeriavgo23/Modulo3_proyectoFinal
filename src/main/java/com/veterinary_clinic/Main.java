

package com.veterinary_clinic;

import java.util.List;
import java.util.Scanner;

import com.veterinary_clinic.Model.Patient;
import com.veterinary_clinic.Model.Visit;
import com.veterinary_clinic.Service.ClinicManager;

/**
 * Inicia la aplicación y muestra el menú para interactuar con la clínica.
 */
public class Main {

    /**
     * Ejecuta el menú principal hasta que se elija la opción de salida.
     *
     * @param args argumentos de inicio; no se utilizan en esta aplicación
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClinicManager clinicManager = new ClinicManager();

        int option;

        do {
            System.out.println("\n===== CLÍNICA VETERINARIA =====");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar visita");
            System.out.println("3. Consultar pacientes");
            System.out.println("4. Consultar visitas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese una opción numérica.");
                scanner.next();
                System.out.print("Seleccione una opción: ");
            }

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Se solicitan los datos y se comprueba que edad y teléfono sean numéricos.
                    System.out.println("Registro de paciente");

                    System.out.print("Nombre del paciente: ");
                    String name = scanner.nextLine();

                    System.out.print("Especie: ");
                    String species = scanner.nextLine();

                    System.out.print("Edad: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingrese una edad válida.");
                        scanner.next();
                        System.out.print("Edad: ");
                    }
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre del propietario: ");
                    String ownerName = scanner.nextLine();

                    System.out.print("Teléfono del propietario: ");
                    while (!scanner.hasNextLong()) {
                        System.out.println("Ingrese un teléfono válido.");
                        scanner.next();
                        System.out.print("Teléfono del propietario: ");
                    }
                    long ownerPhone = scanner.nextLong();
                    scanner.nextLine();

                    try {
                        String result = clinicManager.registerPatients(
                            name, species, age, ownerName, ownerPhone
                        );
                        System.out.println(result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // El registro de visitas todavía no está conectado al menú.
                    System.out.println("Aquí registrarás las visitas.");
                    break;

                case 3:
                    // Se muestran los pacientes guardados durante esta ejecución.
                    System.out.println("Aquí consultarás los pacientes.");
                    List<Patient> patients = clinicManager.consultarPacientes();

                    for (Patient patient : patients) {
                    System.out.println(patient);}
                    break;

                case 4:
                    // Se muestran las visitas guardadas durante esta ejecución.
                    System.out.println("Aquí consultarás las visitas.");
                    List<Visit > visits = clinicManager.consultarVisitas();
                    for (Visit visit : visits){
                        System.out.println(visit);
                    }
                    break;

                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (option != 0);

        scanner.close();
    }
}
