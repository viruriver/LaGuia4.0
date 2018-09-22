/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ElViru
 */
public class DBConnection {
    

    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;

    private static final String USER = "ViruSQL";
    private static final String PASS = "ViruSQL";
    private static final String URL = "jdbc:sqlserver://NOTEBOOK-VIRU\\SQLEXPRESS\\SQLEXPRESS:2090;databaseName=LaGuia4.0";

    
    
    public static Connection getConexion() {
        if (con == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(URL, USER, PASS);
            } catch (Exception e) {
                System.out.println("Connection Fail");
                e.printStackTrace();
            }
        }
        return con;
    }

    private DBConnection() {
    }
    
    
    
    
    
    
}
