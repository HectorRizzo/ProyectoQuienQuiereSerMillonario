/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import asbtractos.Comodin;
import constantes.Constantes;

import java.util.Random;

/**
 *
 * @author Feer
 */
public class FiftyFifty extends Comodin {
    
    private Pregunta pregunta; //comodin que depende de la pregunta

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public FiftyFifty(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    
    @Override
    public void accion() {//metodo que descarta 2 opciones malas y deja solo 1 posible respuesta y su respuesta
        int eleccion = new Random().nextInt(3);
        int orden = new Random().nextInt(2);
        StringBuilder sb = new StringBuilder("Las posibles respuestas pueden ser:");
        if (orden==0) {
            sb.append(this.pregunta.getResp_Correcta());
            sb.append(" o ");
            sb.append(this.pregunta.getPosibles_resp().get(eleccion));
        }
        else{
            sb.append(this.pregunta.getPosibles_resp().get(eleccion));
            sb.append(" o ");
            sb.append(this.pregunta.getResp_Correcta());
        }
        System.out.println(sb);
    }
    
    @Override
    public String toString(){
        return Constantes.fiftyFifty;
    }
    
}
