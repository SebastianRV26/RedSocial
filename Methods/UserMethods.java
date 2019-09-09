package Methods;

import Models.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pache
 */
public class UserMethods {
    public User inicio,fin;
    public static UserMethods instance = null;
    public static UserMethods getInstance(){
        if(instance == null){
            instance = new UserMethods();
        }
        return instance;
    }
    
    public boolean insertarInicioCircular(String userName, String password, String city, String country, int identification, String name, String surname, String surname2, String photography){
        User nuevo = new User(userName,password,country,city,identification,name,surname,surname2,photography);
        if(buscarCliente(nuevo.identification) == null){
            if(inicio == null){
                inicio = nuevo;
                fin = inicio;
                inicio.sig = fin;
                inicio.ant = fin;
                fin.sig = inicio;
                fin.ant = inicio;
                return true;
            }
            if(nuevo.userName.compareTo(inicio.userName)<=0){
                nuevo.sig = inicio;
                nuevo.ant = fin;
                inicio.ant = nuevo;
                inicio = nuevo;
                return true;
            }
            if(nuevo.userName.compareTo(fin.userName)>=0){
                nuevo.ant = fin;
                nuevo.sig = inicio;
                fin.sig = nuevo;
                fin = nuevo;
                return true;
            }
            User aux=inicio;
            while(aux != null){
                if(nuevo.userName.compareTo(aux.userName)>0){
                    aux.ant.sig =nuevo;
                    nuevo.sig = aux;
                    nuevo.ant = aux.ant;
                    aux.ant = nuevo;
                    return true;
                }
                aux=aux.sig;
            }
        }
        return false;
  }
            
    public User buscarCliente(int identification){
        //hacer otro metodo para la hora de buscar el cliente que no tenga el fin ese
        User aux = inicio;
        if (aux == fin)
            return null;
        while (aux != fin) {           
            if (aux.identification == identification) {
                return aux;
            }
            aux= aux.sig;
        }
        if(aux.identification == identification){
            return aux;
        }
        return null;
    }
    
    public User buscarCliente2(int identification){
        User aux = inicio;
        while (aux != fin) {           
            if (aux.identification == identification) {
                return aux;
            }
            aux= aux.sig;
        }
        if(aux.identification == identification){
            return aux;
        }
        return null;
    }
    
    public boolean Eliminar(int cedula){
        User aux = buscarCliente2(cedula);
        if(aux == null){
            JOptionPane.showMessageDialog(null, "No existe");
            return false;
        }
        if(aux == inicio){
            if(inicio.sig == inicio){
                inicio = fin = null;
            }else{
                inicio.sig.ant = fin;
                inicio.ant.sig = inicio.sig;
                inicio.ant = null ;
                inicio = inicio.sig;
            }
            return true;
        }
        if(aux == fin){
          fin.ant.sig = inicio;
          inicio.ant = fin.ant;
          fin.sig = null;
          fin = fin.ant;
          return true;  
        }
        aux.ant.sig = aux.sig;
        aux.sig.ant = aux.ant;
        aux.sig = null;
        aux.ant = null;
        return true;
    }
}
