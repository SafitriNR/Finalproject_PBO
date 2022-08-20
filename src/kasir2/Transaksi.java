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

import static koneksi.koneksi.con;
public class Transaksi extends javax.swing.JFrame {
public Statement st;
public ResultSet rs;
public DefaultTableModel tabmodel;
String sql;
Connection con = koneksi.getKoneksi();
   

    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
        initComponents();
        tampildata();
        reset();
        tglskrng();
    }
    
    public String tglskrng(){
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate= DateFor.format(date);
//        this.tgl.setText(stringDate);
        return stringDate;
         
     }
 
    public void tampildata(){
        try {
            st = con.createStatement();
            Object[] judul = {"Code","Nama Barang","Qty","Harga","Total"};
            tabmodel = new DefaultTableModel(null, judul);
            rs = st.executeQuery("select transaction_temp.* , products.title,products.price, products.price*transaction_temp.qty AS total from transaction_temp INNER join products on transaction_temp.code = products.code");
            while (rs.next()) {                
                Object[] data = {
                    rs.getString("code"),
                    rs.getString("title"),
                    rs.getString("qty"),
                    rs.getString("price"),
                    rs.getString("total"),
                };
                tabmodel.addRow(data);
            };
            table_keranjang.setModel(tabmodel);
            total_bayar.setText(String.valueOf(TotalBayar()));
        } catch (Exception e) {
                e.printStackTrace();

        }
    }
   
    public void reset() {
    code_barang.setText("");
    nama_barang.setText("");
    harga_barang.setText("");
    qty_barang.setText("");
    sub_total_barang.setText("");
    sisa_stok.setText("Stok : 0");
    
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
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        harga_barang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        qty_barang = new javax.swing.JTextField();
        sub_total_barang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cari_code = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        code_barang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nama_barang = new javax.swing.JTextField();
        sisa_stok = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_keranjang = new javax.swing.JTable();
        btn_selesai = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        total_bayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 250, 239));

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Harga");

        jLabel4.setText("Qty");

        qty_barang.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                qty_barangInputMethodTextChanged(evt);
            }
        });
        qty_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qty_barangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qty_barangKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qty_barangKeyTyped(evt);
            }
        });

        sub_total_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_total_barangActionPerformed(evt);
            }
        });

        jLabel5.setText("Sub Total");

        cari_code.setText("Cari");
        cari_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_codeActionPerformed(evt);
            }
        });

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

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

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        jLabel1.setText("Kode Barang");

        code_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                code_barangActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Barang");

        sisa_stok.setText("Stok : 0");

        table_keranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        table_keranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_keranjangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_keranjang);

        btn_selesai.setText("Selesai");
        btn_selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selesaiActionPerformed(evt);
            }
        });

        jLabel6.setText("Total");

        total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_bayarActionPerformed(evt);
            }
        });

        jLabel7.setText("Bayar");

        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });
        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });

        jLabel8.setText("Kembalian");

        kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(qty_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(harga_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sub_total_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn_tambah)
                                            .addComponent(btn_reset))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_hapus)
                                            .addComponent(btn_update)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sisa_stok))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cari_code)
                                    .addComponent(code_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(kembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bayar)
                                    .addComponent(total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31)
                        .addComponent(btn_selesai)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(code_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari_code)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(harga_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(qty_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sisa_stok))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(sub_total_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus)
                            .addComponent(btn_reset)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_selesai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
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

    private void code_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_code_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_code_barangActionPerformed

    private void cari_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_codeActionPerformed
        // TODO add your handling code here:
        try{
            String codes = code_barang.getText();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM products WHERE code  = '"+ code_barang.getText() +"'");
            while(rs.next()){
                nama_barang.setText(rs.getString(String.valueOf("title")));
                harga_barang.setText(rs.getString(String.valueOf("price")));
                int jumlah_stok = StokMasuk(codes) - StokKeluar(codes);
                sisa_stok.setText("STOK : "+ jumlah_stok );
            }
            
            } catch (SQLException e){
                e.printStackTrace();
        }
    }//GEN-LAST:event_cari_codeActionPerformed

    private void qty_barangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty_barangKeyReleased
        // TODO add your handling code here:
       try{
            String codes = code_barang.getText();
            int qty = Integer.parseInt(String.valueOf(qty_barang.getText()));
            int price = Integer.parseInt(String.valueOf(harga_barang.getText()));
            int jumlah_stok = StokMasuk(codes) - StokKeluar(codes);
            if( qty >= jumlah_stok){
                qty_barang.setText("");
            }else{
                int sub_totals = qty * price;
                sub_total_barang.setText(String.valueOf(sub_totals));
            }
            
            } catch (SQLException e){
                e.printStackTrace();
        }
    }//GEN-LAST:event_qty_barangKeyReleased

    private void sub_total_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_total_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_total_barangActionPerformed

    private void qty_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty_barangKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_qty_barangKeyTyped

    private void qty_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty_barangKeyPressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_qty_barangKeyPressed

    private void qty_barangInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_qty_barangInputMethodTextChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_qty_barangInputMethodTextChanged

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        if (sub_total_barang.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Lengkapi data!");
        }else {
            try {        
            st = con.createStatement();
             st.executeUpdate("INSERT INTO transaction_temp VALUES(null,'" + code_barang.getText() + "','" + qty_barang.getText() + "')");
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            tampildata();
            code_barang.setText("");
            nama_barang.setText("");  
            harga_barang.setText("");
            qty_barang.setText("");
            sub_total_barang.setText("");
            sisa_stok.setText("Stok : 0");
            
        } catch (Exception e) {
            e.printStackTrace();
        
        }
       }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void table_keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_keranjangMouseClicked
        // TODO add your handling code here:
        code_barang.setText(table_keranjang.getValueAt(table_keranjang.getSelectedRow(), 0).toString());
        nama_barang.setText(table_keranjang.getValueAt(table_keranjang.getSelectedRow(), 1).toString());
        harga_barang.setText(table_keranjang.getValueAt(table_keranjang.getSelectedRow(), 3).toString());
        qty_barang.setText(table_keranjang.getValueAt(table_keranjang.getSelectedRow(), 2).toString());
        sub_total_barang.setText(table_keranjang.getValueAt(table_keranjang.getSelectedRow(), 4).toString());
        btn_tambah.setEnabled(false);
        btn_update.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_reset.setEnabled(true);
    }//GEN-LAST:event_table_keranjangMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE transaction_temp set " 
                + "code='"       + code_barang.getText() + "', "
                + "qty='"      + qty_barang.getText() + "' WHERE code = '"+code_barang.getText()+"'");
           
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
          st.executeUpdate("DELETE FROM transaction_temp WHERE code='"
              + tabmodel.getValueAt(table_keranjang.getSelectedRow(), 0) + "'");
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

    private void total_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_bayarActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarActionPerformed

    private void kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianActionPerformed

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
        // TODO add your handling code here:
        int totals = Integer.parseInt(String.valueOf(total_bayar.getText()));
        int bayars = Integer.parseInt(String.valueOf(bayar.getText()));
        int jml = bayars - totals;
        kembalian.setText(String.valueOf(jml));
        if(jml >= 0){
            btn_selesai.setEnabled(true);
        }else{
            btn_selesai.setEnabled(false);
        }
    }//GEN-LAST:event_bayarKeyReleased

    private void btn_selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selesaiActionPerformed
    try {
        String autocode = autocode();
        st = con.createStatement();
            rs = st.executeQuery("select transaction_temp.* ,products.price*transaction_temp.qty AS total from transaction_temp INNER join products on transaction_temp.code = products.code");
  
            while (rs.next()) {                
                String codes = rs.getString("code");
                String qtys = rs.getString("qty");
                String total = rs.getString("total");
                InputTransactionDetail(autocode,codes,qtys,total);
                String status = "out";
                InputStok(codes,qtys,status);
            };
            int tb = Integer.parseInt(String.valueOf(total_bayar.getText()));
            int b = Integer.parseInt(String.valueOf(bayar.getText()));
            int kembalis = Integer.parseInt(String.valueOf(kembalian.getText()));
            String tanggal= tglskrng();
            InputTransaksi(autocode,tb,b,kembalis,tanggal);
            TruncateTemp();
            tampildata();
            JOptionPane.showMessageDialog(null, " Berhasil");
            total_bayar.setText("");
            bayar.setText("");
            kembalian.setText("");
    } catch (Exception e) {
        e.printStackTrace();
      }
           
    }//GEN-LAST:event_btn_selesaiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Dashboard t = new Dashboard();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void TruncateTemp(){
        try {        
            st = con.createStatement();
             st.executeUpdate("truncate transaction_temp ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void InputStok(String codes, String qtys, String status) {
        try {        
            st = con.createStatement();
             st.executeUpdate("INSERT INTO stocks VALUES(null,'" + status + "','" + codes + "','" + qtys + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void InputTransactionDetail(String autocode, String codes, String qtys, String total) {
        try {        
            st = con.createStatement();
             st.executeUpdate("INSERT INTO transaction_item VALUES(null,'" + autocode + "','" + codes + "','" + qtys + "','" + total + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void InputTransaksi(String autocode, int totals, int bayars, int kembalians,String tanggal) {
        try {        
            st = con.createStatement();
            st.executeUpdate("INSERT INTO transaction VALUES(NULL, '" + autocode + "', '" + totals + "', '" + bayars + "', '" + kembalians + "','" + tanggal + "')");
            
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
    }
     public  String autocode(){
        Random angka  = new Random();
        String angkaa = String.valueOf(angka.nextInt(999));
        String kode ="TR"+angkaa;
        return kode;
    }
    public int StokMasuk(String codes) throws SQLException{
         int sum = 0;
       st = con.createStatement();
       rs = st.executeQuery("SELECT sum(qty) as stok_masuk FROM stocks WHERE code  = '"+ codes +"' and type = 'in'");
       while (rs.next()) {
        int c = rs.getInt(1);
        sum = sum + c;
      }
       return sum;
    }
    
   
    public int StokKeluar(String codes) throws SQLException{
         int sum = 0;
       st = con.createStatement();
       rs = st.executeQuery("SELECT sum(qty) as stok_masuk FROM stocks WHERE code  = '"+ codes +"' and type = 'out'");
       while (rs.next()) {
        int c = rs.getInt(1);
        sum = sum + c;
      }
       return sum;
    }
     public int TotalBayar() throws SQLException{
         int sum = 0;
       st = con.createStatement();
       rs = st.executeQuery("select sum(products.price*transaction_temp.qty) AS total from transaction_temp INNER join products on transaction_temp.code = products.code");
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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_selesai;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton cari_code;
    private javax.swing.JTextField code_barang;
    private javax.swing.JTextField harga_barang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JTextField qty_barang;
    private javax.swing.JLabel sisa_stok;
    private javax.swing.JTextField sub_total_barang;
    private javax.swing.JTable table_keranjang;
    private javax.swing.JTextField total_bayar;
    // End of variables declaration//GEN-END:variables

    

   

    
}
