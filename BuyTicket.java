/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stelar;

/**
 *
 * @author Edith
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.*;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
public class BuyTicket extends javax.swing.JDialog {

    String url = "jdbc:mysql://localhost:3306/stelar";
    String username = "root";
    String password = "";
    Connection conn;
    Statement stm; 
    JTable FoodsTable,stable;
    int A,B;
    JScrollPane scrollPane;
    String MovieName,HallName,Date,Seat,Qty;
    String TicketID="";


    /**
     * Creates new form Drinks
     */
    public BuyTicket(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        PopulateTicketsTable();
    }
public void PopulateTicketsTable(){
jPanel2.removeAll();
Vector columnNames = new Vector();
Vector data = new Vector();
//JPanel p=new JPanel();
try {
Class.forName("com.mysql.jdbc.Driver");
 conn = DriverManager.getConnection(url,username,password);
String sql = "SELECT ID,MovieName,HallName,Date,Seat,Quantity from tickets WHERE Quantity>1 && Date>= CURDATE();";
stm = conn.createStatement();
ResultSet rs = stm.executeQuery( sql );
ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();
for (int i = 1; i <= columns; i++) {
if(i==1){columnNames.addElement("ID" );}
else if(i==2){columnNames.addElement("Movie Name" );}
else if(i==3){columnNames.addElement("Hall" );}
else if(i==4){columnNames.addElement("Date" );}
else if(i==5){columnNames.addElement("Seat No." );}
else if(i==6){columnNames.addElement("Remaining Tickets" );}
else{
    columnNames.addElement(md.getColumnName(i));
}
}
while (rs.next()) {
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++){
row.addElement( rs.getObject(i) );

}
data.addElement( row );
}
rs.close();
stm.close();
}
catch(Exception e){
System.out.println(e);
}

 stable = new JTable(data, columnNames);
TableColumn col;

for (int i = 0; i < stable.getColumnCount(); i++) {
col = stable.getColumnModel().getColumn(i);
col.setResizable(true);
}
stable.addMouseListener(new MouseAdapter()   
    {  
            @Override
    public void mouseClicked(MouseEvent evt)  
    {  
   int row = stable.getSelectedRow(); 
   TicketID=String.valueOf(stable.getModel().getValueAt(row, 0));
   MovieName=String.valueOf(stable.getModel().getValueAt(row, 1));
   HallName=String.valueOf(stable.getModel().getValueAt(row, 2));
   Date=String.valueOf(stable.getModel().getValueAt(row, 3));
   Seat=String.valueOf(stable.getModel().getValueAt(row, 4));
   Qty=String.valueOf(stable.getModel().getValueAt(row, 5));

       }
    
  } ); 
scrollPane = new JScrollPane(stable);
scrollPane.setSize(668, 379);
scrollPane.setWheelScrollingEnabled(true);

jPanel2.add( scrollPane );
  
//p.setSize(245,220);

}
private void BuyTicko()
{
try { 
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,username,password);
         PreparedStatement statement = conn.prepareStatement
         ("INSERT INTO print (TicketID,MovieName,HallName,Date) VALUES(?,?,?,?)");
         statement.setString(1,TicketID);
         statement.setString(2,MovieName);
         statement.setString(3,HallName);
         statement.setString(4,Date);
                 
         statement.executeUpdate();
         statement.close();
            
         int k;
            k=JOptionPane.showConfirmDialog(jPanel2,"Ticket for "+MovieName+" has been successfully reserved! Do you wish to make another purchase?","Ticket order",JOptionPane.YES_NO_OPTION);
        if(k==JOptionPane.YES_OPTION)
        {
          ReduceTickets();              
         this.dispose();
         BuyTicket dialog = new BuyTicket(new javax.swing.JFrame(), true);
         dialog.setVisible(true);
        }
        else{
            ReduceTickets();
            this.dispose();}    
conn.close();
        }
         catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                       JOptionPane.showMessageDialog(jPanel2,"Sorry, An Error Occurred!","Error!",JOptionPane.ERROR_MESSAGE);
                }
}
private void ReduceTickets()
{
try { 
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,username,password);
         PreparedStatement statement = conn.prepareStatement
         ("UPDATE tickets SET Quantity=Quantity-1 WHERE ID="+TicketID+"");
                          
         statement.executeUpdate();
         statement.close();
           
conn.close();
        }
         catch (Exception exc) {  // process error
            System.out.println("process error" + exc);
                       JOptionPane.showMessageDialog(jPanel2,"Sorry, An Error Occurred!","Error!",JOptionPane.ERROR_MESSAGE);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Place Order- Foods");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Choose a movie and click buy ticket.");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("These are the available moveis:");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setMaximumSize(new java.awt.Dimension(668, 379));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        jToggleButton1.setText("Buy Ticket");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Discard");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addGap(144, 144, 144))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        if(TicketID=="")
        {
        JOptionPane.showMessageDialog(jPanel2,"Sorry, you have not chosen any movie to buy ticket for!","No Input!",JOptionPane.WARNING_MESSAGE);

        }
        else{
        int choice;
            choice=JOptionPane.showConfirmDialog(jPanel2,"An ticket for "+MovieName+" will be  reserved! Are you sure you want to place the order?","Order Confirmation",JOptionPane.YES_NO_OPTION);
        if(choice==JOptionPane.YES_OPTION)
        {
          BuyTicko();              
                 }}
                // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(BuyTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuyTicket dialog = new BuyTicket(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
