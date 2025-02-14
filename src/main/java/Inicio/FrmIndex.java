/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inicio;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import Interfaz_Mesas.FrameMesas;
import com.mycompany.app_restaurante.RegistrarPlatos.FrameRegistrarPlatos;
import java.awt.Image;
import java.awt.Toolkit;
import ListaVentas.VentasLista;


public class FrmIndex extends javax.swing.JFrame {
         private static FrmIndex instance;
        private FrameMesas v1; 
        private FrameRegistrarPlatos v2;
        private VentasLista v3;
    /**
     * Creates new form FrmIndex
     */
    public FrmIndex() {
        
        this.setSize(860, 605);
        this.setLocationRelativeTo(null);
        this.setTitle("INICIO");
        this.setResizable(false);
        initComponents();
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          
    }
    public static FrmIndex getInstance() {
        if (instance == null) {
            instance = new FrmIndex();
        }
        return instance;
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

        btnListarCajas = new javax.swing.JButton();
        btnMesa = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        btnRegistrarPlato = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnListarCajas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caja-registradora.png"))); // NOI18N
        btnListarCajas.setText("  Listar Cajas");
        btnListarCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarCajasActionPerformed(evt);
            }
        });
        getContentPane().add(btnListarCajas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 215, 114));

        btnMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tabla.png"))); // NOI18N
        btnMesa.setText("  Mesas Disponible");
        btnMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesaActionPerformed(evt);
            }
        });
        getContentPane().add(btnMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 215, 114));

        titulo.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("RESTAURANTE TRES COPAS");
        titulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        titulo.setIconTextGap(15);
        titulo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 500, 52));

        btnRegistrarPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hamburguesa.png"))); // NOI18N
        btnRegistrarPlato.setText("  Registrar Plato");
        btnRegistrarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPlatoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 215, 114));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TablaInicio.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 720, 140));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoIndex.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setMaximumSize(new java.awt.Dimension(860, 605));
        jLabel4.setMinimumSize(new java.awt.Dimension(860, 605));
        jLabel4.setPreferredSize(new java.awt.Dimension(860, 605));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 605));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setInicio(FrmIndex inicios){
    }
    
    
    private void btnRegistrarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPlatoActionPerformed
    if (v2 == null || !v2.isDisplayable()) { // con este metodo comparamos si la venta exite o si ha cerrado 
        v2 = new FrameRegistrarPlatos();
        v2.setVisible(true);
    } else {
        v2.toFront(); // este linea hacemos que la ventana aparesca primero
    }
    }//GEN-LAST:event_btnRegistrarPlatoActionPerformed
    
    private void btnListarCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarCajasActionPerformed
         if (v3 == null || !v3.isDisplayable()) { 
        v3 = new VentasLista(this); // Crea la instancia solo una vez
        v3.setVisible(true);
        this.setVisible(false); // Oculta FrmIndex en lugar de cerrarlo
    } else {
        v3.toFront(); // Trae la ventana al frente si ya está abierta
    }
    }//GEN-LAST:event_btnListarCajasActionPerformed

    private void btnMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesaActionPerformed
        if (v1 == null || !v1.isDisplayable()) { 
        v1 = new FrameMesas(this); // Ahora debe funcionar correctamente
        v1.setVisible(true);
        this.setVisible(false); // Oculta FrmIndex en lugar de cerrarlo
        } else {
        v1.toFront(); 
        }
    }//GEN-LAST:event_btnMesaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarCajas;
    private javax.swing.JButton btnMesa;
    private javax.swing.JButton btnRegistrarPlato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
