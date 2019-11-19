/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import clases.Termino;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daymo
 */
public class AdminTermino {
    Scanner sc= new Scanner(System.in);
    ArrayList <Termino> listaTermino=new ArrayList();
    //En esta opción se solicitará un objeto tipo Termino
    public void ingresarTermino(int anio, int numTermino){
        Termino ter= new Termino(anio,numTermino);
        listaTermino.add(ter);
        
    }
    
    //Esta opcion eliminará un objeto termino de la lista
    public void eliminarTermino(){
        System.out.println(listaTermino);
        System.out.println("Cual termino desea eliminar? \nIngrese el año y el numero en este formato: año-numero");
        String opcion=sc.nextLine();
        String[] partes=opcion.split("-");
        int[] cadena={Integer.parseInt(partes[0],Integer.parseInt(partes[1]))};
        for(Termino h: listaTermino){
            if(h.getAnio()==cadena[0]&&h.getNumTermino()==cadena[1]){
                listaTermino.remove(h);
            }
        }
    }
    public Termino setTermino(){
        Termino termino = null;
        System.out.println("Escoja el termino: ");
        System.out.println(listaTermino);
        String opcion=sc.nextLine();
        String[] partes=opcion.split("-");
        int[] cadena={Integer.parseInt(partes[0],Integer.parseInt(partes[1]))};
        for(Termino h: listaTermino){
            if(h.getAnio()==cadena[0]&& h.getNumTermino()==cadena[1]){
                termino=h;
            }
        }
        return termino;
    }
    //menu de termino
    public void menuTermino(){
        System.out.println("Administrar Termino Academico");
        System.out.println("1.- Ingresar término\n 2.- Eliminar término\n 3.- Configurar término para el juego");
        int opcionMenu=sc.nextInt();
        switch(opcionMenu){
            case 1:
                System.out.println("Ingrese el año:");
                int anio= sc.nextInt();
                System.out.println("Ingrese el número de término:");
                int numTermino= sc.nextInt();
                ingresarTermino(anio,numTermino);
                break;
            case 2:
                eliminarTermino();
            case 3:
                setTermino();
        }
        
        
    }
}

