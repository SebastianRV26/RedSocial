/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.Event;

import Main.Main;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import static Frames.EventUser.events;
import Methods.MethodsFriendList;
import Methods.MethodsUserEvent;
import Methods.UserMethods;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author yosin
 */
public class EventsInvite extends javax.swing.JFrame {
DefaultListModel<String> myevents= new DefaultListModel<>();
DefaultListModel<String> invite= new DefaultListModel<>();

    /**
     * Creates new form EventsInvite
     */
    public EventsInvite() {
        initComponents();
        //Main.toUpdate();
        list();
        invite();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Mis Eventos");

        jLabel2.setText("Id Evento");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel4.setText("Invitado a ");

        jScrollPane2.setViewportView(jList2);

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(35, 35, 35))))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        EventUser even= new EventUser();
        this.dispose();
        even.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Main.toUpdate();
            int id= Integer.parseInt(jTextField1.getText());
            Event eve=searchEvent(id);
            if(eve.getStateEvent().equals("Pendiente")){
                
                if(jTextField1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"No digito el id del evento");
                }
            
                String cancel= "Cancelado";
                cancel(cancel);
                            
            }else{
                JOptionPane.showMessageDialog(null,"El evento ya se realizo o cancelo");
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error");
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EventsInvite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventsInvite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventsInvite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventsInvite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventsInvite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    
    public void list(){
         try{
            Event eve= Main.event.inicioEvento;
            int userLogin= Main.user.identification;
            if(eve.nextEvent.getIDEvent()==Main.event.inicioEvento.getIDEvent()){
                if(eve.getSend()==userLogin && eve.getStateEvent().equals("Pendiente")){
                    myevents.addElement("Reporte: "+eve.getNameEvent());
                    myevents.addElement(" ID reporte: "+eve.getIDEvent());
                    myevents.addElement(" ");
                    jList1.setModel(myevents);
                }
             }else{
                 do{
                    eve=eve.nextEvent;
                    if(eve.getSend()==userLogin && eve.getStateEvent().equals("Pendiente")){
                        myevents.addElement("Reporte: "+eve.getNameEvent());
                        myevents.addElement(" ID reporte: "+eve.getIDEvent());
                        myevents.addElement(" ");
                        jList1.setModel(myevents);
                    }
                 } while(eve.getIDEvent()!=Main.event.inicioEvento.getIDEvent());
                 jList1.setModel(myevents);
             } 
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"No hay eventos de momento");
           
       }
         
         
         
         
     }
    
    public void cancel(String cancel){
        
       
        int id= Integer.parseInt(jTextField1.getText());
        Event eve=searchEvent(id);

                if(eve!=null){
                    eve.setStateEvent(cancel);
                    JOptionPane.showMessageDialog(null,"Se modifico");
                    list();
                }else{
                    JOptionPane.showMessageDialog(null,"Verifique se exista el evento");
                }
    }
    
    
    public Event searchEvent(int id){
        int userLogin= Main.user.identification;
         Event nuevo=Main.event.inicioEvento;
         if(jTextField1.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"No ha selecciona el id del evento que desea modificar");
         }
         if(nuevo == null){
             return null;
         }
         if(nuevo.nextEvent==Main.event.inicioEvento){
             if(nuevo.getIDEvent()==Integer.parseInt(jTextField1.getText())){
                 if(nuevo.getSend()==userLogin){
                 return nuevo;
                }
            }
             
         }else{
             do{
                 if(nuevo.getIDEvent()==Integer.parseInt(jTextField1.getText())){
                    if(nuevo.getSend()==userLogin){
                    
                        return nuevo;
                    }
                }
                nuevo=nuevo.nextEvent;
             }while(nuevo!=Main.event.inicioEvento);
             
         }
        return null;
        
    }
    
    
    public void invite(){
        
        Event eve= Main.event.inicioEvento;
        int id= Main.user.identification;
        do{
            if(eve.user==null){
                return;
            }
            while(eve.user!= null){
                if(eve.user.User.identification==id){
                    
                    invite.addElement(eve.getNameEvent());
                    
                }
                eve.user=eve.user.next;
            }
            eve=eve.nextEvent;
        }while(eve!=Main.event.inicioEvento);
        jList2.setModel(invite);
        
        /*
        int id=Main.user.identification;
        Event eve= Main.event.inicioEvento;
        if(eve.nextEvent==Main.event.inicioEvento){
            System.out.println(eve.getNameEvent());
            while(eve.user!=null){
                System.out.println(eve.user.User.name);
            }
        }else{
            do{
                System.out.println(eve.getNameEvent());
                if(eve.user==null){
                    System.out.println("No lo invitaron");
                }
                while(eve.user!=null){
                    System.out.println(eve.user.User.name);
                    eve.user=eve.user.next;
                }
                
                eve=eve.nextEvent;
                
            } while(eve!=Main.event.inicioEvento);

        } 
        */
        
        
                 

    }

}
