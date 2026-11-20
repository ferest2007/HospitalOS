/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.codigo.compensar;

/**
 *
 * @author jesus
 */
public class Nodo {
    String nombre;
    int id;
    String motivo;
    int gravedad; // Funciona como Triage
    PilaTratamientos historial; // Subestructura enlazada interna
    Nodo siguiente;

    public Nodo(String nombre, int id, String motivo, int gravedad) {
        this.nombre = nombre;
        this.id = id;
        this.motivo = motivo;
        this.gravedad = gravedad;
        this.historial = new PilaTratamientos(); // Cada paciente nace con su pila limpia
        this.siguiente = null;
    }
}

