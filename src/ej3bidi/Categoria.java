/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3bidi;

/**
 *
 * @author 203p21
 */
public class Categoria {
    
    private String nombre;
    private float sbase;

    public Categoria(String nombre, float sbase) {
        this.nombre = nombre;
        this.sbase = sbase;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSbase() {
        return sbase;
    }
    
}
