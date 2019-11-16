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
    int opcion =sc.nextInt();

    /**
     *
     */
    public void menu() {
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
