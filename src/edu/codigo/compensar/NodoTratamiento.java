/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.codigo.compensar;

/**
 *
 * @author Casa
 */
public class NodoTratamiento {
    String descripcion;
    NodoTratamiento abajo; // Apunta al tratamiento anterior en la torre

    public NodoTratamiento(String descripcion) {
        this.descripcion = descripcion;
        this.abajo = null;
    }
}
