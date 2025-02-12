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
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;


public class Interfaz_mesa_4 extends javax.swing.JFrame {
     private static final byte[] CUT_PAPER = { 0x1D, 0x56, 0x01 };
    private ArrayList<String> pedidos = new ArrayList<>();
    private ArrayList<String> pedidosCocina = new ArrayList<>();
    private double total = 0.0;
    private int numMesa=1;
    private ArrayList<Integer> indicesPedidos = new ArrayList<>(); 
    private boolean cabeceraAgregada = false;
    // Declarar una lista para los importes
    private ArrayList<Double> importesPedidos = new ArrayList<>();
    private ArrayList<String> pedidosImpresos = new ArrayList<>();
    
    String nombreRestaurante = "TRES COPAS";
    
    
    public Interfaz_mesa_4() {
        this.setSize(860, 605);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("MESA 4");
        initComponents();
        //////////////////////// DESCUENTO CON IMAGEN CLICKEABLE////////////////////////////////////////////////////////
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        aplicarDescuento();
        }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////// ELIMINAR PLATOS ///////////////////////////////////////////////////////////////////////////
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        aplicarLimpieza();
        }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Llenar ComboBox al iniciar la interfaz
        llenarCategorias();
        // Agregar eventos para actualizar platos y precio
        cboxCategorias.addActionListener(e -> actualizarPlatos());
        cboxPlatos.addActionListener(e -> actualizarPrecio());
        //Limitar el negativo al spinner cantidad
        spCantidad.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
    }

   //////////////////////// LOGICA DEL LOGO DEL PROGRAMA ////////////////////////////////////////////////////////
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo.jpg"));
        return retValue;
    }
    private void aplicarDescuento() {
    try {
        // Mostrar un cuadro de diálogo para ingresar el descuento
        String input = JOptionPane.showInputDialog(null, "Ingrese el porcentaje de descuento:", "Aplicar Descuento", JOptionPane.QUESTION_MESSAGE);

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
        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
          ////////////////////////////////////////// ELIMINAR PLATOS - LOGICA /////////////////////////////////////////////////////////////////
private void aplicarLimpieza() { 
    String input = JOptionPane.showInputDialog("Ingrese el número del pedido a eliminar:");

    if (input != null) {
        try {
            int idEliminar = Integer.parseInt(input);

            // Buscar el índice del ID en la lista de índices
            int index = indicesPedidos.indexOf(idEliminar);

            if (index != -1) {
                // Restar el importe eliminado del total
                total -= importesPedidos.get(index);

                // Eliminar el ID, pero sin alterar los demás
                indicesPedidos.remove(index);
                pedidos.remove(index);
                pedidosCocina.remove(index);
                importesPedidos.remove(index);

                // Actualizar txtA
                txtA.setText("");
                cabeceraAgregada = false;

                // Volver a mostrar los pedidos sin el eliminado
                if (!pedidos.isEmpty()) {
                    txtA.append(String.format("%-5s | %-3s | %-15s | %-6s | %s%n", "ID", "CANT", "CONCEPTO", "PRECIO", "DETALLE"));
                    cabeceraAgregada = true;
                }

                for (int i = 0; i < pedidos.size(); i++) {
                    txtA.append(String.format("%-5d | %s%n", indicesPedidos.get(i), pedidos.get(i)));
                }

                JOptionPane.showMessageDialog(null, "El Plato/Bebida se ha eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el número de pedido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA = new javax.swing.JTextArea();
        spCantidad = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTicketCli1 = new javax.swing.JButton();
        btnTicketCocina = new javax.swing.JButton();
        btnAgregar1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
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
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 130, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MESA:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CATEGORIAS:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 250, 40));

        txtA.setColumns(20);
        txtA.setRows(5);
        jScrollPane1.setViewportView(txtA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 290, 280));

        spCantidad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(spCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 60, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoInterface.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 130, 110));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descuento-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 70, 90));

        btnTicketCli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura-removebg-preview.png"))); // NOI18N
        btnTicketCli1.setText("TICKET - CLIENTE");
        btnTicketCli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketCli1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTicketCli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 190, 60));

        btnTicketCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ticket1-removebg-preview.png"))); // NOI18N
        btnTicketCocina.setText("TICKET-COCINA ");
        btnTicketCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketCocinaActionPerformed(evt);
            }
        });
        getContentPane().add(btnTicketCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 190, 60));

        btnAgregar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregar1.setText("      AGREGAR");
        btnAgregar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgregar1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 230, 70));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bote-de-basura.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 60, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMesa.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMesa.jpg"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnTicketCli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketCli1ActionPerformed
        String url = "jdbc:mysql://localhost:3306/mi_base_de_datos";
        String user = "root";
        String password = "root";
        String sql = "INSERT INTO ventas (numMesa, fecha, hora, total) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numMesa);
            stmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            stmt.setTime(3, java.sql.Time.valueOf(LocalTime.now()));
            stmt.setDouble(4, total);

            stmt.executeUpdate();
            System.out.println("Venta registrada exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        cboxCategorias.setSelectedIndex(0);
    cboxPlatos.setSelectedIndex(0);
    spCantidad.setValue(0);
    txtPrecio.setText("");
    txtA.setText("");
    txtDetalles.setText("");
        
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
        txtA.setText(" ");  
        cabeceraAgregada = false;
        total = 0.0;

        JOptionPane.showMessageDialog(null, "Impresión realizada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al imprimir: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    }//GEN-LAST:event_btnTicketCli1ActionPerformed

    private void btnTicketCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketCocinaActionPerformed
        try {
        // Identificar los nuevos pedidos que aún no se han impreso
        ArrayList<String> nuevosPedidos = new ArrayList<>(pedidosCocina);
        nuevosPedidos.removeAll(pedidosImpresos); // Quitar los ya impresos

        // Si no hay nuevos pedidos, no imprimir nada
        if (nuevosPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay nuevos pedidos para imprimir.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Generar ticket solo con los nuevos pedidos
        String ticketTexto = generarTicketCocina(nuevosPedidos);
        
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

        // Agregar los pedidos impresos a la lista de control
        pedidosImpresos.addAll(nuevosPedidos);

        JOptionPane.showMessageDialog(null, "Impresión realizada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al imprimir: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnTicketCocinaActionPerformed
    private int contadorPedidos = 1; // Para numerar los pedidos
    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
       String plato = cboxPlatos.getSelectedItem().toString();
    String categoria = cboxCategorias.getSelectedItem().toString();
    double precio = 0.0;
    int cantidad = (int) spCantidad.getValue();
    String detalles = txtDetalles.getText().trim();

    if (plato.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        if (!txtPrecio.getText().isEmpty()) {
            precio = Double.parseDouble(txtPrecio.getText());
        }
        double importe = precio * cantidad;

        // 🛒 **Ticket Cliente**
        if (!categoria.equalsIgnoreCase("Cocina")) {
            String pedidoCliente = String.format("%-3d %-20s %10.2f %10.2f",cantidad, plato, precio, importe);
            pedidos.add(pedidoCliente);
            total += importe;
        }

        // 👨‍🍳 **Ticket Cocina**
        String pedidoCocina = String.format("%-3d %-20s %-20s",cantidad, plato, detalles);
        pedidosCocina.add(pedidoCocina);

        // Guardar el índice del pedido
        indicesPedidos.add(contadorPedidos);
        importesPedidos.add(importe);
        contadorPedidos++;

        // Mostrar en txtA
        txtA.setEditable(false);
        if (!cabeceraAgregada) {
            txtA.append(String.format("%-5s | %-3s | %-15s | %-6s | %s%n", "ID", "CANT", "CONCEPTO", "PRECIO", "DETALLE"));
            cabeceraAgregada = true;
        }

        txtA.append(String.format("%-5d | %-3d | %-15s | %-6.2f | %s%n", contadorPedidos - 1, cantidad, plato, precio, detalles));

        // Limpiar campos
        cboxPlatos.setSelectedIndex(-1);
        txtPrecio.setText("");
        txtDetalles.setText("");  

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Valores numéricos incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAgregar1ActionPerformed
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

    ////////////////////////////////////   METODO GENERAR TICKET-COCINA  ///////////////////////////////////////////////////////
    
   private String generarTicketCocina(ArrayList<String> pedidos) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String numeroMesa = "MESA 1";
    String dobleTamano = "\u001B!\u0030";  // ESC ! 0x30 -> Fuente más grande (doble altura)
    String reset = "\u001B!\u0000";

    String ticket =
        dobleTamano + "        " + numeroMesa + reset + "\n\n" +  // Agrandar nombre hay 18 bits en cada espacio 
        sdf.format(new Date()) + "\n" +
        "================================================\n" +
        "CANT.    MENU             DETALLES\n" +
        "------------------------------------------------\n";

    // Agregar cada pedido de la lista recibida
    for (String pedido : pedidos) {
        ticket += pedido + "\n";
    }

    return ticket;
}

    
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
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
            java.util.logging.Logger.getLogger(Interfaz_mesa_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_mesa_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_mesa_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_mesa_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_mesa_4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnTicketCli1;
    private javax.swing.JButton btnTicketCocina;
    private javax.swing.JComboBox<String> cboxCategorias;
    private javax.swing.JComboBox<String> cboxPlatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JTextArea txtA;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
