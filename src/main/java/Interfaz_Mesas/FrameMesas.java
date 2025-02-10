/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz_Mesas;

import Inicio.FrmIndex;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author jhowi
 */
public class FrameMesas extends javax.swing.JFrame {

    
   // private Interfaz_mesa_1 Inter1;
    
    
    public FrameMesas() {
      
        this.setSize(860, 605);
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
        jLabel3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnMesa1 = new javax.swing.JButton();
        btnMesa2 = new javax.swing.JButton();
        btnMesa3 = new javax.swing.JButton();
        btnMesa4 = new javax.swing.JButton();
        btnMesa5 = new javax.swing.JButton();
        btnMesa6 = new javax.swing.JButton();
        btnMesa7 = new javax.swing.JButton();
        btnMesa8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(860, 605));
        jPanel1.setPreferredSize(new java.awt.Dimension(860, 605));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Wide Latin", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MESAS DISPONIBLES");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 690, 50));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras .png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, 30));

        btnMesa1.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa1.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa1.setText("Mesa 1");
        btnMesa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 214, 240));

        btnMesa2.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa2.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa2.setText("Mesa 2");
        btnMesa2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 214, 240));

        btnMesa3.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa3.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa3.setText("Mesa 3");
        btnMesa3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 214, 240));

        btnMesa4.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa4.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa4.setText("Mesa 4");
        btnMesa4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 200, 240));

        btnMesa5.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa5.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa5.setText("Mesa 5");
        btnMesa5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 214, 250));

        btnMesa6.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa6.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa6.setText("Mesa 6");
        btnMesa6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 214, 250));

        btnMesa7.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa7.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa7.setText("Mesa 7");
        btnMesa7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 214, 250));

        btnMesa8.setBackground(new java.awt.Color(0, 102, 0));
        btnMesa8.setFont(new java.awt.Font("Wide Latin", 1, 22)); // NOI18N
        btnMesa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); // NOI18N
        btnMesa8.setText("Mesa 8");
        btnMesa8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 200, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMesa.jpg"))); // NOI18N
        jLabel1.setText("MESA DISPONIBLE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 605));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
  /* if (Inter1 == null || !Inter1.isDisplayable()) { otro metodo
            Inter1 = new Interfaz_mesa_1();
            Inter1.setVisible(true);
        } else {
            Inter1.toFront(); 
        }
   OTRO METODO PARA ABRIR LA VENTANA SIN CERRAR LA PRINCIPAL
    cambiarEstadoBoton(btnMesa1, "MESA1");
    Interfaz_mesa_1 Inter1 = new Interfaz_mesa_1();
    Inter1.setVisible(true);*/
    
   btnMesa1.setBackground(Color.RED); // Cambia el color a rojo
    Interfaz_mesa_1 Inter1 = new Interfaz_mesa_1();
    
    // Agregamos un listener para detectar cuando se cierra la ventana
    Inter1.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            btnMesa1.setBackground(Color.GREEN); // Cambia a verde cuando se cierra
        }
    });

    Inter1.setVisible(true);
  
    
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void btnMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa2ActionPerformed
   /*     cambiarEstadoBoton(btnMesa2, "MESA2");
    Interfaz_mesa_2 Inter2 = new Interfaz_mesa_2();
    Inter2.setVisible(true);    */
                                          
    btnMesa2.setBackground(Color.RED); 
    btnMesa2.revalidate();
    btnMesa2.repaint(); 

    Interfaz_mesa_2 Inter2 = new Interfaz_mesa_2();

    
    Inter2.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            btnMesa2.setBackground(Color.GREEN); 
            btnMesa2.revalidate();
            btnMesa2.repaint(); 
        }
    });

    Inter2.setVisible(true);


   
   
    }//GEN-LAST:event_btnMesa2ActionPerformed

    private void btnMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa3ActionPerformed
        btnMesa3.setBackground(Color.RED); // Cambia el color a rojo
    btnMesa3.revalidate();
    btnMesa3.repaint(); // Forzar la actualización del color

    Interfaz_mesa_3 Inter3 = new Interfaz_mesa_3();

    // Listener para detectar cuando se cierra la ventana
    Inter3.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            btnMesa3.setBackground(Color.GREEN); // Cambia a verde cuando se cierra
            btnMesa3.revalidate();
            btnMesa3.repaint(); // Forzar la actualización
        }
    });

    Inter3.setVisible(true);
    }//GEN-LAST:event_btnMesa3ActionPerformed

    private void btnMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa4ActionPerformed
        
        btnMesa4.setBackground(Color.RED); // Cambia el color a rojo
    btnMesa4.revalidate();
    btnMesa4.repaint(); // Forzar la actualización del color

    Interfaz_mesa_4 Inter4 = new Interfaz_mesa_4();

    // Listener para detectar cuando se cierra la ventana
    Inter4.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            btnMesa4.setBackground(Color.GREEN); // Cambia a verde cuando se cierra
            btnMesa4.revalidate();
            btnMesa4.repaint(); // Forzar la actualización
        }
    });

    Inter4.setVisible(true);
    }//GEN-LAST:event_btnMesa4ActionPerformed

    private void btnMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa5ActionPerformed
        btnMesa5.setBackground(Color.RED);
    btnMesa5.revalidate();
    btnMesa5.repaint();

    Interfaz_mesa_5 Inter5 = new Interfaz_mesa_5();

    Inter5.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            btnMesa5.setBackground(Color.GREEN);
            btnMesa5.revalidate();
            btnMesa5.repaint();
        }
    });

    Inter5.setVisible(true);
    }//GEN-LAST:event_btnMesa5ActionPerformed

    private void btnMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa6ActionPerformed
         btnMesa6.setBackground(Color.RED);
    btnMesa6.revalidate();
    btnMesa6.repaint();

    Interfaz_mesa_6 Inter6 = new Interfaz_mesa_6();

    Inter6.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            btnMesa6.setBackground(Color.GREEN);
            btnMesa6.revalidate();
            btnMesa6.repaint();
        }
    });

    Inter6.setVisible(true);
    }//GEN-LAST:event_btnMesa6ActionPerformed

    private void btnMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa7ActionPerformed
       btnMesa7.setBackground(Color.RED);
    btnMesa7.revalidate();
    btnMesa7.repaint();

    Interfaz_mesa_7 Inter7 = new Interfaz_mesa_7();

    Inter7.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            btnMesa7.setBackground(Color.GREEN);
            btnMesa7.revalidate();
            btnMesa7.repaint();
        }
    });

    Inter7.setVisible(true);
    }//GEN-LAST:event_btnMesa7ActionPerformed

    private void btnMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa8ActionPerformed
           btnMesa8.setBackground(Color.RED);
    btnMesa8.revalidate();
    btnMesa8.repaint();

    Interfaz_mesa_8 Inter8 = new Interfaz_mesa_8();

    Inter8.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            btnMesa8.setBackground(Color.GREEN);
            btnMesa8.revalidate();
            btnMesa8.repaint();
        }
    });

    Inter8.setVisible(true);
    }//GEN-LAST:event_btnMesa8ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
    this.dispose(); // Cierra la ventana actual (FrameMesas)
    FrmIndex frmIndex = new FrmIndex(); // Crea una nueva instancia de FrmIndex
    frmIndex.setVisible(true); // Muestra FrmIndex
    }//GEN-LAST:event_btnRegresarActionPerformed

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
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
