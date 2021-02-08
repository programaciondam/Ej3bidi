/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3bidi;

import fecha.Fecha;

/**
 *
 * @author 203p21
 */
public class Empleado {
    
    private String nombre;
    private Fecha falta;
    private int categoria;
    private Hijo[] hijos;

    public Empleado(String nombre, Fecha falta, int categoria, int nHijos) {
        this.nombre = nombre;
        this.falta = falta;
        this.categoria = categoria;
        hijos = new Hijo[nHijos];
    }
    
    public Empleado(){
    }
    
    public void guardar(String nombre, Fecha falta, int categoria, int nHijos) {
        this.nombre = nombre;
        this.falta = falta;
        this.categoria = categoria;
        hijos = new Hijo[nHijos];
    }

    public void setHijos(Hijo[] hijos) {
        this.hijos = hijos;
    }
    
     public void set1Hijos(Hijo hijos, int pos) {
        this.hijos[pos] = hijos;
    }
     
      public void set1Hijos(boolean ingr, Fecha fnac, int pos) {
        this.hijos[pos] = new Hijo(fnac,ingr);
    }

    public Hijo[] getHijos() {
        return hijos;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFalta() {
        return falta;
    }

    public int getCategoria() {
        return categoria;
    }
    
    public int hijosComputables(){
        int nHC = 0;
        for(Hijo hijo : hijos) { //for each
            if (hijo.esComputable()) {
                nHC++;
            }
        }
        return nHC;
    }
    
}
