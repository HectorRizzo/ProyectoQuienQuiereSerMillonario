/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Scanner;

/**
 *
 * @author Fer Torres
 */
public class MenuPrincipal {
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
           sc.nextLine();
           //Con Switch se proporcionan los diferentes casos que pueden ocurrir y que hacer en caso que se ingrese a cada uno de ellos
           switch(opcion){
             case 1:
               while (opcion !=5){
                 System.out.println("******OPCION 1: CONFIGURACIONES******");
                 System.out.println("1.Administrar terminos academicos");
                 System.out.println("2.Administrar materias y paralelos");
                 System.out.println("3.Administrar estudiantes");
                 System.out.println("4.Administrar preguntas");
                 System.out.println("5.Salir");
                 System.out.println("Seleccione una opcion: ");
                 opcion = sc.nextInt();
                 sc.nextLine();
                            }
                break;
              case 2:
                System.out.println("Nuevo Juego");
                break;
              case 3:
                System.out.println("Reporte");
                break;
              case 4:
                System.out.println("Salir");
                break;
                    }
                    }
                    }
}
