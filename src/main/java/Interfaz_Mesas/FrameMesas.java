/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz_Mesas;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jhowi
 */
public class FrameMesas extends javax.swing.JFrame {

    /**
     * Creates new form FrameMesas
     */
    public FrameMesas() {
        this.setSize(856, 577);
        this.setLocationRelativeTo(null);
        this.setTitle("Interfaz_Mesas");
        this.setResizable(false);
        initComponents();
        cargarEstados();
       
    }
    
     private void cambiarEstadoBoton(javax.swing.JButton boton, String nombreBoton) {
    if (boton.getBackground().equals(Color.GREEN)) {
        boton.setBackground(Color.RED);
        guardarEstado(nombreBoton, "ROJO");
    } else {
        boton.setBackground(Color.GREEN);
        guardarEstado(nombreBoton, "VERDE");
    }
}

        private void guardarEstado(String nombreBoton, String estado) {
    try {
        // Leer el estado actual de todos los botones
        Map<String, String> estados = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("estado_mesas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    estados.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            // Si el archivo no existe, no pasa nada
        }

        // Actualizar el estado del botón actual
        estados.put(nombreBoton, estado);

        // Escribir todos los estados nuevamente
        try (FileWriter writer = new FileWriter("estado_mesas.txt")) {
            for (Map.Entry<String, String> entry : estados.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
private void cargarEstados() {
    try (BufferedReader reader = new BufferedReader(new FileReader("estado_mesas.txt"))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split("=");
            if (partes.length == 2) {
                String nombreBoton = partes[0];
                String estado = partes[1];

                // Asignar el color según el estado
                switch (nombreBoton) {
                    case "MESA1":
                        btnMesa1.setBackground("ROJO".equals(estado) ? Color.RED : Color.GREEN);
                        break;
                    case "MESA2":
                        btnMesa2.setBackground("ROJO".equals(estado) ? Color.RED : Color.GREEN);
                        break;
                    case "MESA3":
                        btnMesa3.setBackground("ROJO".equals(estado) ? Color.RED : Color.GREEN);
                        break;
                    case "MESA4":
                        btnMesa4.setBackground("ROJO".equals(estado) ? Color.RED : Color.GREEN);
                        break;
                    case "MESA5":
                        btnMesa5.setBackground("ROJO".equals(estado) ? Color.RED : Color.GREEN);
                        break;
                    case "MESA6":
                        btnMesa6.setBackground("ROJO".equals(estado) ? Color.RED : Color.GREEN);
                        break;
                    case "MESA7":
                        btnMesa7.setBackground("ROJO".equals(estado) ? Color.RED : Color.GREEN);
                        break;
                    case "MESA8":
                        btnMesa8.setBackground("ROJO".equals(estado) ? Color.RED : Color.GREEN);
                        break;
                }
            }
        }
    } catch (IOException e) {
        // Si no existe el archivo, todos empiezan en verde
        btnMesa1.setBackground(Color.GREEN);
        btnMesa2.setBackground(Color.GREEN);
        btnMesa3.setBackground(Color.GREEN);
        btnMesa4.setBackground(Color.GREEN);
        btnMesa5.setBackground(Color.GREEN);
        btnMesa6.setBackground(Color.GREEN);
        btnMesa7.setBackground(Color.GREEN);
        btnMesa8.setBackground(Color.GREEN);
    }
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMesa1 = new javax.swing.JButton();
        btnMesa2 = new javax.swing.JButton();
        btnMesa3 = new javax.swing.JButton();
        btnMesa4 = new javax.swing.JButton();
        btnMesa5 = new javax.swing.JButton();
        btnMesa6 = new javax.swing.JButton();
        btnMesa7 = new javax.swing.JButton();
        btnMesa8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        btnMesa1.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa1.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnMesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa1.setText("Mesa 1");
        btnMesa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });

        btnMesa2.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa2.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnMesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa2.setText("Mesa 2");
        btnMesa2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa2ActionPerformed(evt);
            }
        });

        btnMesa3.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa3.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnMesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa3.setText("Mesa 3");
        btnMesa3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa3ActionPerformed(evt);
            }
        });

        btnMesa4.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa4.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnMesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa4.setText("Mesa 4");
        btnMesa4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa4ActionPerformed(evt);
            }
        });

        btnMesa5.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa5.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnMesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa5.setText("Mesa 5");
        btnMesa5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa5ActionPerformed(evt);
            }
        });

        btnMesa6.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa6.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnMesa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa6.setText("Mesa 6");
        btnMesa6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa6ActionPerformed(evt);
            }
        });

        btnMesa7.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa7.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnMesa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa7.setText("Mesa 7");
        btnMesa7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa7ActionPerformed(evt);
            }
        });

        btnMesa8.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa8.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnMesa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa8.setText("Mesa 8");
        btnMesa8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMesa5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(btnMesa1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMesa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMesa6, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMesa3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(btnMesa7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMesa4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnMesa8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMesa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMesa3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(btnMesa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMesa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMesa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMesa6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMesa8, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(btnMesa7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
        cambiarEstadoBoton(btnMesa1, "MESA1");
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void btnMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa2ActionPerformed
        cambiarEstadoBoton(btnMesa2, "MESA2");

    }//GEN-LAST:event_btnMesa2ActionPerformed

    private void btnMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa3ActionPerformed
        cambiarEstadoBoton(btnMesa3, "MESA3");
    }//GEN-LAST:event_btnMesa3ActionPerformed

    private void btnMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa4ActionPerformed
        cambiarEstadoBoton(btnMesa4, "MESA4");
    }//GEN-LAST:event_btnMesa4ActionPerformed

    private void btnMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa5ActionPerformed
        cambiarEstadoBoton(btnMesa5, "MESA5");
    }//GEN-LAST:event_btnMesa5ActionPerformed

    private void btnMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa6ActionPerformed
        cambiarEstadoBoton(btnMesa6, "MESA6");
    }//GEN-LAST:event_btnMesa6ActionPerformed

    private void btnMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa7ActionPerformed
        cambiarEstadoBoton(btnMesa7, "MESA7");
    }//GEN-LAST:event_btnMesa7ActionPerformed

    private void btnMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa8ActionPerformed
        cambiarEstadoBoton(btnMesa8, "MESA8");
    }//GEN-LAST:event_btnMesa8ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMesa1;
    private javax.swing.JButton btnMesa2;
    private javax.swing.JButton btnMesa3;
    private javax.swing.JButton btnMesa4;
    private javax.swing.JButton btnMesa5;
    private javax.swing.JButton btnMesa6;
    private javax.swing.JButton btnMesa7;
    private javax.swing.JButton btnMesa8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
