/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import configuracion.AdminTermino;
import configuracion.Configuracion;
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
           //Con Switch se proporcionan los diferentes casos que pueden ocurrir y que hacer en caso que se ingrese a cada uno de ellos
           switch(opcion){
               
             case 1:
                 //Se crea un objeto de tipo Configuracion para acceder al metodo menu dentro de Configuracion
                 Configuracion b = new Configuracion();
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
                  
                  
                break;
              case 4:
                System.out.println("Salir");
                break;
                    }
                    }
                    }
}
