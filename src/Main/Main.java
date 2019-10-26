/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Classes.User;
import Frames.*;
import Methods.*;

/**
 *
 * @author pache
 */
public class Main {
    public static ReportMethods List;
    public static User user;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserMethods user1 = UserMethods.getInstance();
        //Crear Usuarios
        user1.insertarInicioCircular("yosiney", "1", "CR", "San Ramón", 1111, "Yosiney", "Mora", ":v", "c:");
        user1.insertarInicioCircular("sebas", "1","CR", "Pital", 2222, "Sebastian", "Rojas", "Vargas", "C:\\Users\\Usuario\\Downloads\\");
        user1.insertarInicioCircular("m", "2","CR", "Pital", 3333, "Manuel", "Amores", ":v", "C:\\Users\\Usuario\\Downloads\\");
        user1.insertarInicioCircular("jairo", "2","CR", "Pital", 4444, "Jairo", "Pacheco", ":v", "C:\\Users\\Usuario\\Downloads\\");
        //user1.insertarInicioCircular("k", "1", "CR", "Ciudad Quesada", 5555, "Kalimba", ":v", ":v", "c:");
        //user1.insertarInicioCircular("javi", "1", "CR", "Ciudad Quesada", 6666, "Javier", "Alfaro", ":v", "c:");
        
        //Crear Listas de amigos
        MethodsFriendList group =MethodsFriendList.getInstance();
        
        group.insertLast("Estructuras de Datos", "GR 51 con Diego Rojas", "sebas");
        group.insertLast("Borrachera", "Los borrachos", "sebas"); 
        group.insertLast("Proyecto estructuras", "Jairo, Sebas y Yosiney", "jairo");
        group.insertLast("POO con Abel", "Gr 50", "yosiney");
        
        //agregar a grupos
        MethodsFriendListUser metFriendListUser = MethodsFriendListUser.getInstance();
        metFriendListUser.insertLast("Proyecto estructuras","sebas");   
        metFriendListUser.insertLast("Proyecto estructuras","yosiney");
        metFriendListUser.insertLast("Estructuras de Datos","yosiney");
        metFriendListUser.insertLast("Estructuras de Datos","jairo");
        //metFriendListUser.insertLast("Borrachera","javi");
        
        // crear mensajes      
        MethodsMessage message = MethodsMessage.getInstance();
        
        //crear mensajes
        message.insertFirst(1111, "Hola soy Sebas", "C:\\Users\\Usuario\\Documents\\Curso de Java\\ProyectoEstructuras\\src\\Images\\Piolin.jpg", "sebas");
        message.insertFirst(2222, "Bienvenidos al grupo de estructuras", "C:", "sebas");
        message.insertFirst(3333, "Hola soy Yosiney", "C:", "yosiney");
        message.insertFirst(4444, "Hola soy Jairo", "C:", "jairo");
        message.insertFirst(5555, "Hola soy Manuel", "C:", "m"); 
        
        // enviar mensaje
        MethodsUserMessage metusermess = MethodsUserMessage.getInstance();
        metusermess.sendMessagetoUser(1111, "jairo");
        metusermess.sendMessagetoUser(1111, "yosiney");
        metusermess.sendMessagetoUser(2222, "yosiney");
        metusermess.sendMessagetoUser(2222, "jairo");
        message.createMessageByAdmin(6666, "GG NOOBS", "C:"); 
        
        message.SendMessageToAll(6666);
        
        List = new ReportMethods();
        LogIn F1 =new LogIn();
        F1.setVisible(true);
    }
    
}
