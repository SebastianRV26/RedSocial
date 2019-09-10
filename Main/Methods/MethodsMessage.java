/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Classes.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class MethodsMessage {
    public Message firtsMessage;
    // lista simple, con inserción al inicio.
    
    public static MethodsMessage instance = null;
    public static MethodsMessage getInstance(){
        if(instance == null){
            instance = new MethodsMessage();
        }
        return instance;
    }
    
    public boolean insertFirst (int IDMensaje, String textoMensaje, String URLdeImagen){
        Message nuevo = new Message (IDMensaje, textoMensaje, URLdeImagen);
        if (firtsMessage==null){
            firtsMessage = nuevo;
            //ultimo = nuevo;
            return true;
        }
        Message auxiliar = firtsMessage; //el aux está apuntando al inicio        
        while (auxiliar != null){
            if (auxiliar.getIDMessage()==IDMensaje){
                JOptionPane.showMessageDialog(null, "El ID del mensaje ya existe");
                return false;
            }
            
            if (searchMessage(IDMensaje)==null){ // si no encontró la cédua, lo agrega
                nuevo.nextMessage = firtsMessage; 
                firtsMessage = nuevo;
                return true;   
            }
            auxiliar = auxiliar.nextMessage;            
        }        
        return false;
    }
    
    public Message searchMessage(int IDMensaje){
        Message aux = firtsMessage;
        while (aux != null){
            if (aux.getIDMessage()== IDMensaje){
                return aux;
            }
            aux = aux.nextMessage;
        }
        return null;
    }
    
    public boolean deleteMessage(int IDMensaje){
        if (firtsMessage == null) {
            return false;
        }
        if (firtsMessage.getIDMessage()== IDMensaje) {
            firtsMessage = firtsMessage.nextMessage;
            return true;
        }
        Message ant = firtsMessage;
        Message aux = firtsMessage;
        while (aux != null) {            
            if (aux.getIDMessage()== IDMensaje) {
                ant.nextMessage = aux.nextMessage;
                return true;
            }
            ant = aux;
            aux = aux.nextMessage;
        }
        return false;
    }
    
    public boolean modifyMessage(int IDMensaje, String textoMensaje, String URLdeImagen){
        Message aux=searchMessage(IDMensaje);
        if (aux==null){
            return false;
        }
        aux.setTextMessage(textoMensaje);
        aux.setURLImage(URLdeImagen);
        return true;
    }
    
   
}
