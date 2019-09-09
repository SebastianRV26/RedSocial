/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import report.*;

/**
 *
 * @author yosin
 */
public class ReportMethods {
    
    ReportClass inicio,ultimo;

    public ReportMethods() {
        this.inicio = null;
        this.ultimo = null;
    }
    

    public boolean insertar( String nombre, String observacionCliente, String obervacionAdministrador, String estado){
        ReportClass nuevo = new ReportClass (nombre,observacionCliente,obervacionAdministrador,estado);
        
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
    
    
    public void toPrint(){
    
        ReportClass aux=inicio;
        if(aux.sig==inicio){
            System.out.println(aux.getNombre());
        }else{
            do{
                aux=aux.sig;
                System.out.println(aux.getNombre());
            } while(aux!=inicio);

        }  
        
}
}
