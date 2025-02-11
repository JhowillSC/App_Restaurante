/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz_Mesas;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Interfaz_mesa_6 extends javax.swing.JFrame {
   private static final byte[] CUT_PAPER = { 0x1D, 0x56, 0x01 };
    private ArrayList<String> pedidos = new ArrayList<>();
    private ArrayList<String> pedidosCocina = new ArrayList<>();
    private double total = 0.0;
    private int numMesa=6; 
    String nombreRestaurante = "TRES COPAS";

    public Interfaz_mesa_6() {
        
        this.setSize(860, 605);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("MESA 1");
        initComponents();
        // Llenar ComboBox al iniciar la interfaz
        llenarCategorias();
        // Agregar eventos para actualizar platos y precio
        cboxCategorias.addActionListener(e -> actualizarPlatos());
        cboxPlatos.addActionListener(e -> actualizarPrecio());
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

        txtPrecio = new javax.swing.JTextField();
        cboxCategorias = new javax.swing.JComboBox<>();
        cboxPlatos = new javax.swing.JComboBox<>();
        txtDetalles = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnDescuento = new javax.swing.JButton();
        btnTicketCli = new javax.swing.JButton();
        txtTicketCocina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        spCantidad = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 70, 40));

        cboxCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriasActionPerformed(evt);
            }
        });
        getContentPane().add(cboxCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 230, 40));

        cboxPlatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BEBIDAS", "HAMBURGESAS ", "BURRITOS", " " }));
        cboxPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxPlatosActionPerformed(evt);
            }
        });
        getContentPane().add(cboxPlatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 290, 40));
        getContentPane().add(txtDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 270, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PRECIO:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 150, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DETALLES:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 200, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CANTIDAD:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 170, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PLATO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 140, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TICKET:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 210, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MESA:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CATEGORIAS:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 250, 40));

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 190, 50));

        btnDescuento.setText("DESCUENTO");
        btnDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 190, 50));

        btnTicketCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura-removebg-preview.png"))); // NOI18N
        btnTicketCli.setText("TICKET - CLIENTE");
        btnTicketCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketCliActionPerformed(evt);
            }
        });
        getContentPane().add(btnTicketCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 190, 50));

        txtTicketCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticket1-removebg-preview.png"))); // NOI18N
        txtTicketCocina.setText("TICKET-COCINA ");
        txtTicketCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTicketCocinaActionPerformed(evt);
            }
        });
        getContentPane().add(txtTicketCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 190, 50));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 260, 250));

        spCantidad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(spCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 60, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/6-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMesa.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void cboxCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxCategoriasActionPerformed

    private void cboxPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPlatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxPlatosActionPerformed
        /////////////////////////// METODO GENERAR TICKET - CLIENTE ////////////////////////////////////////////////////////
    private String generarTicket() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dobleTamano = "\u001B!\u0030"; 
        String reset = "\u001B!\u0000";
    
        String ticket = 
            "                    RESTAURANTE \n" +
        dobleTamano + "       " + nombreRestaurante + reset + "\n\n" +  
            "        SAN MARTIN DE PORRES --- 1RA ETAPA \n" +
            "         ASOCIACION SENOR DE LOS MILAGROS\n" +
            "                  MZ LL LOTE 31\n" +
            "                TEL:+51 951257364\n" +
            "================================================\n" +
            "MESA # " + numMesa + "\n" +
            sdf.format(new Date()) + "\n" +
            "================================================\n" +
            "CANT.   CONCEPTO             PRECIO     IMPORTE\n" +
            "------------------------------------------------\n";

        // Agregar cada pedido (simulación de estructura de tabla)
        for (String pedido : pedidos) {
            ticket += pedido + "\n";
        }

        // Total y resumen de compra
        ticket += 
            "------------------------------------------------\n" +
            String.format("TOTAL: %39.2f\n", total) +
            "================================================\n" +
            "             GRACIAS POR SU VISITA\n" +
            "           ESPERAMOS VERLO NUEVAMENTE\n" +
            "\n\n";

            return ticket;
}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    /////////////////////////// METODO LLENAR COMBO BOX - CAREGORIAS ///////////////////////////////////////////////////
    
    private void llenarCategorias() {
        String sql = "SELECT DISTINCT categoria FROM platos";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "root", "root");
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
             
            cboxCategorias.removeAllItems();
            while (rs.next()) {
                String categoria = rs.getString("categoria");
                if (categoria != null && !categoria.trim().isEmpty()) {
                    cboxCategorias.addItem(categoria);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   ///////////////////////////  METODO FILTRO PLATO - CATEGORIA  ///////////////////////////////////////////////////////
    
    private void llenarPlatosPorCategoria(String categoria) {
        String sql = "SELECT nombre FROM platos WHERE categoria = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "root", "root");
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, categoria);
            try (ResultSet rs = pst.executeQuery()) {
                cboxPlatos.removeAllItems();
                while (rs.next()) {
                    cboxPlatos.addItem(rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   ///////////////////////////  METODO LLENAR PRECIO AUTOMATICO ///////////////////////////////////////////////////////
    
    private void llenarPrecioPlato(String plato) {
        String sql = "SELECT precio FROM platos WHERE nombre = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "root", "root");
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, plato);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    txtPrecio.setText(rs.getString("precio"));
                    txtPrecio.setEditable(false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////////   METODO ACTUALIZAR PLATOS   ///////////////////////////////////////////////////////
    
    private void actualizarPlatos() {
        String categoriaSeleccionada = (String) cboxCategorias.getSelectedItem();
        if (categoriaSeleccionada != null) {
            llenarPlatosPorCategoria(categoriaSeleccionada);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /////////////////////////////////   METODO ACTUALIZAR PLATOS   ///////////////////////////////////////////////////////
    
    private void actualizarPrecio() {
        String platoSeleccionado = (String) cboxPlatos.getSelectedItem();
        if (platoSeleccionado != null) {
            llenarPrecioPlato(platoSeleccionado);
        }
    }
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void btnTicketCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketCliActionPerformed
        String ticketTexto = generarTicket();

    try {
        // Código ESC/POS para corte total de papel
        byte[] cortarPapel = new byte[]{ 0x1D, 0x56, 0x41, 0x10 };

        // Convertir ticket a bytes
        byte[] ticketBytes = ticketTexto.getBytes("UTF-8");

        // Combinar los bytes del ticket con los del comando de corte
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(ticketBytes);
        outputStream.write(cortarPapel);
        byte[] bytesFinales = outputStream.toByteArray();

        // Especificamos el tipo de dato a imprimir (bytes, autodetectado)
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        // Buscar la impresora "80mm Series Printer"
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor, null);
        PrintService selectedService = null;

        for (PrintService service : printServices) {
            if (service.getName().equalsIgnoreCase("80mm Series Printer")) {
                selectedService = service;
                break;
            }
        }

        // Si no se encuentra la impresora, mostrar error
        if (selectedService == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la impresora 80mm Series Printer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear documento a imprimir
        DocPrintJob job = selectedService.createPrintJob();
        Doc doc = new SimpleDoc(bytesFinales, flavor, null);

        // Intentar imprimir
        job.print(doc, null);

        // Limpiar la lista de pedidos y total después de la impresión
        pedidos.clear();
        total = 0.0;

        JOptionPane.showMessageDialog(null, "Impresión realizada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al imprimir: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }  
    }//GEN-LAST:event_btnTicketCliActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       String plato = cboxPlatos.getSelectedItem().toString();
        String categoria = cboxCategorias.getSelectedItem().toString(); // Categoría para diferenciar
        double precio = 0.0;
        int cantidad = (int) spCantidad.getValue();
        String detalles = txtDetalles.getText().trim(); // Nuevo campo para detalles

        if (plato.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        try {
        if (!txtPrecio.getText().isEmpty()) {
            precio = Double.parseDouble(txtPrecio.getText()); 
        }
        double importe = precio * cantidad;

        // 🛒 **Ticket Cliente** (Incluye precio e importe)
        if (!categoria.equalsIgnoreCase("Cocina")) {  
            String pedidoCliente = String.format("%-3d %-20s %10.2f %10.2f", cantidad, plato, precio, importe);
            pedidos.add(pedidoCliente);
            total += importe;
        }

        // 👨‍🍳 **Ticket Cocina** (Cantidad - Menú - Detalles)
        String pedidoCocina = String.format("%-3d %-20s %-20s", cantidad, plato, detalles);
        pedidosCocina.add(pedidoCocina);

        // Limpiar campos
        cboxPlatos.setSelectedIndex(-1);
        txtPrecio.setText("");
        txtDetalles.setText("");  // Limpiar detalles también

        } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Valores numéricos incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    ///////////////////////////////////////   METODO GENERAR TICKET-COCINA  ///////////////////////////////////////////////////////
    
    private String generarTicketCocina() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String numeroMesa="MESA 6";
        String dobleTamano = "\u001B!\u0030";  // ESC ! 0x10 -> Fuente más grande (doble altura)
        String reset = "\u001B!\u0000";
    
        String ticket = 
        dobleTamano + "      " + numeroMesa+ reset + "\n\n" +  // Agrandar nombre hay 18 bits en cada espacio 
                          sdf.format(new Date()) + "\n" +
            "================================================\n" +
            "CANT.    MENU             DETALLES\n" +
            "------------------------------------------------\n";
        
            // Agregar cada pedido 
            for (String pedido : pedidosCocina) {
            ticket += pedido + "\n";
        }
            return ticket;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void txtTicketCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTicketCocinaActionPerformed
        String ticketTexto = generarTicketCocina();

    try {
        // Código ESC/POS para corte total de papel
        byte[] cortarPapel = new byte[]{ 0x1D, 0x56, 0x41, 0x10 };

        // Convertir ticket a bytes
        byte[] ticketBytes = ticketTexto.getBytes("UTF-8");

        // Combinar los bytes del ticket con los del comando de corte
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(ticketBytes);
        outputStream.write(cortarPapel);
        byte[] bytesFinales = outputStream.toByteArray();

        // Especificamos el tipo de dato a imprimir (bytes, autodetectado)
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        // Buscar la impresora "80mm Series Printer"
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor, null);
        PrintService selectedService = null;

        for (PrintService service : printServices) {
            if (service.getName().equalsIgnoreCase("80mm Series Printer")) {
                selectedService = service;
                break;
            }
        }

        // Si no se encuentra la impresora, mostrar error
        if (selectedService == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la impresora 80mm Series Printer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear documento a imprimir
        DocPrintJob job = selectedService.createPrintJob();
        Doc doc = new SimpleDoc(bytesFinales, flavor, null);

        // Intentar imprimir
        job.print(doc, null);

        // Limpiar la lista de pedidos y total después de la impresión
        pedidosCocina.clear();
    

        JOptionPane.showMessageDialog(null, "Impresión realizada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al imprimir: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }  
                                                  
    }//GEN-LAST:event_txtTicketCocinaActionPerformed

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed
     try {
        // Mostrar un cuadro de diálogo para ingresar el descuento
        String input = JOptionPane.showInputDialog(this, "Ingrese el porcentaje de descuento:", "Aplicar Descuento", JOptionPane.QUESTION_MESSAGE);
        
        // Verificar si el usuario ingresó un valor válido
        if (input != null && !input.trim().isEmpty()) {
            double descuento = Double.parseDouble(input); // Convertir a número

            // Obtener el precio actual
            double precioActual = Double.parseDouble(txtPrecio.getText());

            // Calcular el nuevo precio con el descuento aplicado
            double nuevoPrecio = precioActual - (precioActual * (descuento / 100));

            // Establecer el nuevo precio en el campo txtPrecio
            txtPrecio.setText(String.format("%.2f", nuevoPrecio));
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }   
    }//GEN-LAST:event_btnDescuentoActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz_mesa_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_mesa_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_mesa_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_mesa_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_mesa_6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDescuento;
    private javax.swing.JButton btnTicketCli;
    private javax.swing.JComboBox<String> cboxCategorias;
    private javax.swing.JComboBox<String> cboxPlatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JButton txtTicketCocina;
    // End of variables declaration//GEN-END:variables
}
