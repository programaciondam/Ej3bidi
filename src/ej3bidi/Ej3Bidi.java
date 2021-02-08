/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3bidi;

import numeros.Numero;

/**
 *
 * @author 203p21
 */
public class Ej3Bidi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ntra;
        ntra = Numero.pedirNumeroEntero("Numero de trabajadores de la empresa:", 0, Integer.MAX_VALUE);
        Empresa miEmpresa = new Empresa(ntra);
        miEmpresa.pedirDatos();
        miEmpresa.pedirHijos();
        miEmpresa.informe();
    }
    
}
