/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Classes.*;
import Main.Main;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author yosin
 */
public class ReportMethods implements Serializable{
    UserMethods met = UserMethods.getInstance();
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
            MeterArchivo();
            met.MeterArchivo();
            return true;
        }
        
       
            nuevo.sig=inicio;
            nuevo.ant=ultimo;
            inicio.ant=nuevo;
            ultimo.sig=nuevo;
            inicio=nuevo;
            MeterArchivo();
            met.MeterArchivo();
            return true;
        
        
       
    }
    
    public ReportClass searchReport(int id){
        ReportClass nuevo=Main.List.inicio;
            if(nuevo.sig==Main.List.inicio){
                if(nuevo.getId()==id){
                    return nuevo;
                }else{
                    return null;
                }  
            }else{
                do{
                    if(nuevo.getId()==id){
                        nuevo=nuevo.sig;
                        return nuevo;
                    }
                    nuevo=nuevo.sig;

                } while(nuevo!=Main.List.inicio);
               return null; 
    }
    }
    public ReportClass searchReport2(int id){
        ReportClass nuevo=Main.List.inicio;
            if(nuevo.sig.getId()==Main.List.inicio.getId()){
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
                    }
                    nuevo=nuevo.sig;

                } while(nuevo.getId()!=Main.List.inicio.getId());
               return null; 
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
    public void MeterArchivo(){
        try{
            ObjectOutputStream escribiendo = new ObjectOutputStream(new FileOutputStream("./Reporte.txt"));
            escribiendo.writeObject(inicio);
            
            
            ObjectOutputStream escribiendo2 = new ObjectOutputStream(new FileOutputStream("./reportefin.txt"));
            escribiendo2.writeObject(ultimo);
            escribiendo.close();
            escribiendo2.close();
        }catch(IOException e){
            
        }
    }
    
    public void SacarArchivo(){
        try{
            ObjectInputStream sacar = new ObjectInputStream(new FileInputStream("./Reporte.txt"));
             inicio = (ReportClass)sacar.readObject();
             
             
             ObjectInputStream sacar2 = new ObjectInputStream(new FileInputStream("./reportefin.txt"));
             ultimo = (ReportClass)sacar2.readObject();
             sacar2.close();
             sacar.close();
        }catch(IOException | ClassNotFoundException e){
            
        }
        ReportClass aux = inicio;
        while(aux.getId()!= ultimo.getId()){
            aux = aux.sig;
        }
        ultimo = aux;
    }   

    
}
