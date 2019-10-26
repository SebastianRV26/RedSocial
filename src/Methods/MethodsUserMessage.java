/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;


import Classes.*;

/**
 *
 * @author Sebas
 */
public class MethodsUserMessage { 
    Message first, last;
    
    public static MethodsUserMessage instance = null;
    public static MethodsUserMessage getInstance(){
        if(instance == null){
            instance = new MethodsUserMessage();
        }
        return instance;
    }
    
    public int sendMessagetoFriendList(int IDMessage, String nameFriendList){
        MethodsMessage metMessage = MethodsMessage.getInstance();
        Message auxMessage = metMessage.searchMessage(IDMessage);
        if (auxMessage == null) {
            return 0; //no existe Mensaje
        }
        MethodsFriendList metFriendList = MethodsFriendList.getInstance();
        FriendList auxFriendList = metFriendList.searchFriendList(nameFriendList);
        if (auxFriendList ==null) { //no existe FriendList
            return 1;
        }
        UserMessage userMes = new UserMessage();
        userMes.nextFriendList = auxFriendList;
        //auxProveedor.sigProveClientes sería el inicio de cada subLista
        if (auxMessage.nextFriendList == null) { //si no exite nodo, lo crea
            auxMessage.nextFriendList = userMes;
            return 2; 
        }
        userMes.nextFriendList = auxFriendList.nextFriend; //en caso de que ya exista nodo, lo asigna al inicio
        auxMessage.nextFriendList = userMes;  
        return 2; //asignado
    }
    
    public int sendMessagetoUser(int IDMessage, String userName){
        MethodsMessage metMessage = MethodsMessage.getInstance();
        Message auxMessage = metMessage.searchMessage(IDMessage);
        if (auxMessage == null) {
            return 0; //no existe Mensaje
        }
        UserMethods metUser = UserMethods.getInstance();
        User auxUser = metUser.searchUser(userName);
        if (auxUser ==null) { //no existe usuario
            return 1;
        }
        UserMessage userMes = new UserMessage();
        userMes.nextUser = auxUser;
        //auxProveedor.sigProveClientes sería el inicio de cada subLista
        if (auxMessage.nextFriendList == null) { //si no exite nodo, lo crea
            auxMessage.nextFriendList = userMes;
            return 2; 
        }
        userMes.nextUser = auxUser.sig; //en caso de que ya exista nodo, lo asigna al inicio
        auxMessage.nextFriendList = userMes;  
        return 2; //asignado
    }
}
