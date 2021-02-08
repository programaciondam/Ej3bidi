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
public class Hijo {
    
    private Fecha fnac;
    private boolean ingresos;

    public Hijo(Fecha fnac, boolean ingresos) {
        this.fnac = fnac;
        this.ingresos = ingresos;
    }

    public Fecha getFnac() {
        return fnac;
    }

    public boolean isIngresos() {
        return ingresos;
    }
    
    public boolean esComputable(){
        boolean resultado = false;
        if(!isIngresos() && fnac.calculoNAnos()<25)
            resultado = true;
        return resultado;
    }
}
