/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import clases.Materia;
import clases.Paralelo;
import clases.Pregunta;
import clases.Termino;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author daymor
 */
public class AdmPreguntas extends AdminMateria_Paralelo {
    private ArrayList <Pregunta> listaPreguntas;
    /*private ArrayList <Materia> listaMateria;
    private ArrayList <Paralelo> listaParalelo;*/
    //Constructor

    
    public AdmPreguntas(ArrayList<Pregunta> listaPreguntas, ArrayList<Materia> listaMateria, ArrayList<Paralelo> lista_paralelo, ArrayList <Termino> listaTermino) {
        super(listaMateria, lista_paralelo, listaTermino);
        
        this.listaPreguntas = listaPreguntas;
        setearPreguntas();
    }
    
    private void setearPreguntas(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("/archivos/preguntasPOO.csv"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdmPreguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = 0;
        Materia materia = new Materia("POO","Programacion Orientada a Objetos", 3,true);
        while(scanner.hasNext()){
            if(i!=0){
                String line = scanner.next();
                String[] tokens = line.split(";");
                this.listaPreguntas.add(new Pregunta(materia,tokens[0],Integer.parseInt(tokens[1]),tokens[2],tokens[3],tokens[4],tokens[5]));
            }
            i++;
        }
        scanner.close();
    }

    //Agrega pregunta
    /**
     *
     * @param cod
     */
    public void addPregunta(String cod) {
        for(Materia i:getListaMateria()){
            if(i.getCodigo().equals(cod)){
                System.out.println("Numero de niveles posibles: "+ i.getNivel());
                System.out.println("Ingrese el enunciado: ");
                String enunciado=sc.nextLine();
              
                System.out.println("Ingrese el nivel : ");
                int nivel=sc.nextInt();
                
                while(1 > nivel || nivel>i.getNivel()){
                    System.out.println("Ingrese el nivel correcto (mayor que 0 y menor o igual que el numero posible");
                    nivel=sc.nextInt();
                }
                System.out.println("Ingrese la respuesta correcta: ");
                sc.nextLine();
                String respCorrecta=sc.nextLine();
                
                System.out.println("Ingrese la 1° posible respuesta: ");
                String posRespuesta1=sc.nextLine();
                System.out.println("Ingrese la 2° posible respuesta: ");
                String posRespuesta2=sc.nextLine();
                System.out.println("Ingrese la 3° posible respuesta: ");
                String posRespuesta3=sc.nextLine();
                Pregunta pregunta=new Pregunta(i,enunciado,nivel,respCorrecta,posRespuesta1,posRespuesta2,posRespuesta3);
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
        ArrayList <Pregunta> preguntasToWatch=new ArrayList();
        for(Pregunta p:listaPreguntas){
            if((p.getMateria().getCodigo()).equals(codMateria)){
                preguntasToWatch.add(p);
            } else {
            }
        }
        System.out.println(preguntasToWatch);     
    }
    //elimina pregunta
    public void eliminarPregunta(){
        int i=1;
        for(Pregunta p: listaPreguntas){
            System.out.println(i+ ") "+"Materia: "+p.getMateria().getNombre()+" ,Nivel: "+p.getNivel()+" , Enunciado: "+p.getEnunciado());
            i++;
        }
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
        switch(opcionPreg){
            case 1:
                System.out.println("Visualizar preguntas");
                System.out.println("Ingrese el codigo de una materia: ");
                sc.nextLine();
                String codMateria=sc.nextLine();
                verPregunta(codMateria);
                break;
            case 2:
                System.out.println("Agregar Pregunta");
                System.out.println("Ingrese el codigo de la materia: ");
                sc.nextLine();
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

