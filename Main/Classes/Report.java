/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author yosin
 */
public class Report {
    
     
    public static ReportMethods List;
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        List= new ReportMethods();
        FrameUser reportUser= new FrameUser();
        reportUser.setVisible(true);
        
        
    }
    
}
