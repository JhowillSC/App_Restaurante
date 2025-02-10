/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // Import necesario
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos MySQL");
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
        return conexion;
    }

 

   
}