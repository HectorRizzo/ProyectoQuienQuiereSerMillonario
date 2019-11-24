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
    //clase de Nuevo Juego con sus atributos
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
        seleccionarEstudiante(busqueda);// se llama funcion para asignar participante de acuerdo a su busqueda
    }
    public void seleccionarEstudiante(String busqueda){ //busca en la lista si existe ese estudiante caso contrario se devuelve null
        for(Estudiante estudiante: this.paralelo.getLista_est()){
            if (estudiante.getMatricula().equals(busqueda)) participante=estudiante;
        }    
    }
    public Materia getMateria() {
        return materia;
    }
    public void setPreguntas(ArrayList<Pregunta> preguntas){//se asigna las preguntas de acuerdo al banco de preguntas y si pertenecen a la materia
        for(Pregunta pregunta: preguntas){
            if (pregunta.getMateria().getCodigo().equals(this.materia.getCodigo())) this.preguntas.add(pregunta);
        }
        System.out.println(this.preguntas);
    }
    private void setComodines(){ //Se setean en una lista los 3 tipos de comodines
        this.comodines.add(new FiftyFifty(this.pregunta));//50/50
        this.comodines.add(new ConsultaCompañero(this.compañero));//consulta compañero
        this.comodines.add(new ConsultaSalon(this.paralelo));//consulta al salon
    }
    public void setCompañero(String busqueda){//se setea al compañero
        for(Estudiante estudiante: this.paralelo.getLista_est()){
            if (estudiante.getMatricula().equals(busqueda)) this.compañero=estudiante;
        }
        System.out.println(this.compañero);
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
    
    private String[] preguntaDetalle(Pregunta pregunta){//metodo que imprime por pantalla la pregunta y sus posibles respuestas
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
    
    private void comodinDetalle(){ // metodo que devuelve los comodines disponibles para el estudiante
        System.out.println("Comodines disponibles:");
        int conteo = 1;
        for(Comodin comodin: this.comodines){
            if (!comodin.isUsado()) {
                System.out.println(""+conteo+") "+comodin);
                conteo++;
            }
        }
        System.out.println("Escoger comodin:");// me permite escoger comodin y cambiar su estado a usado
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();
        Comodin comodin = this.comodines.get(eleccion-1);
        comodin.accion();
        comodin.setUsado(true);
        
    }
    
    public void iniciar(){
        setComodines(); // se setean los comodines
        boolean derrota = false; // se setea un bandera para saber si fue derrotado o no el jugador
        for(Pregunta pregunta: this.preguntas){
                FiftyFifty comodin = (FiftyFifty) this.comodines.get(0);
                comodin.setPregunta(pregunta); //Se setea la pregunta al 50/50
                Scanner sc = new Scanner(System.in);
                boolean noAtendidaPregunta = true;
                String eleccion="";
                String respuesta="";
                while(noAtendidaPregunta){//while para mantener en caso de que no se haya respondido a la pregunta
                    String[] respuestas = preguntaDetalle(pregunta);
                    System.out.println("Toque una letra para continuar {A,B,C,D} o {*} para escoger un comodin");
                    eleccion = sc.next();
                    if (eleccion.equals("*")){
                        comodinDetalle();
                    }
                    else{
                        switch(eleccion){//jugador procede a seleccionar las opciones entre a b c d
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
                        noAtendidaPregunta=true;
                    }
                    else{
                        if (pregunta.getResp_Correcta().equals(respuesta)){//si la respuesta escogida es misma a la de la respuesta correcta de la pregunta
                            System.out.println("Respuesta Correcta");//Jugador continua
                        }
                        else{
                            System.out.println("Respuesta Incorrecta");
                            derrota = true;
                            break;
                        }
                    }
                }
        }
        String mensaje = derrota ? "Has perdido" : "Has ganado"; //determinar el tipo de mensaje a lanzarse
        System.out.println(mensaje);
    }
}
