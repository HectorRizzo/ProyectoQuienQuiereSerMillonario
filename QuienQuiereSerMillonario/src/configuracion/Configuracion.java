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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daymo
 */
public class Configuracion {
    Scanner sc= new Scanner(System.in);
    ArrayList <Termino> listaTermino;
    ArrayList <Materia>  listaMateria;
    ArrayList <Paralelo> listaParalelo;
    ArrayList <Pregunta> listaPreguntas;
    Termino terminoSeleccionado;
    ArrayList <Estudiante> listaEstudiante;
    AdmPreguntas preguntas=null;

    public Configuracion(ArrayList<Termino> listaTermino, ArrayList<Materia> listaMateria, ArrayList<Paralelo> listaParalelo, ArrayList<Pregunta> listaPreguntas, ArrayList <Estudiante> listaEstudiantes) {
        this.listaTermino = listaTermino;
        this.listaMateria = listaMateria;
        this.listaParalelo = listaParalelo;
        this.listaPreguntas = listaPreguntas;
        this.listaEstudiante= listaEstudiante;

    }

    public Termino getTerminoSeleccionado() {
        return terminoSeleccionado;
    }

    public void setTerminoSeleccionado(Termino terminoSeleccionado) {
        this.terminoSeleccionado = terminoSeleccionado;
    }

    public AdmPreguntas getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(AdmPreguntas preguntas) {
        this.preguntas = preguntas;
    }

    
    
    /**
     *
     */
    public void menu() {
        //Se pone el menu configuraciones
        System.out.println("******OPCION 1: CONFIGURACIONES******");
        System.out.println("1.Administrar terminos academicos");
        System.out.println("2.Administrar materias y paralelos");
        System.out.println("3.Administrar estudiantes");
        System.out.println("4.Administrar preguntas");
        System.out.println("5.Salir");
        System.out.println("Seleccione una opcion: ");
        int opcion = sc.nextInt();      
        switch (opcion){
            case 1:
                AdminTermino termino= new AdminTermino(listaTermino);
                termino.menuTermino();
                this.terminoSeleccionado=termino.getTerminoSeleccionado();
                break;
            case 2: 

                AdminMateria_Paralelo adminMatPar= new AdminMateria_Paralelo(listaMateria,listaParalelo, listaTermino);

                adminMatPar.menuAdminMateria();
                break;
            case 3:
                AdminEstudiante adminEstudiante= new AdminEstudiante(listaEstudiante);
                adminEstudiante.menuAdminEstudiante();
                break;
            case 4:

                preguntas= new AdmPreguntas(listaPreguntas,listaMateria,listaParalelo,listaTermino);

                

                preguntas.menuAdminPreguntas();
                break;
                
        }
    }
    
}
