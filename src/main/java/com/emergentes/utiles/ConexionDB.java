
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionDB {
     static public String driver = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_ventas";
    static public String usuario = "root";
    static public String password = "";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion OK " + conn);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en driver " + ex.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        System.out.println("Cerrando la BD" + conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

