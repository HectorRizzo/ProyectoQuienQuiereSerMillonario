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
    static    ArrayList <Pregunta> listaPreguntas= new ArrayList();
        Termino terminoSeleccionado = null;
        ArrayList<Estudiante> listaEstudiantes= new ArrayList();
        Configuracion b= null;

    
   
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
                 if (b==null){
                     b = new Configuracion(listaTermino, listaMateria,listaParalelo, listaPreguntas, listaEstudiantes);
                 }               

                 b.menu();
                 this.terminoSeleccionado=b.getTerminoSeleccionado();
                break;
              case 2:
                  System.out.println("\n****IMPORTANTE****\n Asegurese de que esté configurada las materias, paralelos y exista un término establecido\n");
                  if(this.terminoSeleccionado==null){
                      System.out.println("No existe termino seleccionado"); //No me permite acceder a la opción si no hay un termino
                  }else{
                      if(this.b==null){
                          System.out.println("Tiene que primero ingresar a la opcion 1");
                      }
                      else{
                          if(this.b.getPreguntas()==null){
                              System.out.println("Tiene que ir al Administrar de preguntas");
                          }
                          else{
                              System.out.println("****************Nuevo Juego*********");
                                Materia materiaObjeto = null; 
                                while(materiaObjeto==null){
                                    System.out.println("Ingrese codigo de la materia: "); //Se pide por consola el codigo de la materia
                                    String codMateria = sc.next();
                                    materiaObjeto=filtrarCodigoMateria(codMateria); //se filtra en la lista de materias hasta encontrar la primera incidencia
                                }
                                Paralelo paraleloObjeto = null;
                                while(paraleloObjeto==null){
                                    System.out.println("Ingrese número de paralelo: ");//se pide por consola el codigo del paralelo (numero)
                                    int codParalelo = sc.nextInt();
                                    paraleloObjeto=filtrarCodigoParalelo(codParalelo);// se filtra en la lista de paralelos hasta encontrar la primera incidencia
                                }
                                System.out.println("Ingrese número de nivel: ");//se pide el numero de nivel
                                int numNivel = sc.nextInt();
                                System.out.println("Ingrese matricula de estudiante(opcional: si se escribe 'aleatorio' se escoje un estudiante aleatorio): ");//Se pide por consola la matricula del estudiante
                                String matEstudiante = filtrarMatriculaEstudiante(paraleloObjeto,sc.next()); //se filtra hasta encontrar la primera incidencia
                                NuevoJuego nuevoJuego = new NuevoJuego(materiaObjeto,paraleloObjeto,numNivel,matEstudiante); //se crea un Nuevo Juego
                                System.out.println("Ingrese matricula de estudiante como compañero: ");//Se pide ingresar la matricula del quien sera compañero del participante
                                String matEstudianteCompañero = matEstudiante;
                                while(matEstudianteCompañero.equals(matEstudiante)){
                                    matEstudianteCompañero = filtrarMatriculaEstudiante(paraleloObjeto,sc.next());//Se filtra hasta encontrar al estudiante compañero
                                }
                                nuevoJuego.setCompañero(matEstudianteCompañero); //se asigna al compañero al nuevo juego
                                nuevoJuego.setPreguntas(listaPreguntas); //se setea la lista de preguntas
                                System.out.println("Presione una tecla para continuar");
                                String avanzar = sc.next();
                                nuevoJuego.iniciar(); //se inicia el nuevo juego
                          }
                      }
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
    private Materia filtrarCodigoMateria(String codigo){//metodo para filtrar materias
        for(Materia materia: this.listaMateria){
            if(materia.getCodigo().equals(codigo)){
                return materia;
            }
        }
        return null;
    }
    
    private Paralelo filtrarCodigoParalelo(int codigo){//metodo para filtrar paralelos
        for(Paralelo paralelo: this.listaParalelo){
            if(Integer.parseInt(paralelo.getNum_paralelo())==codigo){
                return paralelo;
            }
        }
        return null;
    }
    
    private String filtrarMatriculaEstudiante(Paralelo paralelo, String codigo){//metodo para filtrar estudiantes
        if ("aleatorio".equals(codigo) || codigo==null){
            int aleatorio = new Random().nextInt(paralelo.getNun_estudiantes());
            return paralelo.getLista_est().get(aleatorio).getMatricula();
        }
        for(Estudiante estudiante: paralelo.getLista_est()){
            if(estudiante.getMatricula().equals(codigo)){
                return codigo;
            }
        }
        return null;
    }
}
