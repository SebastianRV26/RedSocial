package Methods;

import Classes.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                MeterArchivo();
                return true;
            }
            
            if(nuevo.userName.compareTo(inicio.userName)<=0){
                nuevo.sig = inicio;
                nuevo.ant = fin;
                inicio.ant = nuevo;
                inicio = nuevo;
                fin.sig = inicio;//este lo puse extra
                MeterArchivo();
                return true;
            }
            if(nuevo.userName.compareTo(fin.userName)>=0){
                nuevo.ant = fin;
                nuevo.sig = inicio;
                fin.sig = nuevo;
                fin = nuevo;
                MeterArchivo();
                return true;
            }
            User aux=inicio;
            while(aux != null){
                if(nuevo.userName.compareTo(aux.userName)<0){
                    aux.ant.sig =nuevo;
                    nuevo.sig = aux;
                    nuevo.ant = aux.ant;
                    aux.ant = nuevo;
                    MeterArchivo();
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
        while (aux != fin) {           ///////aquii
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
        while (aux != fin) {      ////////aqui     
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
    
    public User searchUser(String username){
        User aux = inicio;
        while (aux != fin) {           
            if (aux.userName.equals(username)) {
                return aux;
            }
            aux= aux.sig;
        }
        if(aux.userName.equals(username)){
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
            MeterArchivo();
            return true;
        }
        if(aux == fin){
          fin.ant.sig = inicio;
          inicio.ant = fin.ant;
          fin.sig = null;
          fin = fin.ant;
          MeterArchivo();
          return true;  
        }
        aux.ant.sig = aux.sig;
        aux.sig.ant = aux.ant;
        aux.sig = null;
        aux.ant = null;
        MeterArchivo();
        return true;
    }
    public void MeterArchivo(){
        try{
            ObjectOutputStream escribiendo = new ObjectOutputStream(new FileOutputStream("./usuario.txt"));
            escribiendo.writeObject(inicio);
            
            
            ObjectOutputStream escribiendo2 = new ObjectOutputStream(new FileOutputStream("./fin.txt"));
            escribiendo2.writeObject(fin);
            escribiendo.close();
            escribiendo2.close();
        }catch(IOException e){
            
        }
    }
    
    public void SacarArchivo(){
        try{
            ObjectInputStream sacar = new ObjectInputStream(new FileInputStream("./usuario.txt"));
             inicio = (User)sacar.readObject();
             
             
             ObjectInputStream sacar2 = new ObjectInputStream(new FileInputStream("./fin.txt"));
             fin = (User)sacar2.readObject();
             sacar2.close();
             sacar.close();
        }catch(IOException | ClassNotFoundException e){
            
        }
        User aux = inicio;
        while(aux.identification != fin.identification){
            aux = aux.sig;
        }
        fin = aux;
    }
}
