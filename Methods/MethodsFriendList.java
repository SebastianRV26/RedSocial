/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Lists.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class MethodsFriendList {
    FriendList first, last;
    
    public static MethodsFriendList instance = null;
    public static MethodsFriendList getInstance(){
        if(instance == null){
            instance = new MethodsFriendList();
        }
        return instance;
    }
    
    public boolean insertLast (String nameList, String description){
        FriendList nuevo = new FriendList (nameList, description);
        if (first==null){
            first = last = nuevo;
            first.antFriend=last;
            first.nextFriend=first;
            return true;
        }
        FriendList auxiliar = first; //el aux está apuntando al último
        
        while (auxiliar != null){
            if (auxiliar.getNameList().equals(nameList)){
                JOptionPane.showMessageDialog(null, "El nombre ingresado ya existe");
                return false;
            }          
            if (auxiliar.nextFriend==null){
                auxiliar.nextFriend = nuevo;
                last=nuevo;
                first.antFriend=last;
                last.nextFriend=first;
                return true;   
            }
            auxiliar = auxiliar.nextFriend;
        } 
        return false;
    }
    
    public FriendList searchFriendList(String nameList){
        FriendList aux = first;
        while (aux != null){
            if (aux.getNameList().equals(nameList)){
                return aux;
            }
            aux = aux.nextFriend;
        }
        return null;
    }
    
    public boolean deleteFriendList(String nameFriendList){
        FriendList aux = searchFriendList(nameFriendList);
        
        if (aux==null){
            System.out.println("No existe");
            return false;
        }
        if (aux == first){ // para el inicio
            if (first.nextFriend==null){ // si existe un único elemento
                first=last=null;
            }else{ //si existen mas de un elemento
                first=first.nextFriend; 
                first.antFriend=null;
            }
            return true;
        }
        if (aux==last){ //para el caso de que sea el ultimo 
            //no se va a caer porque ya validé que existan varios elementos
            last=last.antFriend;
            last.nextFriend=null;
            return true;
        } //si está en el medio y no se cae 
        (aux.antFriend).nextFriend = aux.nextFriend; //aux.ant muevase al que está antes de ant, (aux.ant).sig 
        (aux.nextFriend).antFriend = aux.antFriend;
        return true;
    }
}
