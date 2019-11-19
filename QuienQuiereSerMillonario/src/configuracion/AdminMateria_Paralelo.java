/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import clases.Estudiante;
import clases.Materia;
import clases.Paralelo;
import clases.Termino;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Hector Rizzo
 */
public class AdminMateria_Paralelo {
    Scanner sc=new Scanner(System.in);
    private ArrayList <Materia> listaMateria;
    private ArrayList<Paralelo> lista_paralelo;

    public AdminMateria_Paralelo() {
    listaMateria= new ArrayList<> ();
    //Añadido: lista de paralelos
    lista_paralelo=new ArrayList<>();
    }
    
    //getters
    
    @Override
    public String toString() {
        return "AdminMateria_Paralelo{" + "sc=" + sc + ", listaMateria=" + listaMateria + ", lista_paralelo=" + lista_paralelo + '}';
    }

    public ArrayList<Materia> getListaMateria() {
        return listaMateria;
    }

    public ArrayList<Paralelo> getLista_paralelo() {
        return lista_paralelo;
    }
    
    /**
     *
     * @param codigo
     * @param nombre
     * @param nivel
     */
    public void ingresarMateria(String codigo, String nombre, int nivel){
        //crea un objeto tipo Materia y la añade al ArrayList
        Materia materiaIngr = new Materia(codigo,nombre,nivel,true);
        listaMateria.add(materiaIngr);
        
    }
    public void editarMateria (String codigo){
        //recorre la lista 
        for(Materia i:listaMateria){
            
            //Comprueba si el codigo pertenece a alguna materia
            if(i.getCodigo().equals(codigo)){
                
                //Pregunta si desea editar el nombre
                System.out.println("Desea editar el nombre? Y/N");
                String opcionM=sc.nextLine();
                
                //Pregunta  y cambia el nombre
                if(opcionM.equals("Y")){
                    System.out.println("Ingrese el nuevo nombre: ");
                     i.setNombre(sc.nextLine());
                }
                //Pregunta si desea editar los niveles 
                System.out.println("Desea editar la cantidad de niveles? Y/N");
                String opcionN=sc.nextLine();
                
                //Pregunta  y cambia los niveles
                if(opcionN.equals("Y")){
                    System.out.println("Ingrese la cantidad de niveles: ");
                     i.setNivel(sc.nextInt());  
                }

            }
            
        }
        
    }
    
    public void desactivarMateria(String codigo){
        for(Materia h: listaMateria){
        //Confirmación
            if (h.getCodigo().equals(codigo)){
                System.out.println("Está seguro que desea desactivar la materia? (Y/N):");
               if(sc.nextLine().equals("Y")){
                h.setEstado(false);
               }
            }
        }
        
    }
    
    public void agregarParalelo( Materia materia, Termino termino,int num_paralelo){
        /*añade el paralelo 
        Lo que ingresa el usuario solo es termino, materia y el numero del paralelo por lo cual
        falta el campo de numero de estudiante y la lista de estudiante. Mi sugerencia es dejarlo en 
        0 y vacía respectivamente hasta que vea que se hace.
        */
        int numEstud=0;
        ArrayList <Estudiante> listEstud=new ArrayList();
       Paralelo par= new Paralelo(termino,materia,numEstud,num_paralelo,listEstud); 
       lista_paralelo.add(par);
    }
    
    public void eliminarParalelo(){
        System.out.println(getLista_paralelo());
        System.out.println("Ingrese el numero del paralelo que desea eliminar ");
        int opcion=sc.nextInt();
        //recorre la lista
        for(Paralelo j: lista_paralelo){
            if (j.getNum_paralelo()==opcion){
                lista_paralelo.remove(j);
            }
        }
    }
    //Menu de administrar materias y paralelos
    public void menuAdminMateria(){
        System.out.println("Lista Materia: "+ getListaMateria());
        System.out.println("Lista Paralelos: " + getLista_paralelo());
        System.out.println("Administrar Materias y Paralelos");
        System.out.println("1.- Ingresar materia\n 2.- Editar materia\n 3.- Desactivar materia\n 4.- Agregar paralelo\n 5.- Eliminar paralelo");
        System.out.println("Escoja una opción");
        
        int opcionMat=sc.nextInt();
        switch(opcionMat){
            case 1:
               Scanner sc1=new Scanner(System.in);
               System.out.println("Ingresar Materia");
                System.out.println("Ingrese código de la materia:");
                String codMateria=sc1.nextLine();
                System.out.println("Ingrese nombre de la materia: ");
                String nombreMateria= sc1.nextLine();
                System.out.println("Ingrese la cantidad de Niveles: ");
                int niveles= sc1.nextInt();
                ingresarMateria(codMateria,nombreMateria,niveles);
                break;
            case 2:
                
                System.out.println("Editar Materia");
                System.out.println("Ingrese el código de la materia a editar: ");
                String codigo= sc.nextLine();
                editarMateria(codigo);
                break;
            case 3:
                System.out.println("Desactivar materia");
                System.out.println("Ingrese el codigo de la materia a desactivar: ");
                String codigoMat=sc.nextLine();
                editarMateria(codigoMat);
                break;
            case 4:
                System.out.println("Agregar paralelo");
                //falta que obtenga la materia y el termino, esto no se como hacerlo**
                System.out.println("Ingrese el número del paralelo");
                int numPar=sc.nextInt();
                //agregarParalelo(Materia materia, Termino termino, numPar);
                break;
            case 5:
                System.out.println("Eliminar Paralelo");
                eliminarParalelo();
                break;
        }
        
        
        
        
        
    }
    
}
