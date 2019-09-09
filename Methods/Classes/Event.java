/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Sebas
 */
public class Event {
    private int IDEvent;
    private String nameEvent;
    private String DescriptionEvent;
    private String City;
    private Date dateEvet;
    private String stateEvent="pendiente";
    public Event nextEvent, antEvent;

    public Event(int IDEvent, String nameEvent, String DescriptionEvent, String City, Date dateEvet) {
        this.IDEvent = IDEvent;
        this.nameEvent = nameEvent;
        this.DescriptionEvent = DescriptionEvent;
        this.City = City;
        this.dateEvet = dateEvet;
    }

    public int getIDEvent() {
        return IDEvent;
    }

    public void setIDEvent(int IDEvent) {
        this.IDEvent = IDEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getDescriptionEvent() {
        return DescriptionEvent;
    }

    public void setDescriptionEvent(String DescriptionEvent) {
        this.DescriptionEvent = DescriptionEvent;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public Date getDateEvet() {
        return dateEvet;
    }

    public void setDateEvet(Date dateEvet) {
        this.dateEvet = dateEvet;
    }

    public String getStateEvent() {
        return stateEvent;
    }

    public void setStateEvent(String stateEvent) {
        this.stateEvent = stateEvent;
    }
    
    
}
