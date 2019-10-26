/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Classes.*;
import Main.Main;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class MethodsFriendListUser {
    public static MethodsFriendListUser instance = null;
    public static MethodsFriendListUser getInstance(){
        if(instance == null){
            instance = new MethodsFriendListUser();
        }
        return instance;
    }
    
    public int insertLast(String nameFriendList, String userName){
        MethodsFriendList metFriendList = MethodsFriendList.getInstance();
        FriendList auxFriendList = metFriendList.searchFriendList(nameFriendList);
        if (auxFriendList == null) {
            return 0; //no existe friendlist
        }
        UserMethods metuser = UserMethods.getInstance();
        User auxUser = metuser.searchUser(userName);
        if (auxUser ==null) { //no existe usuario
            return 1;
        }
        if (Validation(auxUser,auxFriendList)==false){
            JOptionPane.showMessageDialog(null, "El Usuario ya ha sido agregado a esta lista de amigos");
            return 3;
        }
        FriendListUser friendUser = new FriendListUser();
        friendUser.nextUser = auxUser;
        if (auxFriendList.nextFriend == null) { //si no exite nodo, lo crea
            auxFriendList.nextFriendListUser = friendUser;
            return 2; 
        }
        friendUser.next = auxFriendList.nextFriendListUser; //en caso de que ya exista nodo, lo asigna al inicio
        auxFriendList.nextFriendListUser = friendUser;  
        return 2; //asignado
    }
    public boolean Validation(User usu, FriendList friendList){
        MethodsFriendList metFriendList = MethodsFriendList.getInstance();
        FriendList auxFriendList = metFriendList.first;
        while(auxFriendList!=metFriendList.last){
            if (auxFriendList.equals(friendList)){
                if (auxFriendList.nextFriendListUser != null) {
                    FriendListUser auxFU = auxFriendList.nextFriendListUser;
                    while (auxFU != null) {
                        if (auxFU.nextUser.equals(usu)){
                            return false;
                        }
                        auxFU = auxFU.next;
                    }
                }
            
            }
            auxFriendList=auxFriendList.nextFriend;
        }
        if (auxFriendList.equals(friendList)){
            if (auxFriendList.nextFriendListUser != null) {
                FriendListUser auxFU = auxFriendList.nextFriendListUser;
                while (auxFU != null) {
                    if (auxFU.nextUser.equals(usu)){
                        return false;
                    }
                    auxFU = auxFU.next;
                }
            
            }
        }
        return true;
    }
    
    public boolean deleteUserFromFriendList(User usu, String nameFriendList){
        MethodsFriendList metFriendList = MethodsFriendList.getInstance();
        FriendList auxFriendList = metFriendList.searchFriendList(nameFriendList);
        if (auxFriendList==null){
           return false;
        }
        if (auxFriendList.nextFriendListUser==null){ //si está vacía
           return false;
        }else if(auxFriendList.nextFriendListUser.nextUser.equals(usu)){//es el primero
           auxFriendList.nextFriendListUser=auxFriendList.nextFriendListUser.next;
           return true;       
        }
        FriendListUser ant = auxFriendList.nextFriendListUser;
        FriendListUser aux = auxFriendList.nextFriendListUser;
        while (aux != null){
            if (aux.nextUser.equals(usu)){
                ant.next = aux.next;
                return true;    
            }
            ant = aux;
            aux = aux.next;
        }
        return false;
    }
       
}
