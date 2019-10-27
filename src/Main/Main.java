/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Classes.Event;
import Classes.User;
import Frames.*;
import Methods.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pache
 */
public class Main {
    public static ReportMethods List;
    public static User user;
    public static MethodsEvent event = new MethodsEvent();
    java.util.Date fecha = new Date();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        UserMethods user1 = UserMethods.getInstance();
        MethodsFriendList Fmet = MethodsFriendList.getInstance();
        MethodsMessage metM = MethodsMessage.getInstance();
        /*
        //UserMethods user2 = UserMethods.getInstance();
        //user1.insertarInicioCircular("yosiney", "1", "CR", "San Ramón", 10, "Yosiney", "Mora", ":v", "c:");
        //user1.insertarInicioCircular("sebas", "1","CR", "Pital", 2, "Sebastian", "Rojas", "Vargas", "C:\\Users\\Usuario\\Downloads\\");
        //user1.insertarInicioCircular("m", "2","CR", "Pital", 3, "Manuel", "Amores", ":v", "C:\\Users\\Usuario\\Downloads\\");
        //user1.insertarInicioCircular("j", "2","CR", "Pital", 4, "Jairo", "Pacheco", "Campos", "C:\\Users\\Usuario\\Downloads\\");
        user1.insertarInicioCircular("yosiney", "1", "CR", "San Ramón", 10, "Yosiney", "Mora", ":v", "C:");
        user1.insertarInicioCircular("sebas", "1","CR", "Pital", 2, "Sebastian", "Rojas", "Vargas", "C:");
        user1.insertarInicioCircular("m", "2","CR", "Pital", 3, "Manuel", "Amores", "Gonzalez", "C:");
        user1.insertarInicioCircular("j", "2","CR", "Pital", 4, "Jairo", "Pacheco", "Campos", "C:");
        user1.insertarInicioCircular("javi", "2","CR", "Ciudad Quesada", 5, "Javier", "Alfaro", ":v", "C:");
        user1.insertarInicioCircular("brian", "2","CR", "Pital", 6, "Brian", "Perez", "Avila", "C:");
        user1.insertarInicioCircular("conejo", "2","CR", "Ciudad Quesada", 7, "Fernando", "Esquivel", ":v", "C:");
        user1.insertarInicioCircular("croki", "2","CR", "Ciudad Quesada", 8, "Francisco", "Soto", ":v", "C:");
        
        Fmet.insertLast("Estructuras de Datos", "GR 51 con Diego Rojas", "sebas");
        Fmet.insertLast("Borrachera", "Los borrachos", "m"); 
        Fmet.insertLast("Proyecto estructuras", "Jairo, Sebas y Yosiney", "j");
        Fmet.insertLast("POO con Abel", "Gr 50", "yosiney");
        Fmet.insertLast("Los soccer players","Sólo fiebres al futbol","j");
        Fmet.insertLast("Arquitectura de computadores","Gr 50","m");
        
        MethodsFriendListUser metFriendListUser = MethodsFriendListUser.getInstance();
        metFriendListUser.insertLast("Proyecto estructuras","sebas");   
        metFriendListUser.insertLast("Proyecto estructuras","yosiney");
        metFriendListUser.insertLast("Estructuras de Datos","yosiney");
        metFriendListUser.insertLast("Estructuras de Datos","j");
        metFriendListUser.insertLast("POO con Abel","javi");
        metFriendListUser.insertLast("POO con Abel","conejo");
        metFriendListUser.insertLast("POO con Abel","croki");        
        metFriendListUser.insertLast("Borrachera","brian");
        metFriendListUser.insertLast("Borrachera","javi");
        metFriendListUser.insertLast("Los soccer players","brian");
        metFriendListUser.insertLast("Los soccer players","m");
        metFriendListUser.insertLast("Arquitectura de computadores","sebas");
        metFriendListUser.insertLast("Arquitectura de computadores","j");
        metFriendListUser.insertLast("Arquitectura de computadores","yosiney");
        metFriendListUser.insertLast("Arquitectura de computadores","javi");
        metFriendListUser.insertLast("Arquitectura de computadores","brian");
        // crear mensajes      
         metM.insertFirst(1111, "Hola soy Sebas", "C:", "sebas");
        metM.insertFirst(2222, "Bienvenidos al grupo de estructuras", "C:", "m");
        metM.insertFirst(3333, "Hola soy Yosiney", "C:", "yosiney");
        metM.insertFirst(4444, "Hola soy Jairo", "C:", "j");
        
        MethodsUserMessage metusermess = MethodsUserMessage.getInstance();
        metusermess.sendMessagetoUser(1111, "j");
        metusermess.sendMessagetoUser(1111, "yosiney");
        metusermess.sendMessagetoUser(2222, "yosiney");
        metusermess.sendMessagetoUser(2222, "j");*/
        user1.SacarArchivo();
        Fmet.SacarArchivo();
        List = new ReportMethods();
        List.SacarArchivo();
        metM.SacarArchivo();
        event.SacarArchivo();
        LogIn F1 =new LogIn();
        F1.setVisible(true);
    }
    public static void toUpdate(){
      Date localDate = new Date();
      try{
            Event eve= Main.event.inicioEvento;
       
            if(eve.nextEvent.getIDEvent()==Main.event.inicioEvento.getIDEvent()){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                 Date fecha= Main.event.inicioEvento.getDateEvet();
                 if(fecha.before(localDate)){
                     System.out.println(fecha);
                    eve.setStateEvent("Realizado");
                    
                }
                 

             }else{
                 do{
                    eve=eve.nextEvent;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                    Date fecha= eve.getDateEvet();
                    if(fecha.before(localDate)){
                        System.out.println(fecha);
                        eve.setStateEvent("Realizado");
                        
                    }
                     
                 } while(eve.getIDEvent()!=Main.event.ultimoEvento.getIDEvent());
               return; 
             } 
       }catch(Exception e){
           
           
       }
}
}
