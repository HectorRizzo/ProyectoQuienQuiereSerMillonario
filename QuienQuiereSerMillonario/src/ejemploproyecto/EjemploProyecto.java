/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploproyecto;

import clases.Estudiante;
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
 * @author Gladys
 */
public class EjemploProyecto {

    ArrayList<Estudiante> estudiantes;

    public EjemploProyecto() {
        estudiantes = new ArrayList<>();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        EjemploProyecto ej = new EjemploProyecto();
        ej.leerArchivo();
        System.out.println(ej.estudiantes);
        ej.actualizarArchivo();

    }

    /**
     * este metodo lee un archivo y almacena en una lista
     */
    public void leerArchivo() {
        BufferedReader csvReader = null;
        try {           
            String ruta = "src/archivos/CCPG1005-2-2019-2.csv"; //ruta del archivo que se va a leer
            csvReader = new BufferedReader(new FileReader(ruta));
            String fila = csvReader.readLine();//escapar cabecera de archivo
            while ((fila = csvReader.readLine()) != null) { //iterar en el contenido del archivo
                String[] data = fila.split(",");
                estudiantes.add(new Estudiante(data[0], data[1], data[2])); //crear objeto y agregar a lista

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

    /**
     * almacena una lista en un archivo
     */
    public void actualizarArchivo() {
        FileWriter writer = null;
        try {
            String ruta = "src/archivos/CCPG1005-2-2019-2.csv"; //ruta del archivo que se va a leer
            writer = new FileWriter(ruta);
            for (Estudiante est : estudiantes) {
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

}
