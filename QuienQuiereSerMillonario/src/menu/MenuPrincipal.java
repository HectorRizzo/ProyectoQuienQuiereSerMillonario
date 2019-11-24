/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;


import clases.Estudiante;
import clases.Materia;
import clases.NuevoJuego;
import clases.Paralelo;
import clases.Pregunta;
import clases.Termino;

import configuracion.Configuracion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
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
        Termino terminoSeleccionado = null;
        ArrayList<Estudiante> listaEstudiantes= new ArrayList();


    
   
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

                 Configuracion b = new Configuracion(listaTermino, listaMateria,listaParalelo, listaPreguntas, listaEstudiantes);

                 b.menu();
                 this.terminoSeleccionado=b.getTerminoSeleccionado();
                break;
              case 2:
                  if(this.terminoSeleccionado==null){
                      System.out.println("No existe termino seleccionado");
                  }else{
                      System.out.println("****************Nuevo Juego*********");
                        Materia materiaObjeto = null;
                        while(materiaObjeto==null){
                            System.out.println("Ingrese codigo de la materia: ");
                            String codMateria = sc.next();
                            materiaObjeto=filtrarCodigoMateria(codMateria);
                        }
                        Paralelo paraleloObjeto = null;
                        while(paraleloObjeto==null){
                            System.out.println("Ingrese número de paralelo: ");
                            int codParalelo = sc.nextInt();
                            paraleloObjeto=filtrarCodigoParalelo(codParalelo);
                        }
                        System.out.println("Ingrese número de nivel: ");
                        int numNivel = sc.nextInt();
                        System.out.println("Ingrese matricula de estudiante: ");
                        String matEstudiante = filtrarMatriculaEstudiante(paraleloObjeto,sc.next());
                        NuevoJuego nuevoJuego = new NuevoJuego(materiaObjeto,paraleloObjeto,numNivel,matEstudiante);
                        System.out.println("Ingrese matricula de estudiante como compañero: ");
                        String matEstudianteCompañero = matEstudiante;
                        while(matEstudianteCompañero.equals(matEstudiante)){
                            matEstudianteCompañero = filtrarMatriculaEstudiante(paraleloObjeto,sc.next());
                        }
                        nuevoJuego.setCompañero(matEstudianteCompañero);
                        nuevoJuego.setPreguntas(listaPreguntas);
                        nuevoJuego.iniciar();
                  }
                  
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
    private Materia filtrarCodigoMateria(String codigo){
        for(Materia materia: this.listaMateria){
            if(materia.getCodigo().equals(codigo)){
                return materia;
            }
        }
        return null;
    }
    
    private Paralelo filtrarCodigoParalelo(int codigo){
        for(Paralelo paralelo: this.listaParalelo){
            if(paralelo.getNum_paralelo()==codigo){
                return paralelo;
            }
        }
        return null;
    }
    
    private String filtrarMatriculaEstudiante(Paralelo paralelo, String codigo){
        for(Estudiante estudiante: paralelo.getLista_est()){
            if(estudiante.getMatricula().equals(codigo)){
                return codigo;
            }
        }
        int aleatorio = new Random().nextInt(paralelo.getNun_estudiantes());
        return paralelo.getLista_est().get(aleatorio).getMatricula();
    }
}
