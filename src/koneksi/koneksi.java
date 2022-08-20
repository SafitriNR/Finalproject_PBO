/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.koneksi to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Mila Safitri
 */
public class koneksi {
    public static Connection con;
    public Statement st;
    public ResultSet rs;
    public static Connection getKoneksi(){
         try {
             DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo_kasir","root","");
               System.out.println("Berhasil");
            } catch (Exception e) {
            e.getStackTrace();
            }
        return con;
    }

   
   
}
