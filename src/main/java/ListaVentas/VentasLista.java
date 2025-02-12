package ListaVentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Inicio.FrmIndex;

public class VentasLista extends JFrame {
    private JPanel panelVentas;
    private JScrollPane scrollPane;
    
    private final String url = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private final String user = "root";
    private final String password = "root";

    public VentasLista(FrmIndex frmindex) {
        
        setTitle("Lista de Ventas");
        this.setSize(860, 605);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setIconImage(getIconImage());

        FondoPanel fondoPanel = new FondoPanel("/imagenes/fondoMesa.jpg");
        fondoPanel.setLayout(new BorderLayout());
        setContentPane(fondoPanel);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setOpaque(false);
        
        JButton btnRegresar = new JButton("REGRESAR");
        btnRegresar.setPreferredSize(new Dimension(100, 30));
        btnRegresar.addActionListener(e -> {
        dispose(); // Cierra la ventana actual
        FrmIndex frmIndex = new FrmIndex(); // Crea una nueva instancia de FrmIndex
        frmIndex.setVisible(true); // Muestra FrmIndex
        });
        
        JButton btnDiaTotal = new JButton("DIA_TOTAL");
        btnDiaTotal.setPreferredSize(new Dimension(100, 30));
        btnDiaTotal.addActionListener(e -> {
            String fechaInput = JOptionPane.showInputDialog(VentasLista.this, "Digite la fecha (yyyy-MM-dd):");
            if (fechaInput != null && !fechaInput.trim().isEmpty()) {
                obtenerVentaTotalPorFecha(fechaInput);
            }
        });
        
        panelSuperior.add(btnRegresar, BorderLayout.WEST);
        panelSuperior.add(btnDiaTotal, BorderLayout.EAST);
        fondoPanel.add(panelSuperior, BorderLayout.NORTH);

        panelVentas = new JPanel();
        panelVentas.setLayout(new BoxLayout(panelVentas, BoxLayout.Y_AXIS));
        panelVentas.setOpaque(false);

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
    

    @Override
    public Image getIconImage() {
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.jpg"));
    }

    private void obtenerVentaTotalPorFecha(String fechaInput) {
        String sqlTotal = "SELECT fecha, SUM(total) AS total_ventas FROM ventas WHERE fecha = ? GROUP BY fecha";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sqlTotal)) {
            
            pstmt.setString(1, fechaInput);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    double totalVentas = rs.getDouble("total_ventas");
                    JOptionPane.showMessageDialog(this, "La venta total del dÃ­a " + fechaInput + " es: S/ " + totalVentas);
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

                JPanel tarjeta = new JPanel();
                tarjeta.setLayout(new BorderLayout());
                tarjeta.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, true));
                tarjeta.setOpaque(false);
                tarjeta.setPreferredSize(new Dimension(550, 90));
                tarjeta.setMaximumSize(new Dimension(550, 90));

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
                panelVentas.add(Box.createVerticalStrut(10));
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
        
       SwingUtilities.invokeLater(() -> {
    FrmIndex frmIndex = new FrmIndex(); // Crear instancia de FrmIndex
    new VentasLista(frmIndex).setVisible(true); // Pasar FrmIndex al constructor
});
    }
}