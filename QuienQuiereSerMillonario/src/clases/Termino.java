/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Daniel Zurita
 */
public class Termino {
    private int anio;
    private Termino termino;
    private int numTermino;
//Constructor con numero de termino, que creo que es lo que se necesita.
    public Termino(int anio, int numTermino) {
        this.anio = anio;
        this.numTermino = numTermino;
    }

    
    
    public Termino(int anio, Termino termino) {
        this.anio = anio;
        this.termino = termino;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Termino getTermino() {
        return termino;
    }

    public void setTermino(Termino termino) {
        this.termino = termino;
    }
    public int getNumTermino() {
        return numTermino;
    }

    public void setNumTermino(int numTermino) {
        this.numTermino = numTermino;
    }

    @Override
    public String toString() {
        return "Termino{" + "anio=" + anio + ", termino=" + termino + '}';
    }
    
    public void ingresarTermino(Termino termino){
        
    }
    
    public boolean eliminarTermino( Termino termino){
        return true;
    }
}
