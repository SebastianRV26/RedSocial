/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Classes.ReportClass;
import Classes.User;
import Main.Main;
import java.io.Serializable;


/**
 *
 * @author yosin
 */
public class MethodsUserReports implements Serializable{
    UserMethods met = UserMethods.getInstance();
    public static MethodsUserReports instance = null;
    public static MethodsUserReports getInstance(){
        if(instance == null){
            instance = new MethodsUserReports();
        }
        return instance;
    }
     public int insertSub(int users){
         UserMethods user= UserMethods.getInstance();
         User aux=user.buscarCliente(users);
         
     ReportClass searchreport= Main.List.searchReport2(users);
            
     if(aux==null){ 
         return 0;
     }
     if(searchreport==null){
         return 0;
     }
     
    if(aux.nextReportUser==null){
        aux.nextReportUser=searchreport;
        met.MeterArchivo();
        Main.List.MeterArchivo();
        return 2;
     
    }
         
    searchreport.user=aux.nextReportUser.user;
    aux.nextReportUser.user=searchreport.user;
    System.out.println(aux.nextReportUser);
         System.out.println(searchreport.user);
         met.MeterArchivo();
        Main.List.MeterArchivo();
    return 2;
}
        
   
}
