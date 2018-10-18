/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarynetbean.newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author VX15
 */
public class DataBase {
    
    public Connection connect() {
        Connection conn = null;
        String url = "jdbc:sqlite:dictionaryvv.db";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void add(String eng, String viet) {
        String sql = "INSERT INTO Dictionary(word,info) VALUES(?,?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, eng);
            pstmt.setString(2, viet);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//    public void select() {
//        String sql = "SELECT word, info FROM Dictionary";
//        
//        try (Connection conn = this.connect();
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql)){
//            
//            // loop through the result set
//            while (rs.next()) {
//                System.out.println(
//                                   rs.getString("word") + "\t" +
//                                   rs.getString("info"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public String Search(String word) {
        String sql = "SELECT word, info FROM Dictionary Where word = ?";
        String s = new String();
        try (Connection conn = this.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){            
            pstmt.setString(1, word);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                s = rs.getString("info");
                
                }          
        } catch (SQLException e) {
            //ket noi database khong thanh cong, in ra loi
            System.out.println(e.getMessage());
        }
        return s;
        
    }   
    public void delete(String word) {
        String sql = "DELETE FROM Dictionary WHERE word = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            pstmt.setString(1, word);
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public void edit(String eng, String viet) {
         delete(eng);
         add(eng,viet);
    }
    
    public static void main(String[] args) {
        DataBase db = new DataBase();
        db.connect();
        db.delete("fuck");
        
    }
}
