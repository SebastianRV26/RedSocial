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
public class MethodsUserEvent {
    Event first, last;
    public static MethodsUserEvent instance = null;
    public static MethodsUserEvent getInstance(){
        if(instance == null){
            instance = new MethodsUserEvent();
        }
        return instance;
    }
    
    public Event searchEvent(int IDEvent){
        Event aux = first;
        while (aux != null){
            if (aux.getIDEvent()== IDEvent){
                return aux;
            }
            aux = aux.nextEvent;
        }
        return null;
    }
}
