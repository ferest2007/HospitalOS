/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.codigo.compensar;

import java.util.Scanner;

/**
 *
 * @author jesus
 */
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalOS salaEspera = new HospitalOS();
        Hospital hospitalMatriz = new Hospital(3, 4); // Inicializa las 12 camas físicas

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n---- HospitalOS System ----");
            System.out.println("1. Registrar Paciente (Triage)");
            System.out.println("2. Ver Sala de Espera Completa ");
            System.out.println("3. Atender y Asignar Cama");
            System.out.println("4. Ver Mapa de Camas Hospitalarias (Matriz)");
            System.out.println("5. Registrar Tratamiento Medico");
            System.out.println("6. Ver Historial Clinico de Tratamientos ");
            System.out.println("7. Buscar Paciente por ID");
            System.out.println("8. Dar de Alta Paciente (Liberar Cama)");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el salto de línea del buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nom = sc.nextLine();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.println("\nSeleccione el Problema Medico:");
                    System.out.println("1. Cambio de marcapaso (Gravedad 1 - Critico)");
                    System.out.println("2. Crisis Hipertensiva (Gravedad 2 - Urgente)");
                    System.out.println("3. Heridas Profundas / Sutura (Gravedad 3 - Moderado)");
                    System.out.println("4. Fracturas o luxaciones (Gravedad 4 - Leve)");
                    System.out.println("5. General / Control (Gravedad 5 - Rutina)");
                    System.out.print("Seleccion: ");
                    int problema = sc.nextInt();
                    sc.nextLine();

                    String motivo = "General";
                    int gravedad = 5;

                    if (problema == 1) { motivo = "Cambio marcapaso"; gravedad = 1; }
                    else if (problema == 2) { motivo = "Crisis Hipertensiva"; gravedad = 2; }
                    else if (problema == 3) { motivo = "Herida Profunda"; gravedad = 3; }
                    else if (problema == 4) { motivo = "Fractura/Luxacion"; gravedad = 4; }
                    else if (problema == 5) { motivo = "General"; gravedad = 5; }

                    salaEspera.registrarPaciente(nom, id, motivo, gravedad);
                    break;

                case 2:
                    salaEspera.recorrer();
                    break;

                case 3:
                    if (salaEspera.cabeza == null) {
                        System.out.println("No hay pacientes pendientes en la sala de espera.");
                    } else {
                        // El paciente al frente es el mas critico debido a la prioridad
                        Nodo proximo = salaEspera.cabeza;
                        System.out.println("\nProximo paciente critico a hospitalizar: " + proximo.nombre + " (G:" + proximo.gravedad + ")");
                        hospitalMatriz.visualizarCamas();
                        
                        System.out.print("Asigne Piso (0-2): ");
                        int p = sc.nextInt();
                        System.out.print("Asigne Cama (0-3): ");
                        int c = sc.nextInt();

                        // Si la cama esta libre, lo guardamos en la matriz y lo sacamos de la sala de espera
                        if (hospitalMatriz.asignarCama(proximo, p, c)) {
                            salaEspera.desencolarProximo();
                        }
                    }
                    break;

                case 4:
                    hospitalMatriz.visualizarCamas();
                    break;

                case 5:
                    System.out.print("Ingrese el ID del paciente hospitalizado: ");
                    int idBuscarT = sc.nextInt();
                    sc.nextLine();
                    Nodo pTratamiento = hospitalMatriz.buscarPacienteEnCama(idBuscarT);

                    if (pTratamiento != null) {
                        System.out.print("Descripcion del tratamiento / medicamento aplicado: ");
                        String desc = sc.nextLine();
                        pTratamiento.historial.push(desc); // Insercion directa en su pila
                        System.out.println("Tratamiento acumulado con exito.");
                    } else {
                        System.out.println("El paciente no se encuentra asignado a ninguna cama actualmente.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el ID del paciente: ");
                    int idHistorial = sc.nextInt();
                    Nodo pHistorial = hospitalMatriz.buscarPacienteEnCama(idHistorial);

                    if (pHistorial != null) {
                        System.out.println("\nHistorial de intervenciones para: " + pHistorial.nombre);
                        pHistorial.historial.mostrarHistorial(); // Lectura LIFO
                    } else {
                        System.out.println("Paciente no encontrado en el sistema de hospitalizacion.");
                    }
                    break;

                case 7:
                    System.out.print("ID a buscar: ");
                    int idB = sc.nextInt();
                    // Comprobar ambas estructuras
                    salaEspera.buscar(idB);
                    Nodo pEnCama = hospitalMatriz.buscarPacienteEnCama(idB);
                    if (pEnCama != null) {
                        System.out.println("[Resultado en Camas]: Hospitalizado en Piso " + " | Paciente: " + pEnCama.nombre);
                    }
                    break;

                case 8:
                    System.out.print("Ingrese Piso (0-2) de la cama a liberar: ");
                    int pf = sc.nextInt();
                    System.out.print("Ingrese Habitacion (0-3) de la cama a liberar: ");
                    int cf = sc.nextInt();
                    Nodo dadoDeAlta = hospitalMatriz.liberarCama(pf, cf);
                    if (dadoDeAlta != null) {
                        System.out.println("El paciente " + dadoDeAlta.nombre + " ha sido dado de alta.");
                    }
                    break;

                case 0:
                    System.out.println("Apagando HospitalOS... Buen turno");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }
}
    
    

