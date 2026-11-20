/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.codigo.compensar;

/**
 *
 * @author jesus
 */
public class Hospital {
Nodo[][] camas; // Matriz que almacena nodos completos de pacientes
    int pisos;
    int habitaciones;

    public Hospital (int pisos, int habitaciones) {
        this.pisos = pisos;
        this.habitaciones = habitaciones;
        this.camas = new Nodo[pisos][habitaciones];
    }

    // Ubicar un paciente en una coordenada
    public boolean asignarCama(Nodo paciente, int piso, int cama) {
        if (piso < 0 || piso >= pisos || cama < 0 || cama >= habitaciones) {
            System.out.println("Error: Ubicacion inválida en el hospital.");
            return false;
        }
        if (camas[piso][cama] != null) {
            System.out.println("Error: La cama ya esta ocupada por " + camas[piso][cama].nombre);
            return false;
        }
        camas[piso][cama] = paciente;
        System.out.println("Paciente " + paciente.nombre + " asignado con exito a la cama");
        return true;
    }

    // Liberar una celda de la matriz al dar de alta
    public Nodo liberarCama(int piso, int cama) {
        if (piso < 0 || piso >= pisos || cama < 0 || cama >= habitaciones) {
            System.out.println("Ubicacion invalida.");
            return null;
        }
        if (camas[piso][cama] == null) {
            System.out.println("La cama ya estaba vacia.");
            return null;
        }
        Nodo dadoAlta = camas[piso][cama];
        camas[piso][cama] = null; // Cama liberada
        return dadoAlta;
    }

    // Buscar un paciente dentro de la matriz por su numero de identificacion
    public Nodo buscarPacienteEnCama(int idBuscado) {
        for (int f = 0; f < pisos; f++) {
            for (int c = 0; c < habitaciones; c++) {
                if (camas[f][c] != null && camas[f][c].id == idBuscado) {
                    return camas[f][c];
                }
            }
        }
        return null;
    }

    // Dibujar visualmente la distribucion de las camas en consola
    public void visualizarCamas() {
        System.out.println("\n--- MAPA DE HOSPITALIZACION (MATRIZ DE CAMAS) ---");
        for (int f = 0; f < pisos; f++) {
            System.out.print("Piso " + f + ": ");
            for (int c = 0; c < habitaciones; c++) {
                if (camas[f][c] == null) {
                    System.out.print("[ Vacio ] ");
                } else {
                    System.out.print("[" + camas[f][c].nombre + " (G:" + camas[f][c].gravedad + ")] ");
                }
            }
            System.out.println();
        }
    }
}
    

