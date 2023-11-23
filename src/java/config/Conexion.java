/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author llina
 */

// Implementación con patron Singleton
public class Conexion {
    private static Conexion instance;
    Connection con;
    String url= "jdbc:mysql://localhost:3306/db_ventas";               
    String user="root";
    String password="";    
    
     // Constructor privado para evitar la creación de instancias directas
    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }

    // Método estático para obtener la única instancia de la clase
    public static Conexion getInstance() {
        if (instance == null) {
            // Si la instancia aún no ha sido creada, la creamos
            instance = new Conexion();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return con;
    }
}
