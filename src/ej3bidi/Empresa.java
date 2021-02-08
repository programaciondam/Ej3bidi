/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3bidi;

import fecha.Fecha;
import java.util.Arrays;
import numeros.Numero;

/**
 *
 * @author 203p21
 */
public class Empresa {
    private Empleado[] empleados;
    private Categoria[] categorias;
    private float[] limites;
    private float[][] irpf;

    public Empresa(int ntra){
        empleados = new Empleado[ntra];
        categorias = new Categoria[]{new Categoria("Administrativo",1000f),
            new Categoria("Programador",1200f),
            new Categoria("Analista",1500f),
            new Categoria("Analista Programador",1800f),
            new Categoria("Jefe Junior",2100f),
            new Categoria("Jefe Senior",2200f)};
        limites = new float[]{1000f,1300f,1600f,2000f,2100f};
        irpf = new float[][]{{0.08f,0.1f,0.16f,0.21f,0.3f},
            {0.06f,0.08f,0.14f,0.19f,0.25f},
            {0.04f,0.05f,0.12f,0.17f,0.21f},
            {0.03f,0.04f,0.1f,0.15f,0.2f}};
    }
    
    public void pedirDatos(){
        String nombre;
        int categoria;
        Fecha falta;
        int nHijos;
        
        for(int pos = 0; pos<empleados.length; pos++){
            nombre = Numero.pedirString("Nombre del trabajador:");
            falta = Numero.pedirFecha("Introduce la fecha de alta:");
            visualizarCategorias();
            categoria = Numero.pedirNumeroEntero("Introduce la categoria:", 0, categorias.length-1);
            nHijos = Numero.pedirNumeroEntero("Introduce el numero de hijos:", 0, Integer.MAX_VALUE);
            empleados[pos] = new Empleado(nombre, falta, categoria, nHijos);
            
        }
    }
    
    public void visualizarCategorias(){
        for(Categoria c : categorias){
            System.out.println(c.getNombre() + "\n");
        }
    }
    
    public void pedirHijos(){
        Fecha fnac = null;
        boolean ingr = false;
        for(int pos = 0; pos < empleados.length; pos++){
            System.out.println("Hijos de "+empleados[pos].getNombre());
            for(int posHijo = 0; posHijo < empleados[pos].getHijos().length; posHijo++){
                fnac = Numero.pedirFecha("Dame la fecha de nacimiento del hijo "+posHijo+1);
                if(Numero.pedirNumeroEntero("¿Tiene ingresos? Si(0)/No(1)", 0, 1)==0)
                    ingr = true;
                else
                    ingr = false;
                empleados[pos].set1Hijos(ingr, fnac, posHijo);
            }
        }
    }
    
    public void informe(){
        int fila;
        int columna;
        
        System.out.println("Informe anual");
        System.out.println("Nombre\t Fecha de alta\t Nº de hijos\t Categoria\t Sueldo base\t IRPF\t Sueldo neto");
        
        for(int pos = 0; pos < empleados.length; pos++){
            System.out.print(empleados[pos].getNombre()+"\t");
            System.out.print(empleados[pos].getFalta().visualizar()+"\t");
            System.out.print(empleados[pos].hijosComputables()+"\t");
            System.out.print(categorias[empleados[pos].getCategoria()].getNombre()+"\t");
            System.out.print(categorias[empleados[pos].getCategoria()].getSbase()+"\t");
            if(empleados[pos].hijosComputables()<irpf.length)
                fila = empleados[pos].hijosComputables();
            else
                fila = irpf.length-1;
            columna=Arrays.binarySearch(limites,categorias[empleados[pos].getCategoria()].getSbase() );
           // columna = buscar(categorias[empleados[pos].getCategoria()].getSbase());
            System.out.print(irpf[fila][columna]+"\t");
            float sueldoNeto = categorias[empleados[pos].getCategoria()].getSbase() * (1-irpf[fila][columna]);
            System.out.println(sueldoNeto);
        }
    }
    
    public int buscar(float sueldoBase){
        boolean resultado = false;
        int pos = 0;
        do{
            if(sueldoBase<limites[pos]){
                resultado = true;
            }else
                pos++;
        }while(!resultado&&pos<limites.length);
        return pos;
    }
}
