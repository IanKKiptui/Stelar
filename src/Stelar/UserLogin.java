/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stelar;

/**
 *
 * @author Leeroy
 */
import java.sql.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class UserLogin extends javax.swing.JFrame {
    static String url = "jdbc:mysql://localhost:3306/stelar";
    static String username = "root";
    static String password = "";
    String usern, pass,pass1;
    static String userlogged;
    
    /**
     * Creates new form UserLogin
     */
    public UserLogin() {
        initComponents();
        checkUsers();
        setLocationRelativeTo(null);
        this.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            @Override
                    public void windowClosing(java.awt.event.WindowEvent e) 
                    {
                        int y;
                        y=JOptionPane.showConfirmDialog(jPanel1,"Do Really You Want to Quit The Application?","Confirm!",JOptionPane.YES_NO_OPTION);
                        if(y==JOptionPane.YES_OPTION)
                        {
                        System.exit(0);
                         }
                    }
        });
    }
private void checkUsers()
{
try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url, username, password);
           String sql = "SELECT Username FROM login";
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet resultSet = stmt.executeQuery();
           while (resultSet.next()) 
            {
               user.addItem(resultSet.getString(1));
            }
           conn.close();
}
catch (Exception exc) 
      {  // process error
            System.out.println("process error" + exc);
            JOptionPane.showMessageDialog(jPanel1,"Sorry, An Error Occurred","Error!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
      }
      }
private void PassCheck()
{
usern=(String)user.getSelectedItem();
pass=new String(pas.getPassword());

try {
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn = DriverManager.getConnection(url, username, password);
     String sql = "SELECT Password FROM login WHERE Username='"+usern+"'";
     PreparedStatement stmt = conn.prepareStatement(sql);
     ResultSet resultSet = stmt.executeQuery();
     while (resultSet.next()) 
     {
       pass1=resultSet.getString(1);
          }
     conn.close();
    } 
catch (Exception exc) 
    {  // process error
            System.out.println("process error" + exc);
    } 
if(pass.equals(pass1))
    {
        userlogged=usern;
        this.dispose();
       new StelarHome().setVisible(true);
    }
 else
     {
     JOptionPane.showMessageDialog(jPanel1," Wrong Password You Entered!","Wrong Input!",JOptionPane.WARNING_MESSAGE);
     pas.setText("");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        pas = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("User Log In");

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password:");

        user.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username:");

        pas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jToggleButton1.setText("Login");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jToggleButton2.setText("Cancel");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(user, 0, 155, Short.MAX_VALUE)
                    .addComponent(pas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasActionPerformed
String passw;
        passw=new String(pas.getPassword());
        if(passw.equals(""))
            {
            JOptionPane.showMessageDialog(jPanel1,"Please enter your password!","Missing Passorwd!",JOptionPane.INFORMATION_MESSAGE);
            pas.requestFocus();

            } 
        else
        {PassCheck();}        // TODO add your handling code here:
    }//GEN-LAST:event_pasActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
            int y;
            y=JOptionPane.showConfirmDialog(jPanel1,"Do Really You Want to Exit This Part Of Application?","Confirm!",JOptionPane.YES_NO_OPTION);
                if(y==JOptionPane.YES_OPTION)
                    {
                        this.dispose();
                    }        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
String passw;
        passw=new String(pas.getPassword());
        if(passw.equals(""))
            {
            JOptionPane.showMessageDialog(jPanel1,"Sorry, you did not enter the password!","Missing Passorwd!",JOptionPane.INFORMATION_MESSAGE);
            pas.requestFocus();

            } 
        else
        {PassCheck();}// TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPasswordField pas;
    private javax.swing.JComboBox<String> user;
    // End of variables declaration//GEN-END:variables
}
