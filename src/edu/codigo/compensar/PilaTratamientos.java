/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.codigo.compensar;

/**
 *
 * @author Casa
 */
public class PilaTratamientos {
    NodoTratamiento tope; // El procedimiento mas reciente

    public PilaTratamientos() {
        this.tope = null;
    }

    // Insertar un tratamiento (Push)
    public void push(String descripcion) {
        NodoTratamiento nuevo = new NodoTratamiento(descripcion);
        if (tope != null) {
            nuevo.abajo = tope;
        }
        tope = nuevo;
    }

    // Mostrar el historial completo desde el ultimo al primero
    public void mostrarHistorial() {
        if (tope == null) {
            System.out.println("No se han registrado tratamientos aun.");
            return;
        }
        NodoTratamiento temp = tope;
        int cont = 1;
        while (temp != null) {
            System.out.println(cont + ". " + temp.descripcion);
            temp = temp.abajo;
            cont++;
        }
    }
}
