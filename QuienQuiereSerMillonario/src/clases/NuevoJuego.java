/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import configuracion.AdminTermino;
import java.util.ArrayList;

/**
 *
 * @author Daniel Zurita
 */
public class NuevoJuego {
    
    private Materia materia;
    private Paralelo paralelo;
    private int numeroPreguntaNivel;
    private Estudiante participante=null;

    public NuevoJuego(Materia materia, Paralelo paralelo, int numeroPreguntaNivel,String busqueda) {
        this.materia = materia;
        this.paralelo = paralelo;
        this.numeroPreguntaNivel = numeroPreguntaNivel;
        seleccionarEstudiante(busqueda);
    }
    public void seleccionarEstudiante(String busqueda){
        for(Estudiante estudiante: this.paralelo.getLista_est()){
            if (estudiante.getMatricula().equals(busqueda)) participante=estudiante;
        }    
    }
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Paralelo getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public int getNumeroPreguntaNivel() {
        return numeroPreguntaNivel;
    }

    public void setNumeroPreguntaNivel(int numeroPreguntaNivel) {
        this.numeroPreguntaNivel = numeroPreguntaNivel;
    }

    public Estudiante getParticipante() {
        return participante;
    }

    public void setParticipante(Estudiante participante) {
        this.participante = participante;
    }
    
    public void iniciar(){
        
    }
}
