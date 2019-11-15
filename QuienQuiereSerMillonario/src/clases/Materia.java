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
public class Materia {
    private String codigo;
    private String nombre;
    private int nivel;
    private boolean estado;

    public Materia(){
        //constructor vacio por defecto
    }
    //constructor con parametro
    public Materia(String codigo, String nombre, int nivel, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.estado = estado;
    }
    
    //getters and setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    //toString

    @Override
    public String toString() {
        return "Materia{" + "codigo=" + codigo + ", nombre=" + nombre + ", nivel=" + nivel + ", estado=" + estado + '}';
    }
    
    public void ingresarMateria(String codigo, String nombre, int nivel){
        //cuerpo del metodo
        
    }
    public void editarMateria (String codigo){
        //cuerpo del metodo
    }
    public void desactivarMateria(String codigo){
        //cuerpo
        if (getCodigo().equals(codigo)){
            setEstado(false);
        }
    }
}
