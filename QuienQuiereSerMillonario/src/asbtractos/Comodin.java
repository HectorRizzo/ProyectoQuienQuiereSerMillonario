/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asbtractos;

/**
 *
 * @author Feer
 */
public abstract class Comodin { // clase abstracta comodin
    
    private boolean usado;//booleano que determina si el comodin ha sido usado o no
    
    public Comodin(){
        this.usado=false;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
    
    public abstract void accion(); //metodo que implementaran las clases hijas
}
