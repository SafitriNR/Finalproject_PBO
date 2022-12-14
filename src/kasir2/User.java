/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasir2;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.sum;
import static java.lang.Float.sum;
import java.sql.SQLException;
import static koneksi.koneksi.con;

/**
 *
 * @author Mila Safitri
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.Spring.sum;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.Timer;


/**
 *
 * @author Mila Safitri
 */
public class User extends javax.swing.JFrame {
public Statement st;
public ResultSet rs;
public DefaultTableModel tabmodel;
String sql;
Connection con = koneksi.getKoneksi();
    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        tampildata();
        reset();
    }
    public void tampildata(){
        try {
            st = con.createStatement();
            Object[] judul = {"Username","Password"};
            tabmodel = new DefaultTableModel(null, judul);
            rs = st.executeQuery("select * from users order by id desc");
            while (rs.next()) {                
                Object[] data = {
                    rs.getString("username"),
                    rs.getString("password"),
                };
                tabmodel.addRow(data);
            };
            table_user.setModel(tabmodel);
        } catch (Exception e) {
                e.printStackTrace();

        }
    }
    public void reset() {
    username.setText("");
    password.setText("");
    
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
        btn_reset = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        searching = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_user = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 250, 239));

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        jLabel7.setText("Cari Data");

        jLabel1.setText("Username");

        searching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchingActionPerformed(evt);
            }
        });
        searching.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchingKeyReleased(evt);
            }
        });

        jLabel2.setText("Password");

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_user);

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_tambah)
                                    .addComponent(btn_reset))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_hapus)
                                    .addComponent(btn_update)))
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(searching, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus)
                            .addComponent(btn_reset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE users set "
                + "username='"       + username.getText() + "', "
                + "password='"      + password.getText() + "' WHERE username = '"+username.getText()+"'");
            
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            tampildata();
            reset();
            btn_tambah.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        try {
            int jawab;

            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                st = con.createStatement();
                st.executeUpdate("DELETE FROM users WHERE username='"
                    + tabmodel.getValueAt(table_user.getSelectedRow(), 0) + "'");
                tampildata();
                reset();
                 btn_tambah.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        if (username.getText().equals("") && password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi data!");
        }else {
          
                try {
//                   if(CekUsername(username.getText()) >= 0){
//                       JOptionPane.showMessageDialog(null, "username tidak boleh sama!");
//                   }else{
                    st = con.createStatement();
                    st.executeUpdate("INSERT INTO users VALUES(null,'" + username.getText() + "','" + password.getText() + "')");
                    JOptionPane.showMessageDialog(null, "data berhasil disimpan");
//                   }
                    tampildata();
                    reset();

                } catch (Exception e) {
                    e.printStackTrace();

                }
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void table_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_userMouseClicked
        // TODO add your handling code here:
         username.setText(table_user.getValueAt(table_user.getSelectedRow(), 0).toString());
        password.setText(table_user.getValueAt(table_user.getSelectedRow(), 1).toString());
        btn_tambah.setEnabled(false);
        btn_update.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_reset.setEnabled(true);
    }//GEN-LAST:event_table_userMouseClicked

    private void searchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchingActionPerformed

    }//GEN-LAST:event_searchingActionPerformed

    private void searchingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchingKeyReleased

        try {
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("select * from users where username like '%" + searching.getText() +
                    "%' or password like '%" + searching.getText() + "%'");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("username"),
                    rs.getString("password"),
                };
                tabmodel.addRow(data);
            };
            table_user.setModel(tabmodel);
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchingKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Dashboard t = new Dashboard();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    private int CekUsername(String text) throws SQLException {
        int sum = 0;
       st = con.createStatement();
       rs = st.executeQuery("SELECT * FROM users WHERE username  = '"+ text +"'");
       while (rs.next()) {
        int c = rs.getInt(1);
        sum = sum + c;
      }
       return sum;
    }
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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField searching;
    private javax.swing.JTable table_user;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    
}
