/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.codigo.compensar;

/**
 *
 * @author Casa
 */
public class HospitalOS {
    Nodo cabeza;

    public HospitalOS() {
        this.cabeza = null;
    }

    // Inserción Ordenada: Transforma la lista en una Cola de Prioridad legítima
    public void registrarPaciente(String nombre, int id, String motivo, int gravedad) {
        Nodo nuevo = new Nodo(nombre, id, motivo, gravedad);

        // CASO 1: Sala vacía o el paciente que llega es más grave (numero menor) que el primero
        if (cabeza == null || gravedad < cabeza.gravedad) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            System.out.println("Paciente registrado al inicio de la fila por prioridad medica.");
            return;
        }

        // CASO 2: Buscar su lugar correspondiente en la fila
        Nodo temp = cabeza;
        while (temp.siguiente != null && temp.siguiente.gravedad <= gravedad) {
            temp = temp.siguiente;
        }
        nuevo.siguiente = temp.siguiente;
        temp.siguiente = nuevo;
        System.out.println("Paciente registrado en la sala de espera.");
    }

    // Remueve y retorna al paciente que está al frente (Desencolar)
    public Nodo desencolarProximo() {
        if (cabeza == null) {
            return null;
        }
        Nodo atendido = cabeza;
        cabeza = cabeza.siguiente; // Avanza el frente
        return atendido;
    }

    // Recorrido lineal de la lista
    public void recorrer() {
        if (cabeza == null) {
            System.out.println("Sala de espera vacia. No hay pacientes en cola.");
            return;
        }
        System.out.println("\n--- PACIENTES EN SALA DE ESPERA (Por orden de prioridad) ---");
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.println("ID: " + temp.id + " | Paciente: " + temp.nombre + " | Motivo: " + temp.motivo + " | Gravedad: " + temp.gravedad);
            temp = temp.siguiente;
        }
    }

    // Búsqueda lineal en sala de espera
    public void buscar(int idBuscado) {
        Nodo temp = cabeza;
        boolean encontrado = false;
        while (temp != null) {
            if (temp.id == idBuscado) {
                System.out.println("\n[Resultado en Sala de Espera]");
                System.out.println("Paciente: " + temp.nombre + " - Diagnostico: " + temp.motivo + " - Gravedad: " + temp.gravedad);
                encontrado = true;
                break;
            }
            temp = temp.siguiente;
        }
        if (!encontrado) {
            System.out.println("El ID " + idBuscado + " no esta en la sala de espera.");
        }
    }
}
