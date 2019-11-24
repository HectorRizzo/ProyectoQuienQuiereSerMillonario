/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import configuracion.AdminTermino;
import interfaces.Comodin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel Zurita
 */
public class NuevoJuego {
    
    private Materia materia;
    private Paralelo paralelo;
    private int numeroPreguntaNivel;
    private Estudiante participante=null,compañero=null;
    private ArrayList<Comodin> comodines = new ArrayList<>();
    private Pregunta pregunta=null;
    private ArrayList<Pregunta> preguntas = new ArrayList<>();

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
    public void setPreguntas(ArrayList<Pregunta> preguntas){
        for(Pregunta pregunta: preguntas){
            if (pregunta.getMateria().getCodigo().equals(this.materia.getCodigo())) this.preguntas.add(pregunta);
        }
    }
    private void setComodines(){
        this.comodines.add(new FiftyFifty(this.pregunta));
        this.comodines.add(new ConsultaCompañero(this.compañero));
        this.comodines.add(new ConsultaSalon(this.paralelo));
    }
    public void setCompañero(String busqueda){
        for(Estudiante estudiante: this.paralelo.getLista_est()){
            if (estudiante.getMatricula().equals(busqueda)) this.compañero=estudiante;
        }
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
    
    private void preguntaDetalle(Pregunta pregunta){
        String preguntas[] = {pregunta.getResp_Correcta(),pregunta.getPosibles_resp().get(0),pregunta.getPosibles_resp().get(1),pregunta.getPosibles_resp().get(2)};
        List<String> newPreguntas = Arrays.asList(preguntas);
        Collections.shuffle(newPreguntas);
        newPreguntas.toArray(preguntas);
        System.out.println("Pregunta: "+pregunta.getEnunciado());
        System.out.println("A) "+preguntas[0]);
        System.out.println("B) "+preguntas[1]);
        System.out.println("C) "+preguntas[2]);
        System.out.println("D) "+preguntas[3]);
    }
    
    private void comodinDetalle(){}
    
    public void iniciar(){
        for(Pregunta pregunta: this.preguntas){
            Scanner sc = new Scanner(System.in);
            preguntaDetalle(pregunta);
            System.out.println("Toque una letra para continuar {A,B,C,D} o {*} para escoger un comodin");
        }
        System.out.println("Ha ganado exitosamente");
    }
}
