/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import constantes.Constantes;
import interfaces.Comodin;
import java.util.Random;

/**
 *
 * @author Feer
 */
public class FiftyFifty implements Comodin {
    
    private boolean usado;
    private Pregunta pregunta;

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public FiftyFifty(Pregunta pregunta) {
        this.pregunta = pregunta;
        usado = false;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
    
    @Override
    public void accion() {
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
