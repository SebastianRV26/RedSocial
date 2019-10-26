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
public class MethodsFriendList {
    public FriendList first, last;
    MethodsFriendListUser metFriendListUser = MethodsFriendListUser.getInstance();
    UserMethods metUser = UserMethods.getInstance();
    
    public static MethodsFriendList instance = null;
    public static MethodsFriendList getInstance(){
        if(instance == null){
            instance = new MethodsFriendList();
        }
        return instance;
    }
    
    public boolean insertLast (String nameList, String description, String username){
        FriendList nuevo = new FriendList (nameList, description);
        if (first==null){
            first = last = nuevo;
            first.antFriend=last;
            first.nextFriend=last;
            last.nextFriend=first;
            last.antFriend =first;
            nuevo.nextUser= metUser.searchUser(username); 
            metFriendListUser.insertLast(nameList,username);
            return true;
        }
        FriendList auxiliar = first;
        
        while (auxiliar != last){
            if (auxiliar.getNameList().equals(nameList)){
                JOptionPane.showMessageDialog(null, "El nombre ingresado ya existe");
                return false;
            }
            auxiliar = auxiliar.nextFriend;
        } 
        if (auxiliar.getNameList().equals(nameList)){
            JOptionPane.showMessageDialog(null, "EL nombre ingresado ya existe");
            return false;
        }
        last.nextFriend=nuevo;
        nuevo.antFriend=last;
        last=nuevo;
        last.nextFriend=first;
        first.antFriend=last;
        nuevo.nextUser= metUser.searchUser(username); 
        metFriendListUser.insertLast(nameList,username);
        return true;
    }
    
    public FriendList searchFriendList(String nameList){
        
        if (nameList.equals(first.getNameList())){
            return first;
        }
        
        FriendList aux = first;
        while (aux != last){
            if (aux.getNameList().equals(nameList)){
                return aux;
            }
            aux = aux.nextFriend;
        }
        if (aux.getNameList().equals(nameList)){
            return aux;
        }
        return null;
    }
    
    
    public boolean deleteFriendList(String nameFriendList){
        FriendList aux = searchFriendList(nameFriendList);
        if (aux==null){
            return false;
        }
        if (aux == first){ // para el inicio
            if (first.nextFriend==null){ // si existe un único elemento
                first=last=null;
            }else{ //si existen mas de un elemento
                //first=first.nextFriend; 
                //first.antFriend=null;
                
                first.nextFriend.antFriend = last;
                first.antFriend.nextFriend = first.nextFriend;
                first.antFriend = last;
                first = first.nextFriend;
                
                
            }
            return true;
        }
        if (aux==last){ //para el caso de que sea el ultimo 
            //no se va a caer porque ya validé que existan varios elementos
            //last=last.antFriend;
            //last.nextFriend=null;
            //return true;
            last.antFriend.nextFriend = first;
            first.antFriend = last.antFriend;
            last.nextFriend = first;
            last = last.antFriend;
            return true;
        } //si está en el medio y no se cae 
        //(aux.antFriend).nextFriend = aux.nextFriend; //aux.ant muevase al que está antes de ant, (aux.ant).sig 
        //(aux.nextFriend).antFriend = aux.antFriend;
        //return true;
        aux.antFriend.nextFriend = aux.nextFriend;
        aux.nextFriend.antFriend = aux.antFriend;
        aux.nextFriend = null;
        aux.antFriend = null;
        return true;
    }
}

