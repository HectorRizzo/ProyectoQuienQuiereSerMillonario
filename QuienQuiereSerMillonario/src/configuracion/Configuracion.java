/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import java.util.Scanner;

/**
 *
 * @author daymo
 */
public class Configuracion {
    Scanner sc= new Scanner(System.in);
    

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
                AdminTermino termino= new AdminTermino();
                termino.menuTermino();
                break;
            case 2: 
                AdminMateria_Paralelo adminMatPar= new AdminMateria_Paralelo();
                adminMatPar.menuAdminMateria();
                break;
            case 3:
                System.out.println("Administrar Estudiantes");
                break;
            case 4:
                AdmPreguntas preguntas= new AdmPreguntas();
                preguntas.menuAdminPreguntas();
                break;
                
        }
    }
    
}
