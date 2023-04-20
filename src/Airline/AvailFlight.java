/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hetro
 */
public class AvailFlight extends javax.swing.JFrame {

    String flight;
    int Spicejet = 0, Vistara = 0, IndiGo = 0, AirAsia = 0;

    /**
     * Creates new form AvailFlight
     */
    public AvailFlight() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        

        flight = temp.tempFlight;

        if (flight == "Spicejet") {
            b1.setSelected(true);

        } else if (flight == "Vistara") {
            b2.setSelected(true);
        } else if (flight == "indiGo") {
            b3.setSelected(true);
        } else if (flight == "AirAsia") {
            b4.setSelected(true);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
            Statement s = con.createStatement();

            String u = temp.tempLocation;
            String p = temp.tempDestination;
            String d = temp.tempDate;

            ResultSet rs = s.executeQuery("SELECT * FROM flight WHERE Location='" + u + "' AND Destination='" + p + "' AND Date='" + d + "'");

            while (rs.next()) {

                if (rs.getString(6).equals("Spicejet")) {
                    sp.setText(rs.getString(4));
                    st.setText(rs.getString(5));
                    
                } else if (rs.getString(6).equals("Vistara")) {
                    vp.setText(rs.getString(4));
                    vt.setText(rs.getString(5));
                } else if (rs.getString(6).equals("IndiGo")) {
                    ip.setText(rs.getString(4));
                    it.setText(rs.getString(5));
                } else if (rs.getString(6).equals("AirAsia")) {
                    ap.setText(rs.getString(4));
                    at.setText(rs.getString(5));
                }
            }
            if (sp.getText().equals("")) {
                Spicejet = 1;
                sp.setText("Flight Not Available");
            }
            if (vp.getText().equals("")) {
                Vistara = 1;
                vp.setText("Flight Not Available");
            }
            if (ip.getText().equals("")) {
                IndiGo = 1;
                ip.setText("Flight Not Available");
            }
            if (ap.getText().equals("")) {
                AirAsia = 1;
                ap.setText("Flight Not Available");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        b4 = new javax.swing.JRadioButton();
        b1 = new javax.swing.JRadioButton();
        b2 = new javax.swing.JRadioButton();
        b3 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        sp = new javax.swing.JLabel();
        vp = new javax.swing.JLabel();
        ip = new javax.swing.JLabel();
        vt = new javax.swing.JLabel();
        ap = new javax.swing.JLabel();
        st = new javax.swing.JLabel();
        sp4 = new javax.swing.JLabel();
        sp3 = new javax.swing.JLabel();
        sp2 = new javax.swing.JLabel();
        sp1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        at = new javax.swing.JLabel();
        it = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/AvailFlight.jpg"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(420, 0, 500, 190);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/spicejet logo.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(420, 230, 130, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/vistara-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(420, 330, 130, 90);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/indiGo.jpg"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(420, 450, 120, 90);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/AirAsia India.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(410, 570, 140, 70);

        buttonGroup1.add(b4);
        jPanel2.add(b4);
        b4.setBounds(360, 590, 20, 19);

        buttonGroup1.add(b1);
        jPanel2.add(b1);
        b1.setBounds(360, 260, 20, 19);

        buttonGroup1.add(b2);
        jPanel2.add(b2);
        b2.setBounds(360, 370, 20, 19);

        buttonGroup1.add(b3);
        jPanel2.add(b3);
        b3.setBounds(360, 490, 20, 19);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/button-removebg-preview.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8);
        jLabel8.setBounds(160, 30, 60, 60);

        sp.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jPanel2.add(sp);
        sp.setBounds(710, 270, 270, 30);

        vp.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jPanel2.add(vp);
        vp.setBounds(710, 370, 270, 30);

        ip.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jPanel2.add(ip);
        ip.setBounds(710, 480, 270, 30);

        vt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel2.add(vt);
        vt.setBounds(910, 370, 120, 30);

        ap.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jPanel2.add(ap);
        ap.setBounds(710, 590, 260, 30);

        st.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel2.add(st);
        st.setBounds(910, 270, 130, 30);

        sp4.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        sp4.setText("$");
        jPanel2.add(sp4);
        sp4.setBounds(690, 370, 20, 30);

        sp3.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        sp3.setText("$");
        jPanel2.add(sp3);
        sp3.setBounds(690, 480, 20, 30);

        sp2.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        sp2.setText("$");
        jPanel2.add(sp2);
        sp2.setBounds(690, 590, 20, 30);

        sp1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        sp1.setText("$");
        jPanel2.add(sp1);
        sp1.setBounds(690, 270, 20, 30);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel2.add(jLabel14);
        jLabel14.setBounds(910, 590, 110, 0);

        at.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel2.add(at);
        at.setBounds(910, 590, 120, 30);

        it.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel2.add(it);
        it.setBounds(910, 480, 120, 30);

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(290, 200, 760, 460);

        jToggleButton1.setBackground(new java.awt.Color(102, 255, 102));
        jToggleButton1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jToggleButton1.setText("Choose Seat ");
        jToggleButton1.setOpaque(true);
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton1);
        jToggleButton1.setBounds(1060, 410, 230, 60);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1380, 750);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1380, 750);

        getAccessibleContext().setAccessibleName("avail");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        AR2 p;
        try {
            p = new AR2();
             p.setVisible(true);
        dispose();
        } catch (ParseException ex) {
            Logger.getLogger(AvailFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked

        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select first");
        } else {
            b1.setActionCommand("Spicejet");
            b2.setActionCommand("Vistara");
            b3.setActionCommand("indiGo");
            b4.setActionCommand("AirAsia");

            temp.tempFlight = (String) buttonGroup1.getSelection().getActionCommand();

            int NotAvail = 0;

            if (temp.tempFlight == "Spicejet" && Spicejet == 0) {
                temp.tempTime = st.getText();
            } else if (temp.tempFlight == "Vistara" && Vistara == 0) {
                temp.tempTime = vt.getText();
            } else if (temp.tempFlight == "indiGo" && IndiGo == 0) {
                temp.tempTime = it.getText();
            } else if (temp.tempFlight == "AirAsia" && AirAsia == 0) {
                temp.tempTime = at.getText();
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Available Flight");
                NotAvail = 1;
            }
            
            try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
            Statement s = con.createStatement();

            String u = temp.tempLocation;
            String p = temp.tempDestination;
            String d = temp.tempDate;

            ResultSet rs = s.executeQuery("SELECT * FROM flight WHERE Location='" + u + "' AND Destination='" + p + "' AND Date='" + d + "' AND Flight='"+temp.tempFlight+"'" );
            rs.next();
            temp.Flight_no=rs.getInt(1);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                SeatChoose p = new SeatChoose();
                p.setVisible(true);
                dispose();
            

        }// TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1MouseClicked

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
            java.util.logging.Logger.getLogger(AvailFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvailFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvailFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvailFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AvailFlight().setVisible(true);
            }
        });
              
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ap;
    private javax.swing.JLabel at;
    private javax.swing.JRadioButton b1;
    private javax.swing.JRadioButton b2;
    private javax.swing.JRadioButton b3;
    private javax.swing.JRadioButton b4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel ip;
    private javax.swing.JLabel it;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel sp;
    private javax.swing.JLabel sp1;
    private javax.swing.JLabel sp2;
    private javax.swing.JLabel sp3;
    private javax.swing.JLabel sp4;
    private javax.swing.JLabel st;
    private javax.swing.JLabel vp;
    private javax.swing.JLabel vt;
    // End of variables declaration//GEN-END:variables
}
