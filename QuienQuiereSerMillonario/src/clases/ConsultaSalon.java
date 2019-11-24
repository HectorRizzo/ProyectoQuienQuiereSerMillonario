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
public class ConsultaSalon implements Comodin {
    private boolean usado;
    private Paralelo paralelo;

    public Paralelo getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public ConsultaSalon(Paralelo paralelo) {
        this.paralelo = paralelo;
    }
    
    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
    
    @Override
    public void accion() {
        int listado[] = new int[4];
        this.paralelo.getLista_est().forEach((_item) -> {
            int eleccion = new Random().nextInt(4);
            switch(eleccion){
                case 1:
                    listado[0]+=1;
                    break;
                case 2:
                    listado[1]+=1;
                    break;
                case 3:
                    listado[2]+=1;
                    break;
                default:
                    listado[3]+=1;
                    break;
            }
        });
        int minVal = -532458748;
        int index=0;
        for(int val=0;val<listado.length; val++){
            if (listado[val]>minVal) {
                minVal=listado[val];
                index=val;
                
            }
        }
        switch(index){
            case 0:
                System.out.println("El salon opina que escojas opción A");
                break;
            case 1:
                System.out.println("El salon opina que escojas opción B");
                break;
            case 2:
                System.out.println("El salon opina que escojas opción C");
                break;
            default:
                System.out.println("El salon opina que escojas opción D");
                break;
        }
    }
    
    @Override
    public String toString(){
        return Constantes.consultaSalon;
    }
    
}
