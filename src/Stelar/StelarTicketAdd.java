/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stelar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Edith
 */
public class StelarTicketAdd extends javax.swing.JDialog {

    String url = "jdbc:mysql://localhost:3306/stelar";
    String username = "root";
    String password = "";
    Connection conn;
    String ps1,ps2,add;
    
    /**
     * Creates new form NewAlbum
     */
    public StelarTicketAdd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        checkMovies();
        checkHalls();
        
    }
    private void checkMovies()
{
try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url, username, password);
           String sql = "SELECT MovieName FROM movies";
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet resultSet = stmt.executeQuery();
           while (resultSet.next()) 
            {
               MovieName.addItem(resultSet.getString(1));
            }
           conn.close();
}
catch (Exception exc) 
      {  // process error
            System.out.println("process error" + exc);
            JOptionPane.showMessageDialog(createUser,"Sorry, An Error Occurred","Error!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
      }
      }
    private void checkHalls()
{
try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url, username, password);
           String sql = "SELECT HallName FROM hall";
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet resultSet = stmt.executeQuery();
           while (resultSet.next()) 
            {
               HallName.addItem(resultSet.getString(1));
            }
           conn.close();
}
catch (Exception exc) 
      {  // process error
            System.out.println("process error" + exc);
            JOptionPane.showMessageDialog(createUser,"Sorry, An Error Occurred","Error!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
      }
      }
private void regTickets()
{
try { 
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,username,password);
         PreparedStatement statement = conn.prepareStatement
         ("INSERT INTO tickets(MovieName,HallName,Date,Seat,Quantity,Price) VALUES(?,?,?,?,?,?)");
         statement.setString(1,MovieName.getSelectedItem().toString());
         statement.setString(2,HallName.getSelectedItem().toString());
         statement.setString(3,DateC.getText());
         statement.setString(4,seat.getText());
         statement.setString(5,Qty.getText());
         statement.setString(6,price.getText());
         
         statement.executeUpdate();
         statement.close();
                     int k;
            k=JOptionPane.showConfirmDialog(createUser,"Ticket details successfully saved.\nDo you wish to register another one?","SAVING",JOptionPane.YES_NO_OPTION);
        if(k==JOptionPane.YES_OPTION)
        {
                        
            this.dispose();
         StelarTicketAdd dialog = new StelarTicketAdd(new javax.swing.JFrame(), true);
                                dialog.setVisible(true);
        }
        else{
            
            this.dispose();}    
conn.close();
        }
         catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                       JOptionPane.showMessageDialog(createUser,"Sorry, An Error Occurred!","Error!",JOptionPane.ERROR_MESSAGE);
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

        createUser = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        MovieName = new javax.swing.JComboBox<>();
        HallName = new javax.swing.JComboBox<>();
        seat = new javax.swing.JTextField();
        DateC = new datechooser.beans.DateChooserCombo();
        Qty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New User");

        createUser.setBackground(new java.awt.Color(51, 51, 51));
        createUser.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Movie:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hall:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Seat:");

        jToggleButton1.setText("Discard");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Add Ticket");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        DateC.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    DateC.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
    DateC.setLocale(new java.util.Locale("en", "ZA", ""));
    DateC.setNavigateFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 11));
    DateC.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

    jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("Tickets Qty:");

    jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Price:");

    javax.swing.GroupLayout createUserLayout = new javax.swing.GroupLayout(createUser);
    createUser.setLayout(createUserLayout);
    createUserLayout.setHorizontalGroup(
        createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(createUserLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createUserLayout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jToggleButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                    .addComponent(jToggleButton2)
                    .addGap(72, 72, 72))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createUserLayout.createSequentialGroup()
                    .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Qty, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(MovieName, javax.swing.GroupLayout.Alignment.LEADING, 0, 211, Short.MAX_VALUE)
                            .addComponent(HallName, javax.swing.GroupLayout.Alignment.LEADING, 0, 211, Short.MAX_VALUE)
                            .addComponent(DateC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seat, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGap(35, 35, 35))))
    );
    createUserLayout.setVerticalGroup(
        createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(createUserLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(MovieName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(54, 54, 54)
            .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(HallName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(50, 50, 50)
            .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel4)
                .addComponent(DateC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(42, 42, 42)
            .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(seat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
            .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8))
            .addGap(42, 42, 42)
            .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(26, 26, 26)
            .addGroup(createUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jToggleButton1)
                .addComponent(jToggleButton2))
            .addGap(40, 40, 40))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(createUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(createUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if(seat.getText().equals(""))
        {
        JOptionPane.showMessageDialog(createUser,"Sorry, you did not enter the seat number!","Missing ID!",JOptionPane.INFORMATION_MESSAGE);
        seat.requestFocus();
        }
        else if(price.getText().equals(""))
        {
        JOptionPane.showMessageDialog(createUser,"Sorry, you did not the price of tickets to be placed!","Missing Price!",JOptionPane.INFORMATION_MESSAGE);
        price.requestFocus();
        }
        else if(Qty.getText().equals(""))
        {
        JOptionPane.showMessageDialog(createUser,"Sorry, you did not the number of tickets to be placed!","Missing Quantity!",JOptionPane.INFORMATION_MESSAGE);
        Qty.requestFocus();
        }
        else
        {
        regTickets();
        }

    }//GEN-LAST:event_jToggleButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StelarTicketAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StelarTicketAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StelarTicketAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StelarTicketAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                StelarTicketAdd dialog = new StelarTicketAdd(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo DateC;
    private javax.swing.JComboBox<String> HallName;
    private javax.swing.JComboBox<String> MovieName;
    private javax.swing.JTextField Qty;
    private javax.swing.JPanel createUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField price;
    private javax.swing.JTextField seat;
    // End of variables declaration//GEN-END:variables
}
