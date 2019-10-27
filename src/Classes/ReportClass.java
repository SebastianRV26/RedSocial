/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Main.Main;
import java.io.Serializable;

/**
 *
 * @author yosin
 */
public class ReportClass implements Serializable{
    int send=Main.user.identification;
    public static int cont = 1;
    private int id;
    private int idsend;
    private String name;
    private String observationClient;
    private String observationAdmi;
    private String  state;
    private int idcard;
    public ReportClass sig;
    public ReportClass ant;
    public User user;

    public ReportClass( String name, String observationClient, String observationAdmi, String state, int idcard) {
        this.id= cont;
        this.idsend = send;
        this.name = name;
        this.observationClient = observationClient;
        this.observationAdmi = observationAdmi;
        this.state = state;
        this.idcard = idcard;
        cont++;
    }

   

   
    
    

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = cont;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservationClient() {
        return observationClient;
    }

    public void setObservationClient(String observationClient) {
        this.observationClient = observationClient;
    }

    public String getObservationAdmi() {
        return observationAdmi;
    }

    public void setObservationAdmi(String observationAdmi) {
        this.observationAdmi = observationAdmi;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIdcard() {
        return idcard;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    public int getIdsend() {
        
        return idsend;
    }

    public void setIdsend(int idsend) {
        this.idsend = send;
    }

    public void getState(String realizado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
   
    