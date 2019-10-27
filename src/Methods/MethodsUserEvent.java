/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Classes.*;
import static Main.Main.user;
import Classes.User;
import Main.Main;
/**
 *
 * @author yosiney
 */
public class MethodsUserEvent {
    UserMethods met = UserMethods.getInstance();
    MethodsEvent metE = MethodsEvent.getInstance();
    public Event first, last;
    public static MethodsUserEvent instance = null;
    public static MethodsUserEvent getInstance(){
        if(instance == null){
            instance = new MethodsUserEvent();
        }
        return instance;
    }
   
    public boolean insertSubUser(int idEvent,int idUser){
       Event auxEvent= Main.event.buscarEvento(idEvent); 
       UserMethods user= UserMethods.getInstance();
       User auxUser=user.buscarCliente(idUser);
       
       UserEvent userEvent=  new UserEvent();
       userEvent.User=auxUser; 
       if(auxEvent==null){
           return false;
       }
       if(auxUser==null){
           return false;
       }
       
       if(auxEvent.user==null){ 
           auxEvent.user=userEvent;
           metE.MeterArchivo();
           met.MeterArchivo();
           return true;
       }
       UserEvent start =auxEvent.user;
       while(start!=null){
           if(start.User.identification==auxUser.identification){
               return false;
           }
           start= start.next;
           
       }
       userEvent.next=auxEvent.user;
       auxEvent.user=userEvent;
       metE.MeterArchivo();
       met.MeterArchivo();
       return true;
    }

}
