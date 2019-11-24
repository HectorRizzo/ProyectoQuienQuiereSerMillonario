/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import clases.Estudiante;
import clases.Materia;
import clases.Paralelo;
import clases.Pregunta;
import clases.Termino;
import ejemploproyecto.EjemploProyecto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    //añade las preguntas del archivo
    private void setearPreguntas(){
        BufferedReader csvReader = null;
       
        try {                     
            String ruta = "src/archivos/preguntasPOO.csv";
            csvReader = new BufferedReader(new FileReader(ruta));
            String fila = csvReader.readLine();//escapar cabecera de archivo
            Materia mat=new Materia();
            for (Materia m: listaMateria){
                if(m.getNombre().equals("POO")){
                    mat=m;
                    
                }
            }

            while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                String[] data = fila.split(";");
                Pregunta preg=new Pregunta(mat,data[0],Integer.parseInt(data[1]),data[2],data[3],data[4],data[5]);
                listaPreguntas.add(preg); //crear objeto y agregar a lista

            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjemploProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjemploProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                csvReader.close();
            } catch (IOException ex) {
                Logger.getLogger(EjemploProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
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
        int i=1;
        for (Pregunta p: preguntasToWatch){
            System.out.println(i+") Enunciado: "+ p.getEnunciado()+ " , Nivel: "+p.getNivel()+" , Respuesta Correcta: "+ p.getResp_Correcta());
            System.out.println("Posibles Respuestas: "+ p.getPosibles_resp());
            System.out.println("");
            i++;
        }
        
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

