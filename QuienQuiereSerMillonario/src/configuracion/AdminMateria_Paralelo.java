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
    private ArrayList<Termino> listaTermino;

    


    public AdminMateria_Paralelo(ArrayList<Materia> listaMateria, ArrayList<Paralelo> lista_paralelo,ArrayList <Termino> listaTermino) {
        this.listaMateria = listaMateria;
        this.lista_paralelo = lista_paralelo;
        this.listaTermino= listaTermino;

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
                Scanner sc=new Scanner(System.in);
                //Pregunta si desea editar el nombre
                System.out.println("Desea editar el nombre? Y/N");
                String opcionM=sc.nextLine();
                
                //Cambia el nombre
                if(opcionM.equals("Y")){
                    System.out.println("Ingrese el nuevo nombre: ");
                     i.setNombre(sc.nextLine());
                }
                //Pregunta si desea editar los niveles 
                System.out.println("Desea editar la cantidad de niveles? Y/N");
                String opcionN=sc.nextLine();
                
                //Cambia los niveles
                if(opcionN.equals("Y")){
                    System.out.println("Ingrese la cantidad de niveles: ");
                     i.setNivel(sc.nextInt());  
                }

            }else{
                System.out.println("Codigo no existente");
            }
            
        }
        
    }
    
    public void desactivarMateria(String codigo){
        for(Materia h: listaMateria){
        //Confirmación
            if (h.getCodigo().equals(codigo)){
                Scanner sc4=new Scanner(System.in);
                System.out.println("Está seguro que desea desactivar la materia? (Y/N):");
               if(sc4.nextLine().equals("Y")){
                h.setEstado(false);
               }
            }
        }
        
    }
    
    public void agregarParalelo( Materia materia, Termino termino,String num_paralelo){
        /*añade el paralelo 
        Lo que ingresa el usuario solo es termino, materia y el numero del paralelo por lo cual
        falta el campo de numero de estudiante y la lista de estudiante. Mi sugerencia es dejarlo en 
        0 y vacía respectivamente hasta que vea que se hace.
        */
        ArrayList <Estudiante> listEstud=new ArrayList();
        AdminEstudiante toListEstud= new AdminEstudiante(listEstud);
        System.out.println("Ingrese el numero de estudiantes registrados en el paralelo: ");
        int numEstud=sc.nextInt();
       Paralelo par= new Paralelo(termino,materia,numEstud,num_paralelo,toListEstud.leerArchivo(materia.getCodigo(), num_paralelo, String.valueOf(termino.getAnio())+"-"+termino.getNumTermino())); 
       lista_paralelo.add(par);
       
        
    }
    
    public void eliminarParalelo(){
        //muestra la lista de paralelos
        int i=1;
        for (Paralelo p:lista_paralelo){
            System.out.println(i+": "+p);
            i++;
        }

        System.out.println("Ingrese el numero del paralelo que desea eliminar ");  
        sc.nextLine();

        System.out.println("Ingrese el numero del paralelo que desea eliminar ");       

        String opcion=sc.nextLine();
        //recorre la lista
        ArrayList <Paralelo> toRemove=new ArrayList();
        for(Paralelo j: lista_paralelo){
            if (j.getNum_paralelo().equals(opcion)){
                toRemove.add(j);
            }
        }
        lista_paralelo.removeAll(toRemove);
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
                Scanner sc2=new Scanner(System.in);
                System.out.println("Editar Materia");
                System.out.println("Ingrese el código de la materia a editar: ");
                String codigo= sc2.nextLine();
                editarMateria(codigo);
                break;
            case 3:
                Scanner sc3=new Scanner(System.in);
                System.out.println("Desactivar materia");
                System.out.println("Ingrese el codigo de la materia a desactivar: ");
                String codigoMat=sc3.nextLine();
                desactivarMateria(codigoMat);
                break;
            case 4:
                System.out.println("***Importante*** \n Primero debe copiar la lista de estudiantes de este paralelo en la carpeta: archivos");
                Materia mat= new Materia();
                Termino ter= new Termino(0,0);
                System.out.println("Agregar paralelo");
                System.out.println("Ingrese el codigo de la Materia: ");
                sc.nextLine();
                String cod_materia=sc.nextLine();
                System.out.println("Ingrese el año: ");
                int año=sc.nextInt();
                System.out.println("Ingrese el numero del termino: ");
                int num_termino= sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese el número del paralelo");
                String numPar=sc.nextLine();
                for(Materia m: listaMateria){
                    if(m.getCodigo().equals(cod_materia))
                        mat=m;
                }
                for(Termino t: listaTermino){
                    if(t.getAnio()==año && t.getNumTermino()==num_termino){
                        ter=t;
                    }
                }
                
                agregarParalelo(mat, ter,numPar);
                
                break;
            case 5:
                System.out.println("Eliminar Paralelo");
                eliminarParalelo();
                break;
        }
        
        
        
        
        
    }
    
}
