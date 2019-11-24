/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.Comodin;
import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author Feer
 */
public class ConsultaCompañero implements Comodin {
    
    private Estudiante compañero;

    public ConsultaCompañero(Estudiante compañero) {
        this.compañero = compañero;
    }

    public Estudiante getCompañero() {
        return compañero;
    }

    public void setCompañero(Estudiante compañero) {
        this.compañero = compañero;
    }
    
    @Override
    public void accion(){
        System.out.println("Yo "+this.compañero.getNombre()+" voy a ayudarte");
        int respuestaInteger = new Random().nextInt(4);
        switch(respuestaInteger){
            case 1:
                System.out.println("Escoge la opción A");
                break;
            case 2:
                System.out.println("Escoge la opción B");
                break;
            case 3:
                System.out.println("Escoge la opción C");
                break;
            default:
                System.out.println("Escoge la opción D");
                break;
        }       
    }
}
