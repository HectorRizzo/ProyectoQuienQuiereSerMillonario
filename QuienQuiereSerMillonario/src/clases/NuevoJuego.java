/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import asbtractos.Comodin;
import configuracion.AdminTermino;

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
    
    private String[] preguntaDetalle(Pregunta pregunta){
        String respuestas[] = {pregunta.getResp_Correcta(),pregunta.getPosibles_resp().get(0),pregunta.getPosibles_resp().get(1),pregunta.getPosibles_resp().get(2)};
        List<String> newPreguntas = Arrays.asList(respuestas);
        Collections.shuffle(newPreguntas);
        newPreguntas.toArray(respuestas);
        System.out.println("Pregunta: "+pregunta.getEnunciado());
        System.out.println("A) "+respuestas[0]);
        System.out.println("B) "+respuestas[1]);
        System.out.println("C) "+respuestas[2]);
        System.out.println("D) "+respuestas[3]);
        
        return respuestas;
    }
    
    private void comodinDetalle(){
        System.out.println("Comodines disponibles:");
        int conteo = 1;
        for(Comodin comodin: this.comodines){
            if (!comodin.isUsado()) {
                System.out.println(""+conteo+") "+comodin);
                conteo++;
            }
        }
        System.out.println("Escoger comodin:");
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();
        Comodin comodin = this.comodines.get(eleccion-1);
        comodin.accion();
        comodin.setUsado(true);
        
    }
    
    public void iniciar(){
        setComodines();
        for(Pregunta pregunta: this.preguntas){
            Scanner sc = new Scanner(System.in);
            boolean noAtendidaPregunta = true;
            String eleccion="";
            String respuesta="";
            while(noAtendidaPregunta){
                String[] respuestas = preguntaDetalle(pregunta);
                System.out.println("Toque una letra para continuar {A,B,C,D} o {*} para escoger un comodin");
                eleccion = sc.next();
                if (eleccion.equals("*")){
                    comodinDetalle();
                }
                else{
                    switch(eleccion){
                        case "A":
                            respuesta = respuestas[0];
                            break;
                        case "B":
                            respuesta = respuestas[1];
                            break;
                        case "C":
                            respuesta = respuestas[2];
                            break;
                        case "D":
                            respuesta = respuestas[3];
                            break;
                        default:
                            respuesta = null;
                            break;
                            
                    }
                    noAtendidaPregunta=false;
                }
                if (respuesta == null){
                    System.out.println("Ingreso de teclado erroneo");
                }
                else{
                    if (pregunta.getResp_Correcta().equals(respuesta)){
                        System.out.println("Respuesta Correcta");
                    }
                    else{
                        System.out.println("Respuesta Incorrecta");
                    }
                }
            }
        }
        System.out.println("Ha ganado exitosamente");
    }
}
