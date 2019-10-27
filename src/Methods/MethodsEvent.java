/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Classes.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author yosiney
 */
public class MethodsEvent {
    //lista doble circular, ordenada por fecha del evento.
    public Event inicioEvento, ultimoEvento;
    UserMethods met = UserMethods.getInstance();
    //insertar ordenado 
    
    public static MethodsEvent instance = null;
    public static MethodsEvent getInstance(){
        if(instance == null){
            instance = new MethodsEvent();
        }
        return instance;
    }
    public boolean insertarInicioCircular( String nameEvent, String DescriptionEvent, String City, Date dateEvet){
        
        
        Event nuevo = new Event(nameEvent,DescriptionEvent,City,dateEvet);
        
        
      
        
            if(inicioEvento == null){
                inicioEvento = nuevo;
                ultimoEvento = inicioEvento;
                inicioEvento.nextEvent = ultimoEvento;
                inicioEvento.antEvent = ultimoEvento;
                ultimoEvento.nextEvent = inicioEvento;
                ultimoEvento.antEvent = inicioEvento;
                met.MeterArchivo();
                MeterArchivo();
                return true;
            }
            
            if(nuevo.getDateEvet().compareTo(inicioEvento.getDateEvet())<=0){
                
                nuevo.nextEvent = inicioEvento;
                nuevo.antEvent = ultimoEvento;
                inicioEvento.antEvent = nuevo;
                inicioEvento = nuevo;
                met.MeterArchivo();
                MeterArchivo();
                
                return true;
            }
            if(nuevo.getDateEvet().compareTo(ultimoEvento.getDateEvet())>=0){
                
                nuevo.antEvent = ultimoEvento;
                nuevo.nextEvent = inicioEvento;
                ultimoEvento.nextEvent = nuevo;
                ultimoEvento = nuevo;
                met.MeterArchivo();
                MeterArchivo();
                return true;
            }
            Event aux=inicioEvento;
            while(aux != null){
                if(nuevo.getDateEvet().compareTo(aux.getDateEvet())>0){
                    aux.antEvent.nextEvent =nuevo;
                    nuevo.nextEvent = aux;
                    nuevo.antEvent = aux.antEvent;
                    aux.antEvent = nuevo;
                    met.MeterArchivo();
                    MeterArchivo();
                    return true;
                }
                aux=aux.nextEvent;
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
            
            return false;
        }
        if (aux.getIDEvent() == inicioEvento.getIDEvent()){ // para el inicio
            if (inicioEvento.nextEvent==null){ // si existe un único elemento
                inicioEvento=ultimoEvento=null;
            }else{ //si existen mas de un elemento
                inicioEvento=inicioEvento.nextEvent; 
                inicioEvento.antEvent=null;
            }
            met.MeterArchivo();
            MeterArchivo();
            return true;
        }
        if (aux.getIDEvent()==ultimoEvento.getIDEvent()){ //para el caso de que sea el ultimo 
            //no se va a caer porque ya validé que existan varios elementos
            ultimoEvento=ultimoEvento.antEvent;
            ultimoEvento.nextEvent=null;
            met.MeterArchivo();
            MeterArchivo();
            return true;
        } //si está en el medio y no se cae 
        (aux.antEvent).nextEvent = aux.nextEvent; //aux.ant muevase al que está antes de ant, (aux.ant).sig 
        (aux.nextEvent).antEvent = aux.antEvent;
        met.MeterArchivo();
        MeterArchivo();
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
        met.MeterArchivo();
        MeterArchivo();
        return true;
    }
    
    
    public void toPrint(){
    
        Event aux = inicioEvento;
        if(aux.nextEvent.getIDEvent()==inicioEvento.getIDEvent()){
            System.out.println(aux.getDateEvet());
        }else{
            do{
                aux=aux.nextEvent;
                System.out.println(aux.getDateEvet());
            } while(aux.getIDEvent()!=inicioEvento.getIDEvent());

        } 
    }
    
    
    public boolean Eliminar(int IDEvento){
        
       Event aux = buscarEvento(IDEvento);
        
        if(aux == null){
            JOptionPane.showMessageDialog(null, "No existe");
            
            return false;
        }
        if(aux == inicioEvento){
            if(inicioEvento.nextEvent.getIDEvent() == inicioEvento.getIDEvent()){
                inicioEvento = ultimoEvento = null;
                met.MeterArchivo();
                MeterArchivo();
                return true;
            }else{
                inicioEvento.nextEvent.antEvent = ultimoEvento;
                inicioEvento.antEvent.nextEvent = inicioEvento.nextEvent;
                inicioEvento.antEvent = null ;
                inicioEvento = inicioEvento.nextEvent;
                met.MeterArchivo();
                MeterArchivo();
                return true;
            }
            
        }
        if(aux == ultimoEvento){
          ultimoEvento.antEvent.nextEvent = inicioEvento;
          inicioEvento.antEvent = ultimoEvento.antEvent;
          ultimoEvento.nextEvent = null;
          ultimoEvento = ultimoEvento.antEvent;
          met.MeterArchivo();
          MeterArchivo();
          return true;  
        }else{
        
        aux.antEvent.nextEvent = aux.nextEvent;
        aux.nextEvent.antEvent= aux.antEvent;
        aux.nextEvent = null;
        aux.antEvent = null;
        met.MeterArchivo();
        MeterArchivo();
        return true;
        }
        
    }
    
    public void MeterArchivo(){
        try{
            ObjectOutputStream escribiendo = new ObjectOutputStream(new FileOutputStream("./Eventos.txt"));
            escribiendo.writeObject(inicioEvento);
            
            
            ObjectOutputStream escribiendo2 = new ObjectOutputStream(new FileOutputStream("./Eventosfin.txt"));
            escribiendo2.writeObject(ultimoEvento);
            escribiendo.close();
            escribiendo2.close();
        }catch(IOException e){
            
        }
    }
    
    public void SacarArchivo(){
        try{
            ObjectInputStream sacar = new ObjectInputStream(new FileInputStream("./Eventos.txt"));
             inicioEvento = (Event)sacar.readObject();
             
             
             ObjectInputStream sacar2 = new ObjectInputStream(new FileInputStream("./Eventosfin.txt"));
             ultimoEvento = (Event)sacar2.readObject();
             sacar2.close();
             sacar.close();
        }catch(IOException | ClassNotFoundException e){
            
        }
        Event aux = inicioEvento;
        while(aux.getIDEvent() != ultimoEvento.getIDEvent()){
            aux = aux.nextEvent;
        }
        ultimoEvento = aux;
    }
}
