/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Classes.*;
import java.util.Date;

/**
 *
 * @author Sebas
 */
public class MethodsEvent {
    //lista doble circular, ordenada por fecha del evento.
    public Event inicioEvento, ultimoEvento;
    
    //insertar ordenado 
    
    public static MethodsEvent instance = null;
    public static MethodsEvent getInstance(){
        if(instance == null){
            instance = new MethodsEvent();
        }
        return instance;
    }
    
    public Event buscarEvento(int IDEvento){
        Event aux = inicioEvento;
        while (aux != null){
            if (aux.getIDEvent()== IDEvento){
                return aux;
            }
            aux = aux.nextEvent;
        }
        return null;
    }
    
    public boolean eliminarEvento(int IDEvento){
        Event aux = buscarEvento(IDEvento);
        
        if (aux==null){
            System.out.println("No existe");
            return false;
        }
        if (aux == inicioEvento){ // para el inicio
            if (inicioEvento.nextEvent==null){ // si existe un único elemento
                inicioEvento=ultimoEvento=null;
            }else{ //si existen mas de un elemento
                inicioEvento=inicioEvento.nextEvent; 
                inicioEvento.antEvent=null;
            }
            return true;
        }
        if (aux==ultimoEvento){ //para el caso de que sea el ultimo 
            //no se va a caer porque ya validé que existan varios elementos
            ultimoEvento=ultimoEvento.antEvent;
            ultimoEvento.nextEvent=null;
            return true;
        } //si está en el medio y no se cae 
        (aux.antEvent).nextEvent = aux.nextEvent; //aux.ant muevase al que está antes de ant, (aux.ant).sig 
        (aux.nextEvent).antEvent = aux.antEvent;
        return true;
    }
    
    public boolean modificarEvento(int IDEvento, String NombreDelEvento, String DescripcionDelEvento, String Ciudad, Date FechaDelEvento){
        Event aux=buscarEvento(IDEvento);
        if (aux==null){
            return false;
        }
        aux.setNameEvent(NombreDelEvento);
        aux.setDescriptionEvent(DescripcionDelEvento);
        aux.setCity(Ciudad);
        aux.setDateEvet(FechaDelEvento); 
        return true;
    }
}
