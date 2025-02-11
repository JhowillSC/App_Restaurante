package ListaVentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class VentasLista extends JFrame {
    private JPanel panelVentas;
    private JScrollPane scrollPane;
    
    // Variables de conexión
    private final String url = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private final String user = "root";
    private final String password = "root";

    public VentasLista() {
        setTitle("Lista de Ventas");
        this.setSize(860, 605);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Establecer icono del programa
        setIconImage(getIconImage());

        // Establecer el fondo de la ventana con la imagen
        FondoPanel fondoPanel = new FondoPanel("/imagenes/fondoMesa.jpg");
        fondoPanel.setLayout(new BorderLayout());
        setContentPane(fondoPanel);

        // Crear el botón "DIA_TOTAL" en la parte superior
        JButton btnDiaTotal = new JButton("DIA_TOTAL");
        btnDiaTotal.setPreferredSize(new Dimension(100, 30));
        btnDiaTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pedir al usuario que ingrese la fecha
                String fechaInput = JOptionPane.showInputDialog(VentasLista.this, "Digite la fecha (yyyy-MM-dd):");
                if (fechaInput != null && !fechaInput.trim().isEmpty()) {
                    obtenerVentaTotalPorFecha(fechaInput);
                }
            }
        });

        // Panel superior para colocar el botón
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.setOpaque(false); // Hacerlo transparente para ver el fondo
        panelSuperior.add(btnDiaTotal);
        fondoPanel.add(panelSuperior, BorderLayout.NORTH);

        // Panel central para mostrar las tarjetas de ventas
        panelVentas = new JPanel();
        panelVentas.setLayout(new BoxLayout(panelVentas, BoxLayout.Y_AXIS));
        panelVentas.setOpaque(false);

        // Contenedor para que el JScrollPane maneje bien las tarjetas
        JPanel contenedor = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        contenedor.setOpaque(false);
        contenedor.add(panelVentas);

        scrollPane = new JScrollPane(contenedor);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        fondoPanel.add(scrollPane, BorderLayout.CENTER);

        cargarDatos();
    }

    /**
     * Método para cambiar el icono del programa.
     */
    @Override
    public Image getIconImage() {
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.jpg"));
    }

    /**
     * Método para obtener el total de ventas para una fecha ingresada
     */
    private void obtenerVentaTotalPorFecha(String fechaInput) {
        String sqlTotal = "SELECT fecha, SUM(total) AS total_ventas FROM ventas WHERE fecha = ? GROUP BY fecha";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sqlTotal)) {
             
            pstmt.setString(1, fechaInput);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    double totalVentas = rs.getDouble("total_ventas");
                    JOptionPane.showMessageDialog(this, "La venta total del día " + fechaInput + " es: S/ " + totalVentas);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron ventas para la fecha " + fechaInput);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener el total de ventas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatos() {
        String sql = "SELECT id, numMesa, fecha, hora, total FROM ventas";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int numMesa = rs.getInt("numMesa");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                double total = rs.getDouble("total");

                // Crear tarjeta visual
                JPanel tarjeta = new JPanel();
                tarjeta.setLayout(new BorderLayout());
                tarjeta.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, true));
                tarjeta.setOpaque(false);
                tarjeta.setPreferredSize(new Dimension(550, 90));
                tarjeta.setMaximumSize(new Dimension(550, 90));

                // Crear etiquetas con iconos y texto en blanco
                JLabel lblInfo = crearEtiquetaConIcono("/imagenes/cart_fin.png", "Ticket #" + id + " | Mesa: " + numMesa);
                lblInfo.setFont(new Font("Arial", Font.BOLD, 17));
                lblInfo.setForeground(Color.WHITE);

                JPanel detallesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
                detallesPanel.setOpaque(false);

                JLabel lblCalendar = crearEtiquetaConIcono("/imagenes/calendario.png", fecha.toString());
                lblCalendar.setForeground(Color.WHITE);
                JLabel lblClock = crearEtiquetaConIcono("/imagenes/time.png", hora.toString());
                lblClock.setForeground(Color.WHITE);
                JLabel lblMoney = crearEtiquetaConIcono("/imagenes/dinero.png", "Total: S/ " + total);
                lblMoney.setForeground(Color.WHITE);

                detallesPanel.add(lblCalendar);
                detallesPanel.add(lblClock);
                detallesPanel.add(lblMoney);

                tarjeta.add(lblInfo, BorderLayout.NORTH);
                tarjeta.add(detallesPanel, BorderLayout.CENTER);

                panelVentas.add(tarjeta);
                panelVentas.add(Box.createVerticalStrut(10)); // Espaciado entre tarjetas
            }

            panelVentas.revalidate();
            panelVentas.repaint();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JLabel crearEtiquetaConIcono(String ruta, String texto) {
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image imagen = icono.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);
        JLabel etiqueta = new JLabel(texto, icono, JLabel.LEFT);
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 16));
        return etiqueta;
    }

    // Clase interna para el fondo
    class FondoPanel extends JPanel {
        private Image fondo;

        public FondoPanel(String rutaImagen) {
            ImageIcon imagenIcono = new ImageIcon(getClass().getResource(rutaImagen));
            this.fondo = imagenIcono.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentasLista().setVisible(true));
    }
}
