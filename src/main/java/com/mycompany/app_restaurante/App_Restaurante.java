/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_restaurante;

/**
 *
 * @author mg602
 */
import com.mycompany.app_restaurante.RegistrarPlatos.FrameRegistrarPlatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class App_Restaurante {
    public static void main(String[] args) {
        // Imprime mensaje de bienvenida
        System.out.println("Hola, App Restaurante está funcionando!");

       com.mycompany.app_restaurante.RegistrarPlatos.FrameRegistrarPlatos ventana  = new FrameRegistrarPlatos();
       ventana.setVisible(true);

        
    }

    // Método para insertar datos en la base de datos
    
}
