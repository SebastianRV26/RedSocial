package Methods;
import Classes.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pache
 */
public class MetodosCliente {
    public Cliente inicio,fin;
    public static MetodosCliente instance = null;
    public static MetodosCliente getInstance(){
        if(instance == null){
            instance = new MetodosCliente();
        }
        return instance;
    }
    
    public boolean insertarInicioCircular(String nombreUsuario, String contrasena,String pais, String ciudad, int cedula, String nombre, String apellido1, String apellido2, String fotografia){
        Cliente nuevo = new Cliente(nombreUsuario,contrasena,pais,ciudad,cedula,nombre,apellido1,apellido2,fotografia);
        //if(buscarCliente(nuevo.cedula) == null){
            if(inicio == null){
                inicio = nuevo;
                fin = inicio;
                inicio.sig = fin;
                inicio.ant = fin;
                fin.sig = inicio;
                fin.ant = inicio;
                return true;
            }
            if(nuevo.nombreUsuario.compareTo(inicio.nombreUsuario)<=0){
                nuevo.sig = inicio;
                nuevo.ant = fin;
                inicio.ant = nuevo;
                inicio = nuevo;
                return true;
            }
            if(nuevo.nombreUsuario.compareTo(fin.nombreUsuario)>=0){
                nuevo.ant = fin;
                nuevo.sig = inicio;
                fin.sig = nuevo;
                fin = nuevo;
                return true;
            }
            Cliente aux=inicio;
            while(aux != null){
                if(nuevo.nombreUsuario.compareTo(aux.nombreUsuario)>0){
                    aux.ant.sig =nuevo;
                    nuevo.sig = aux;
                    nuevo.ant = aux.ant;
                    aux.ant = nuevo;
                    return true;
                }
                aux=aux.sig;
            }
        //}
        return false;
  }
            
    public Cliente buscarCliente(int cedula){
        Cliente aux = inicio;
        while (aux != null) { //cambiar esto porque nunca es null           
            if (aux.cedula == cedula) {
                return aux;
            }
            aux= aux.sig;
        }
        return null;
    }
}
