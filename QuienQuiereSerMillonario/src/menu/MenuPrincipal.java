/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import clases.Materia;
import clases.Paralelo;
import clases.Pregunta;
import clases.Termino;
import configuracion.AdminTermino;
import configuracion.Configuracion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fer Torres
 */
public class MenuPrincipal {
        ArrayList <Termino> listaTermino= new ArrayList();
        ArrayList <Materia>  listaMateria= new ArrayList();
        ArrayList <Paralelo> listaParalelo= new ArrayList();
        ArrayList <Pregunta> listaPreguntas= new ArrayList();
    
   
    //Se crea el menu principal que tendra las opciones principales a escoger al iniciar el juego
    public void menu(){ 


           Scanner sc = new Scanner (System.in);
           int opcion = 1;
           //Se usa un metodo while para que se ejecute el menu mientras la opcion ingresada sea distinta de 4, la cual indica salir del menu
           while (opcion !=4){
           System.out.println("******¿QUIEN QUIERE SER MILLONARIO?******");
           System.out.println("1.Configuraciones");
           System.out.println("2.Nuevo Juego");
           System.out.println("3.Reporte");
           System.out.println("4.Salir");
           System.out.println("Seleccione una opcion: ");
           opcion = sc.nextInt();
           //Con Switch se proporcionan los diferentes casos que pueden ocurrir y que hacer en caso que se ingrese a cada uno de ellos
           switch(opcion){
               
             case 1:
                 //Se crea un objeto de tipo Configuracion para acceder al metodo menu dentro de Configuracion
                 Configuracion b = new Configuracion(listaTermino, listaMateria,listaParalelo, listaPreguntas);
                 b.menu();
                break;
              case 2:
                System.out.println("Nuevo Juego");
                break;
              case 3:System.out.println("****************Reporte*********");
                  System.out.println("Ingrese el termino academico: ");
                  int termino=sc.nextInt();
                  System.out.println("Ingrese codigo de materia: ");
                  String materia=sc.nextLine();
                  System.out.println("Ingrese paralelo: ");
                  int paralelo= sc.nextInt();
                  cargarArchivo();
                  
                  
                break;
              case 4:
                System.out.println("Salir");
                break;
                    }
                    }
                    }
    public void cargarArchivo(){
        File file=null;
        FileReader fr=null;
        BufferedReader br=null;
        try{
            file= new File ("juegosRealizados.txt");
            fr=new FileReader (file);
            br=new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
            
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
}
