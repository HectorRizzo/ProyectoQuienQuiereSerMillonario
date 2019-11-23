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
    ArrayList <Termino> listaTermino;//inicializando
    //En esta opción se solicitará un objeto tipo Termino
    
    public AdminTermino(ArrayList <Termino> listaTermino) {
        this.listaTermino = listaTermino;
    }
    
    public void ingresarTermino(int anio, int numTermino){
        Termino ter= new Termino(anio,numTermino);
        listaTermino.add(ter);
        
        
        
        
    }
    //metodo para mostrar los terminos ingresados al invocar el metodo principal de termino
    public void mostrarTerminos(){
        int i=1;
        for( Termino t: listaTermino){
            System.out.println(i+": "+ t);
            i++;
        }              
    }
    
    //Esta opcion eliminará un objeto termino de la lista
    public void eliminarTermino(){
        mostrarTerminos();
        sc.nextLine();
        System.out.println("Cual termino desea eliminar? \nIngrese el año y el numero en este formato: año-numero");
        String opcion=sc.nextLine();
        String[] partes=opcion.split("-");
        ArrayList <Integer> cadena=new ArrayList();
        cadena.add(Integer.parseInt(partes[0]));
        cadena.add(Integer.parseInt(partes[1]));
        ArrayList <Termino> toRemove= new ArrayList();
        for(Termino h: listaTermino){
            if(h.getAnio()==cadena.get(0)&&h.getNumTermino()==cadena.get(1)){
                toRemove.add(h);
            }
        }listaTermino.removeAll(toRemove);
    }
    public Termino setTermino(){
        Termino termino = null;
        System.out.println("Escoja el numeral del termino: ");
        mostrarTerminos();      
        int opcion=sc.nextInt();
        for(Termino h: listaTermino){
            if(h==listaTermino.get(opcion-1)){
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
                mostrarTerminos();
                break;
            case 2:
                eliminarTermino();
                break;
            case 3:

                setTermino();

                break;
        }
        
        
    }
}

