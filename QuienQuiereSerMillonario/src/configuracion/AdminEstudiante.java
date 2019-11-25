/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import clases.Estudiante;
import clases.Materia;
import clases.Paralelo;
import clases.Termino;
import ejemploproyecto.EjemploProyecto;
import java.io.BufferedReader;
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
 * @author daymo
 */
public class AdminEstudiante {
    private Termino termino;
    private Materia materia;
    private Paralelo paralelo;
    private ArrayList <Estudiante> listaEstudiantes;
    private Estudiante estudiante;
    Scanner sc= new Scanner(System.in);
    
    public AdminEstudiante(ArrayList<Estudiante> listaEstudiantes){
    this.listaEstudiantes = listaEstudiantes;
    }
    public void verEstudiantes() {
                
        System.out.println("******Ver Estudiante´*******");
        sc.nextLine();
        System.out.println("Ingrese el termino(formato:año-numero) : ");
        String ter=sc.nextLine();
        System.out.println("Ingrese el codigo de la materia: ");
        String codMateria=sc.nextLine();
        System.out.println("Ingrese el paralelo: ");
        String par=sc.nextLine();
        ArrayList <Estudiante> listEstudiantes=leerArchivo(codMateria,par,ter);
       for(Estudiante e: listEstudiantes){
           System.out.println("Nombre: "+e.getNombre()+" Matrícula: "+e.getMatricula()+" Correo: "+e.getEmail());
       }
    }
    public void actualizarEstudiante(){
        System.out.println("******Ver Estudiante´*******");
        sc.nextLine();
        System.out.println("Ingrese el termino(formato:año-numero) : ");
        String ter=sc.nextLine();
        System.out.println("Ingrese el codigo de la materia: ");
        String codMateria=sc.nextLine();
        System.out.println("Ingrese el paralelo: ");
        String par=sc.nextLine();
        actualizarArchivo(codMateria,par,ter);
    }
    /**
     * este metodo lee un archivo y almacena en una lista
     * @param materia
     * @param paralelo
     * @param termino
     * @return 
     */
    public ArrayList leerArchivo(String materia,String paralelo, String termino) {
        BufferedReader csvReader = null;
        ArrayList <Estudiante> listaEstudiante= new ArrayList();
        try {                     
            String ruta = "src/archivos/"+materia+"-"+paralelo+"-"+termino+".csv";
            csvReader = new BufferedReader(new FileReader(ruta));
            String fila = csvReader.readLine();//escapar cabecera de archivo
            ArrayList <Estudiante> toAddEstudiante= new ArrayList();

            while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                String[] data = fila.split(",");
                Estudiante est=new Estudiante(data[0],data[1],data[2]);
                toAddEstudiante.add(est); //crear objeto y agregar a lista

            }
            listaEstudiante.addAll(toAddEstudiante);
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
        return listaEstudiante;
    }
    
    
    private void actualizarArchivo(String materia,String paralelo,String termino) {
        FileWriter writer = null;
        try {
            String ruta = "src/archivos/"+materia+"-"+paralelo+"-"+termino+".csv"; //ruta del archivo que se va a leer
            writer = new FileWriter(ruta);
            for (Estudiante est : listaEstudiantes) {
                writer.write(est.getMatricula() + "," + est.getNombre() + "," + est.getEmail() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(EjemploProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(EjemploProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void menuAdminEstudiante(){
        System.out.println("***ADMINISTRAR ESTUDIANTES");
        System.out.println("1) Visualizar lista de estudiantes \n2) Actualizar lista de estudiantes");
        int opcion=sc.nextInt();
        switch(opcion){
            case 1:
                verEstudiantes();
                break;
            case 2:
                //actualizarEstudiante();
                break;
            default:
                break;
        }
    }
    
    
    
    
}
