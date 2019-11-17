/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Daniel Zurita
 */
public class Pregunta {
    private String enunciado;
    private int nivel;
    private String resp_Correcta;
    private ArrayList<String> posibles_resp;

    //POSIBLES RESPUESTA NO LA PUSE COMO ARGUMENTO DEL CONSRTRUCTOR
    public Pregunta(String enunciado, int nivel, String resp_Correcta) {
        this.enunciado = enunciado;
        this.nivel = nivel;
        this.resp_Correcta = resp_Correcta;
    }

    /**Constructor con posibles respuestas
     *
     * @param enunciado
     * @param nivel
     * @param resp_Correcta
     * @param posResp1
     * @param posResp2
     * @param posResp3
     */
    public Pregunta(String enunciado, int nivel, String resp_Correcta, String posResp1, String posResp2,String posResp3) {
        this.enunciado = enunciado;
        this.nivel = nivel;
        this.resp_Correcta = resp_Correcta;
        posibles_resp.add(posResp1);
        posibles_resp.add(posResp2);
        posibles_resp.add(posResp3);
        
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getResp_Correcta() {
        return resp_Correcta;
    }

    public void setResp_Correcta(String resp_Correcta) {
        this.resp_Correcta = resp_Correcta;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "enunciado=" + enunciado + ", nivel=" + nivel + ", resp_Correcta=" + resp_Correcta + '}';
    }
    
    /*public ArrayList<Pregunta> visualizarPreguntas (String codMateria){
        
    }*/
}
