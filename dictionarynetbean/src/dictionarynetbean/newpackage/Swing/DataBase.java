/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarynetbean.newpackage.Swing;

import dictionarynetbean.newpackage.Dictionary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Bùi Văn Bảo
 */
public class DataBase {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:dictionaryvv.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
    public void selectAll(){
        String sql = "SELECT word, info FROM Dictionary";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("word") + "\t" +
                                   rs.getString("info"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
//    public HashMap addMap(){
//        String sql = "SELECT word, info FROM Dictionary";
//        
//        try (Connection conn = this.connect();
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql)){
//            
//            // loop through the result set
//            while (rs.next()) {
//                String[] a = new String[2];
//                a[0] = rs.getString("word");
//                a[1] = rs.getString("info");
//                win.dictionary.map.put(a[0], a[1]);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    public void insert(String newword, String explain) {
        String sql = "INSERT INTO Dictionary(word,info) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newword);
            pstmt.setString(2, explain);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(String s, String a){
        delete(s);
        insert(s,a);
    }
    
    public HashMap searchtd(String s) {                                 
        // TODO add your handling code here:
        HashMap<String,String> map = new HashMap<String,String>();
        String sql = "SELECT word, info FROM Dictionary";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(rs.getString("word").length() >= s.length()){
                    if (s.equals(rs.getString("word").substring(0, s.length()))) {
                        map.put(rs.getString("word"), " ");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return map;
    }
    
    public void delete(String s) {
        String sql = "DELETE FROM Dictionary WHERE word = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, s);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean search(String s){
        boolean check = false;
        String sql = "SELECT word, info FROM Dictionary";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(s.equals(rs.getString("word"))){
                    check = true;
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
    
    public String Explain(String word){
        
        String sql = "SELECT * "+ "FROM Dictionary WHERE word = \""+word+"\"";
        String ex = null;

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                 ex = rs.getString("info");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ex;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataBase db = new DataBase();
        //db.selectAll();
        
        //db.addMap();
//        db.win.dictionary.map.forEach((String key,String value)->
//        {
//            //System.out.println(key + " " + value);
//        }
//        );
        db.update("Bao", "Truong");

    }
}
