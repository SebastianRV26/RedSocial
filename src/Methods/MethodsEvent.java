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
    Event inicioEvento, ultimoEvento;
    
    //insertar ordenado 
    
    public static MethodsEvent instance = null;
    public static MethodsEvent getInstance(){
        if(instance == null){
            instance = new MethodsEvent();
        }
        return instance;
    }
    public boolean insertarInicioCircular(int IDEvent, String nameEvent, String DescriptionEvent, String City, Date dateEvet){
        Event nuevo = new Event(IDEvent,nameEvent,DescriptionEvent,City,dateEvet);
        if(buscarEvento(nuevo.getIDEvent()) == null){
            if(inicioEvento == null){
                inicioEvento = nuevo;
                ultimoEvento = inicioEvento;
                inicioEvento.nextEvent = ultimoEvento;
                inicioEvento.antEvent = ultimoEvento;
                ultimoEvento.nextEvent = inicioEvento;
                ultimoEvento.antEvent = inicioEvento;
                return true;
            }
            if(nuevo.getDateEvet().compareTo(inicioEvento.getDateEvet())<=0){
                nuevo.nextEvent = inicioEvento;
                nuevo.antEvent = ultimoEvento;
                inicioEvento.antEvent = nuevo;
                inicioEvento = nuevo;
                return true;
            }
            if(nuevo.getDateEvet().compareTo(ultimoEvento.getDateEvet())>=0){
                nuevo.antEvent = ultimoEvento;
                nuevo.nextEvent = inicioEvento;
                ultimoEvento.nextEvent = nuevo;
                ultimoEvento = nuevo;
                return true;
            }
            Event aux=inicioEvento;
            while(aux != null){
                if(nuevo.getDateEvet().compareTo(aux.getDateEvet())>0){
                    aux.antEvent.nextEvent =nuevo;
                    nuevo.nextEvent = aux;
                    nuevo.antEvent = aux.antEvent;
                    aux.antEvent = nuevo;
                    return true;
                }
                aux=aux.nextEvent;
            }
        }
        return false;
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
