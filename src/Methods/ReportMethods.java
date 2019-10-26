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
 * @author yosin
 */
public class ReportMethods {
    
    public ReportClass inicio,ultimo;

    public ReportMethods() {
        this.inicio = null;
        this.ultimo = null;
    }
    

    public boolean insertar( String name, String observationClient, String observationAdmi, String state, int id){
        ReportClass nuevo = new ReportClass (name,observationClient,observationAdmi,state,id);
        
        if (inicio==null){
            inicio=ultimo=nuevo;
            inicio.sig=ultimo;
            ultimo.sig=inicio;
            inicio.ant=inicio;
            ultimo.ant=inicio;
            return true;
        }
        
       
            nuevo.sig=inicio;
            nuevo.ant=ultimo;
            inicio.ant=nuevo;
            ultimo.sig=nuevo;
            inicio=nuevo;
            return true;
        
        
       
    }
    
    public ReportClass searchReport(int id){
        ReportClass nuevo=Main.List.inicio;
            if(nuevo.sig==Main.List.inicio){
                if(nuevo.getIdsend()==id){
                    return nuevo;
                }else{
                    return null;
                }  
            }else{
                do{
                    if(nuevo.getIdsend()==id){
                        nuevo=nuevo.sig;
                        return nuevo;
                    }else{
                       return null;
                    }

                } while(nuevo!=Main.List.inicio);
                
    }
    }
    public void toPrint(){
    
        ReportClass aux=inicio;
        if(aux.sig==inicio){
            System.out.println(aux.getName());
        }else{
            do{
                aux=aux.sig;
                System.out.println(aux.getName());
            } while(aux!=inicio);

        }  
        
}

    
}
