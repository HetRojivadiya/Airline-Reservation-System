/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Airline;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author hetro
 */
public class SkyLinePage1 extends javax.swing.JFrame {

    /**
     * Creates new form SkyLinePage1
     */
    public SkyLinePage1() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        CheckTickets();
    }

    public void CheckTickets() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");

            Statement stm = conn.createStatement();
            Statement stm1 = conn.createStatement();
            Statement stm2 = conn.createStatement();

            ResultSet rs = stm.executeQuery("select * from flight");

            while (rs.next()) {

                String dateString = "Jul 10, 2023";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, u");

                LocalDate currentDate = LocalDate.now();
                LocalDate date = LocalDate.parse(dateString, formatter);

                int todayMonth = currentDate.getMonthValue();
                int dateMonth = date.getMonthValue();

                int day = currentDate.getDayOfMonth();
                int ticketday = date.getDayOfMonth();
                // Compare the months

                if ((todayMonth == dateMonth) && (ticketday - day <= 2)) {

                    ResultSet rs1 = stm1.executeQuery("select * from ticket where Flight_No=" + rs.getInt(1) + "");

                    int count = 0;

                    while (rs1.next()) {
                        String seat = rs1.getString(9);

                        for (int i = 0; i < seat.length(); i++) {
                            char t = seat.charAt(i);
                            if (t == ' ') {
                                count++;
                            }
                        }

                    }
                    if (count <= 20) {

                        PreparedStatement ps = conn.prepareStatement("delete from flight  where Flight_No=" + rs.getInt(1));
                        ps.executeUpdate();

                        ResultSet rs2 = stm2.executeQuery("select email from ticket inner join accounts on ticket.Mobile=accounts.mobile where Flight_No=" + rs.getInt(1));

                        while (rs2.next()) {
                            //EmailSender.main();
                        }

                        PreparedStatement ps1 = conn.prepareStatement("delete from ticket where Flight_No=" + rs.getInt(1));
                        ps1.executeUpdate();
                    }
                }

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

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel2.setText("UserName");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 150, 100, 20);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1);
        jTextField1.setBounds(140, 140, 190, 30);

        jLabel3.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel3.setText("Password");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(30, 210, 100, 22);

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        jPanel3.add(jPasswordField1);
        jPasswordField1.setBounds(140, 200, 190, 30);

        jLabel4.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel4.setText("If you havn't Account Click here.");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 330, 170, 15);

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Create New Account");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel5);
        jLabel5.setBounds(200, 320, 140, 30);

        jLabel6.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jLabel6.setText("User Login");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(30, 30, 170, 70);

        jButton1.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(140, 250, 190, 30);

        jLabel7.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel7.setText("Forget Passworld");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel7);
        jLabel7.setBounds(180, 290, 110, 18);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(500, 320, 370, 350);

        jLabel1.setFont(new java.awt.Font("MV Boli", 3, 60)); // NOI18N
        jLabel1.setText("Welcome To SkyLine");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(390, 40, 640, 220);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Airline/images/ar1.jpg"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-90, -30, 1380, 820);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1380, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        jPasswordField1.setText(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        CreateAccount ca = new CreateAccount();
        ca.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        if (jTextField1.getText().equals("") || jPasswordField1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please First Enter Your Username and Password");
        } else {
            try {
                String u = jTextField1.getText();
                String p = jPasswordField1.getText();

                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
                Statement s = con.createStatement();

                ResultSet rs = s.executeQuery("SELECT * FROM accounts WHERE (Mobile='" + u + "' OR Email='" + u + "') AND Password='" + p + "'");

                if (rs.next() != false) {
                    if (rs.getInt(1) == 1) {
                        ControlRoom c = new ControlRoom();
                        c.setVisible(true);
                        dispose();

                    } else {
                        temp.tempMobile = rs.getString(4);
                        temp.tempEmail = rs.getString(5);
                        temp.tempuser = u;
                        temp.temppassword = p;
                        temp.tempFname = rs.getString(2);
                        temp.tempLname = rs.getString(3);
                        AR2 obj = new AR2();
                        obj.setVisible(true);
                        dispose();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Username and Password is not Match");
                }
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        forgotPassword p = new forgotPassword();
        p.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(SkyLinePage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SkyLinePage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SkyLinePage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SkyLinePage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SkyLinePage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
