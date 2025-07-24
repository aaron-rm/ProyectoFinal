package bInterfaz;

import cSistema.aUsuario.Cliente;
import cSistema.bProductos.*;

import javax.swing.*;
import java.awt.*;

public class InterfazProductos {
    private final int ICON_SCALE = 30;
    private JPanel InterfazPrincipal;
    private JButton cerrarSesiónButton;
    private JButton volverButton;
    private JButton carroDeComprasButton;
    private JComboBox filtroBusqueda;
    private JPanel resultadosProductos;
    private JButton actualizarResultadosButton;
    private JButton agregarAlCarritoButton;
    private JComboBox eleccionProducto;
    private JComboBox cantidadProducto;
    private JPanel panelContenido;

    public InterfazProductos(Cliente cliente){
        //frame principal
        JFrame frame = new JFrame("\uD835\uDE4E\uD835\uDE65\uD835\uDE5A\uD835\uDE5A\uD835\uDE59\uD835\uDE47\uD835\uDE56\uD835\uDE57 | Productos");
        frame.setVisible(true);
        frame.setContentPane(getInterfazPrincipal());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(720,480);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        ImageIcon iconEmpresa = new ImageIcon(getClass().getResource("/images/SpeedLab LOGO.png"));
        frame.setIconImage(iconEmpresa.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE, Image.SCALE_SMOOTH));



        ImageIcon iconUsuario = new ImageIcon(getClass().getResource("/images/usuario.png"));
        cerrarSesiónButton.setIcon(new ImageIcon(iconUsuario.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH)));
        cerrarSesiónButton.addActionListener(e -> {
            frame.dispose();
            new InterfazCuenta();
        });

        volverButton.addActionListener(e -> {
            frame.dispose();
            new InterfazPrincipal(cliente);
        });


        CatalogoManager catalogo = new CatalogoManager();
        int cantProductos = catalogo.getTotalProductos();
        panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        resultadosProductos.setLayout(new BorderLayout());
        resultadosProductos.add(scrollPane, BorderLayout.CENTER);
        panelContenido.setVisible(false);
        //ver resultado del filtro
        actualizarResultadosButton.addActionListener(e -> {
            panelContenido.setVisible(true);
            panelContenido.removeAll();
            switch (filtroBusqueda.getSelectedIndex()) {
                case 0:{
                    //todos los productos
                    for (int i=0;i<cantProductos;i++){
                        JTextArea textArea =  new JTextArea(catalogo.infoProducto(i));
                        textArea.setEditable(false);
                        panelContenido.add(textArea,BorderLayout.WEST);

                    }
                } break;
                case 1:{
                    panelContenido.removeAll();
                    //producto mas caro
                    JTextArea textArea =  new JTextArea(catalogo.productoMasCaro());
                    textArea.setEditable(false);
                    panelContenido.add(textArea,BorderLayout.WEST);
                    eleccionProducto.setSelectedIndex(1);

                } break;
                case 2:{
                    panelContenido.removeAll();
                    //producto mas barato
                    JTextArea textArea =  new JTextArea(catalogo.productoMasBarato());
                    textArea.setEditable(false);
                    panelContenido.add(textArea,BorderLayout.WEST);
                    eleccionProducto.setSelectedIndex(3);

                } break;

                default:{
                    JOptionPane.showMessageDialog(null,"Error en la selección");
                }
            }

            resultadosProductos.revalidate();
            resultadosProductos.repaint();
        });

        Carrito carrito = new Carrito();
        agregarAlCarritoButton.addActionListener(e -> {
            try {
                int id = (Integer.parseInt((eleccionProducto.getSelectedItem().toString())));
                int cant = Integer.parseInt(cantidadProducto.getSelectedItem().toString());
                Producto producto = catalogo.buscarProductoPorId(id);
                carrito.agregarProducto(producto, cant);
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        carroDeComprasButton.setVisible(true);
        //boton carro de compras
        ImageIcon iconCarrito = new ImageIcon(getClass().getResource("/images/carro compras.png"));
        carroDeComprasButton.setIcon(new ImageIcon(iconCarrito.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH)));
        carroDeComprasButton.addActionListener(e -> {
            new InterfazProductosCarroDeCompras(carrito);
        });
    }





    public JPanel getInterfazPrincipal() {
        return InterfazPrincipal;
    }
}
