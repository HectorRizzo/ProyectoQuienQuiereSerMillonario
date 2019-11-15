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
public class Paralelo {
    private Termino termino;
    private Materia materia;
    private int nun_estudiantes;
    
    private ArrayList<Estudiante> lista_est;

    public Paralelo(){
        
    }
    
    public Paralelo(Termino termino, Materia materia, int nun_estudiantes, ArrayList<Estudiante> lista_est) {
        this.termino = termino;
        this.materia = materia;
        this.nun_estudiantes = nun_estudiantes;
        this.lista_est = lista_est;
    }

    public Termino getTermino() {
        return termino;
    }

    public void setTermino(Termino termino) {
        this.termino = termino;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getNun_estudiantes() {
        return nun_estudiantes;
    }

    public void setNun_estudiantes(int nun_estudiantes) {
        this.nun_estudiantes = nun_estudiantes;
    }

    public ArrayList<Estudiante> getLista_est() {
        return lista_est;
    }

    public void setLista_est(ArrayList<Estudiante> lista_est) {
        this.lista_est = lista_est;
    }

    @Override
    public String toString() {
        return "Paralelo{" + "termino=" + termino + ", materia=" + materia + ", nun_estudiantes=" + nun_estudiantes + ", lista_est=" + lista_est + '}';
    }
    
   /* public void agregarParalelo( Materia materia, Termino termino){
        
    }*/
}
