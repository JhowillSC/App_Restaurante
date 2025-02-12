/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.app_restaurante.RegistrarPlatos;

import com.mycompany.app_restaurante.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;


public class FrameRegistrarPlatos extends javax.swing.JFrame {

    /**
     * Creates new form FrameRegistrarPlatos
     */
    public FrameRegistrarPlatos() {
        initComponents();
        this.setSize(860, 605);
        this.setLocationRelativeTo(null);
        this.setTitle("Registrar");
        this.setResizable(false);
         comboCategoria.addItem("Pollos a la brasa");
        comboCategoria.addItem("Combos brasa");
        comboCategoria.addItem("Arroz chaufa");
        comboCategoria.addItem("Saltados Carta");
        comboCategoria.addItem("Saltados Junior");
        comboCategoria.addItem("Tallarines Carta");
        comboCategoria.addItem("Tallarines Junior");
        comboCategoria.addItem("Personales Carta");
        comboCategoria.addItem("Personales Junior");
        comboCategoria.addItem("Bebidas");
        comboCategoria.addItem("Licores");
        ListaAccion();
        
    }

     //////////////////////// LOGICA DEL LOGO DEL PROGRAMA ////////////////////////////////////////////////////////
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo.jpg"));
        return retValue;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PLATOS DEL DÍA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Nombre :");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Precio :");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar .png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Registar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_1.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Categoria :");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoger Categoria" }));
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        tablaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaLista);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
  String nombre = txtNombre.getText();  // Obtener el nombre del JTextField
    String precio = txtPrecio.getText();  // Obtener el precio del JTextField
    String categoria = comboCategoria.getSelectedItem().toString();  // Obtener la categoría del JComboBox

    // Validar que todos los campos estén llenos
    if (nombre.isEmpty() || precio.isEmpty() || categoria.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar que el precio sea un número válido
    double precioDouble;
    try {
        precioDouble = Double.parseDouble(precio); // Convierte el precio a double
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Consulta SQL para insertar los datos
    String sql = "INSERT INTO platos (nombre, precio, categoria) VALUES (?, ?, ?)";

    // Realizar conexión e insertar datos
    try (Connection conn = ConexionMySQL.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Asignar valores a los parámetros de la consulta
        pstmt.setString(1, nombre);
        pstmt.setDouble(2, precioDouble); // Usar setDouble para el precio
        pstmt.setString(3, categoria);

        // Ejecutar la consulta
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "¡Plato registrado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar los campos después de registrar
        txtNombre.setText("");
        txtPrecio.setText("");
        comboCategoria.setSelectedIndex(0);

    } catch (SQLException ex) {
        // Mostrar mensaje de error en caso de excepción
        JOptionPane.showMessageDialog(this, "Error al registrar el plato: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    ListaAccion();        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
 int filaSeleccionada = tablaLista.getSelectedRow(); // Seleccionar fila en JTable

    if (filaSeleccionada >= 0) {
        // Obtener el ID del plato a eliminar
        String id = tablaLista.getValueAt(filaSeleccionada, 0).toString();

        // Confirmar si desea eliminar el plato
        int opcion = JOptionPane.showConfirmDialog(
            this, 
            "¿Estás seguro de que deseas eliminar este plato?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            // Eliminar el plato de la base de datos
            try (Connection conn = ConexionMySQL.conectar()) {
                String sql = "DELETE FROM platos WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, id); // ID del plato a eliminar

                    // Ejecutar la consulta
                    int filasAfectadas = pstmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(
                            this, 
                            "¡Plato eliminado exitosamente!", 
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE
                        );

                        // Recargar los datos de la tabla
                        ListaAccion();
                    } else {
                        JOptionPane.showMessageDialog(
                            this, 
                            "No se encontró el plato a eliminar.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                    this, 
                    "Error al eliminar el plato: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    } else {
        JOptionPane.showMessageDialog(
            this, 
            "Por favor selecciona un plato para eliminar.", 
            "Advertencia", 
            JOptionPane.WARNING_MESSAGE
        );
    }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
 txtNombre.setText("");
        txtPrecio.setText("");
        comboCategoria.setSelectedIndex(0);         // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
 int filaSeleccionada = tablaLista.getSelectedRow(); // Seleccionar fila en JTable

    if (filaSeleccionada >= 0) {
        // Obtener datos actuales de la fila seleccionada
        String id = tablaLista.getValueAt(filaSeleccionada, 0).toString();
        String nombreActual = tablaLista.getValueAt(filaSeleccionada, 1).toString();
        String precioActual = tablaLista.getValueAt(filaSeleccionada, 2).toString();
        String categoriaActual = tablaLista.getValueAt(filaSeleccionada, 3).toString();

        // Mostrar los valores actuales en los campos para edición
        txtNombre.setText(nombreActual);
        txtPrecio.setText(precioActual);
        comboCategoria.setSelectedItem(categoriaActual);

        // Confirmar si el usuario desea guardar los cambios
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas guardar los cambios en este plato?",
                "Confirmar Edición",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Obtener los nuevos valores de los campos
            String nuevoNombre = txtNombre.getText();
            String nuevoPrecio = txtPrecio.getText();
            String nuevaCategoria = comboCategoria.getSelectedItem().toString();

            // Validar que los campos no estén vacíos
            if (nuevoNombre.isEmpty() || nuevoPrecio.isEmpty() || nuevaCategoria.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor llena todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Actualizar los datos en la base de datos
            try (Connection conn = ConexionMySQL.conectar()) {
                String sql = "UPDATE platos SET nombre = ?, precio = ?, categoria = ? WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, nuevoNombre);
                    pstmt.setDouble(2, Double.parseDouble(nuevoPrecio)); // Convertir precio a double
                    pstmt.setString(3, nuevaCategoria);
                    pstmt.setString(4, id); // ID del plato a actualizar

                    // Ejecutar la consulta
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "¡Plato actualizado correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // Recargar los datos de la tabla
                    ListaAccion();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar el plato: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor selecciona un plato para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaActionPerformed
public static ResultSet ListarTabla(String consulta){
        Connection conn=com.mycompany.app_restaurante.ConexionMySQL.conectar();
        Statement sql;     
        
        ResultSet datos=null;
        
        try {
            sql=conn.createStatement();
            datos=sql.executeQuery(consulta);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return datos;
    }
    
    public void ListaAccion(){
        DefaultTableModel md = new DefaultTableModel();
        ResultSet rs = ListarTabla("select * from platos");
        md.setColumnIdentifiers(new Object[]{"ID", "Nombre de Plato", "Precio", "Categoria"});

        try {
        while (rs.next()) {
        // Agregar cada fila al modelo
        md.addRow(new Object[]{
            rs.getString("id"),
            rs.getString("nombre"),
            rs.getString("precio"),
            rs.getString("categoria")
        });
    }
    // Configurar el modelo en la tabla después de llenar todas las filas
        tablaLista.setModel(md);
    } catch (Exception e) {
    System.out.println(e);
    }

        
        
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
            java.util.logging.Logger.getLogger(FrameRegistrarPlatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRegistrarPlatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRegistrarPlatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRegistrarPlatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameRegistrarPlatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLista;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
