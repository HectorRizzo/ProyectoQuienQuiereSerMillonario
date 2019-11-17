/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import clases.Materia;
import clases.Pregunta;
import java.util.ArrayList;


/**
 *
 * @author daymor
 */
public class AdmPreguntas extends AdminMateria_Paralelo {
    private ArrayList <Pregunta> listaPreguntas;
    
    //Constructor
    public AdmPreguntas(){
        listaPreguntas=new ArrayList<>();
    }
    //Agrega pregunta
    /**
     *
     * @param cod
     */
    public void addPregunta(String cod){
        for(Materia i:getListaMateria()){
            if(i.getCodigo().equals(cod)){
                System.out.println("Numero de niveles: "+ i.getNivel());
                System.out.println("Ingrese el enunciado: ");
                String enunciado=sc.nextLine();
                int nivel=0;
                do{
                    System.out.println("Ingrese el nivel: ");
                    nivel=sc.nextInt();
                    sc.next();
                }while(1 > nivel || nivel>i.getNivel());
                System.out.println("Ingrese la respuesta correcta: ");
                String respCorrecta=sc.nextLine();
                System.out.println("Ingrese la 1 posible respuesta: ");
                String posRespuesta1=sc.nextLine();
                System.out.println("Ingrese la 2 posible respuesta: ");
                String posRespuesta2=sc.nextLine();
                System.out.println("Ingrese la 3 posible respuesta: ");
                String posRespuesta3=sc.nextLine();
                Pregunta pregunta=new Pregunta(enunciado,nivel,respCorrecta,posRespuesta1,posRespuesta2,posRespuesta3);
                listaPreguntas.add(pregunta);
                
            }   
        }
    }
    
    
    //ve las preguntas
    /**
     *
     * @param codMateria
     */
    public void verPregunta(String codMateria){
        //falta relacionar las preguntas con una materia
        System.out.println(listaPreguntas);     
    }
    //elimina pregunta
    public void eliminarPregunta(){
        System.out.println(listaPreguntas);
        System.out.println("Que pregunta desea eliminar?\n Ingrese la posición de la pregunta: ");
        int pos=sc.nextInt();
        listaPreguntas.remove(listaPreguntas.get(pos-1));
    }
    //menú de administrar preguntas
    public void menuAdminPreguntas(){
        System.out.println("Administrar Preguntas");
        System.out.println("1.- Visualizar preguntas\n 2.- Agregar pregunta\n 3.- Eliminar pregunta");
        System.out.println("Ingrese su opción: ");
        int opcionPreg=sc.nextInt();
        sc.next();
        switch(opcionPreg){
            case 1:
                System.out.println("Visualizar preguntas");
                System.out.println("Ingrese el codigo de una materia: ");
                String codMateria=sc.nextLine();
                verPregunta(codMateria);
                break;
            case 2:
                System.out.println("Agregar Pregunta");
                System.out.println("Ingrese el codigo de la materia: ");
                String codigoMateria= sc.nextLine();
                addPregunta(codigoMateria);
                break;
            case 3:
                System.out.println("Eliminar Pregunta");
                eliminarPregunta();
                break;
        }
        
        
    }
}

