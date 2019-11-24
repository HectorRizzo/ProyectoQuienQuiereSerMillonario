/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import asbtractos.Comodin;
import constantes.Constantes;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author Feer
 */
public class ConsultaCompañero extends Comodin {
    
    private Estudiante compañero; //comodin que depende del compañero del participante

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
    public void accion(){ //metodo que devuelve una respuesta sugerida por el compañero
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
    
    public String toString(){
        return Constantes.consultaCompañero;
    }
}
