/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Classes.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class MethodsMessage {
    public Message firtsMessage;
    UserMethods metuser = UserMethods.getInstance();
    MethodsFriendList metFriendList = MethodsFriendList.getInstance();
    // lista simple, con inserción al inicio.
    
    public static MethodsMessage instance = null;
    public static MethodsMessage getInstance(){
        if(instance == null){
            instance = new MethodsMessage();
        }
        return instance;
    }
    
    public boolean insertFirst (int IDMensaje, String textoMensaje, String URLdeImagen, String user){
        Message nuevo = new Message (IDMensaje, textoMensaje, URLdeImagen);
        if (firtsMessage==null){
            firtsMessage = nuevo;
            nuevo.UserMens=metuser.searchUser(user);
            metuser.MeterArchivo();
            metFriendList.MeterArchivo();
            MeterArchivo();
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
                nuevo.UserMens=metuser.searchUser(user);
                metuser.MeterArchivo();
                metFriendList.MeterArchivo();
                MeterArchivo();
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
            metuser.MeterArchivo();
            metFriendList.MeterArchivo();
            MeterArchivo();
            return true;
        }
        Message ant = firtsMessage;
        Message aux = firtsMessage;
        while (aux != null) {            
            if (aux.getIDMessage()== IDMensaje) {
                ant.nextMessage = aux.nextMessage;
                metuser.MeterArchivo();
                metFriendList.MeterArchivo();
                MeterArchivo();
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
        metuser.MeterArchivo();
        metFriendList.MeterArchivo();
        MeterArchivo();
        return true;
    }
    
   public boolean createMessageByAdmin(int IDMensaje, String textoMensaje, String URLdeImagen){
        Message nuevo = new Message (IDMensaje, textoMensaje, URLdeImagen);
        if (firtsMessage==null){
            firtsMessage = nuevo;
            nuevo.UserAdmin = "Diego";
            metuser.MeterArchivo();
            metFriendList.MeterArchivo();
            MeterArchivo();
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
                nuevo.UserAdmin="Diego";
                metuser.MeterArchivo();
                metFriendList.MeterArchivo();
                MeterArchivo();
                return true;   
            }
            auxiliar = auxiliar.nextMessage;            
        }        
        return false; 
   }
   public int SendMessageToAll(int messageToSend){
       MethodsUserMessage metUserMessage = MethodsUserMessage.getInstance();
       
       User aux = metuser.inicio;
       if (aux==null){
           return 1;
       }
        while (aux!=metuser.fin){
            int resp=metUserMessage.sendMessagetoUser(messageToSend, aux.userName);
            if (resp==0){
                JOptionPane.showMessageDialog(null, "No existe el mensaje");
                return 0;
            }
            else if (resp==1){
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
            //else if (resp==2){
            //    JOptionPane.showMessageDialog(null, "Mensjae enviado exitosamente al usuario "+aux.userName);
            //}
            aux=aux.sig;
        }
        int resp=metUserMessage.sendMessagetoUser(messageToSend, aux.userName);
        if (resp==1){
            JOptionPane.showMessageDialog(null, "No existe el mensaje");
            return 0;
        }
        else if (resp==1){
            JOptionPane.showMessageDialog(null, "No existe el usuario");
        }
        //else if (resp==2){
        //    JOptionPane.showMessageDialog(null, "Mensjae enviado exitosamente al usuario "+aux.userName);
        //}
        return 2;
   }
   public void MeterArchivo(){
        try{
            ObjectOutputStream escribiendo = new ObjectOutputStream(new FileOutputStream("./Massage.txt"));
            escribiendo.writeObject(firtsMessage);
                                    
        }catch(IOException e){
            
        }
    }
    public void SacarArchivo(){
        try{
            ObjectInputStream sacar = new ObjectInputStream(new FileInputStream("./Massage.txt"));
             firtsMessage = (Message)sacar.readObject();
                                      
        }catch(IOException | ClassNotFoundException e){
            
        }
        
    }
}
