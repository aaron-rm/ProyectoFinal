package bInterfaz;

import cSistema.aUsuario.Cliente;
import cSistema.bProductos.CarritoDeCompra;

import javax.swing.*;
import java.awt.*;

public class InterfazProductos {
    private int iconScale = 30;
    private JPanel InterfazPrincipal;
    private JButton cerrarSesiónButton;
    private JButton volverButton;
    private JButton carroDeComprasButton;

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
        frame.setIconImage(iconEmpresa.getImage().getScaledInstance(iconScale,iconScale, Image.SCALE_SMOOTH));


        //boton carro de compras
        ImageIcon iconCarrito = new ImageIcon(getClass().getResource("/images/carro compras.png"));
        carroDeComprasButton.setIcon(new ImageIcon(iconCarrito.getImage().getScaledInstance(iconScale,iconScale,Image.SCALE_SMOOTH)));
        carroDeComprasButton.addActionListener(e -> {
           new InterfazProductosCarroDeCompras();
        });

        ImageIcon iconUsuario = new ImageIcon(getClass().getResource("/images/usuario.png"));
        cerrarSesiónButton.setIcon(new ImageIcon(iconUsuario.getImage().getScaledInstance(iconScale,iconScale,Image.SCALE_SMOOTH)));
        cerrarSesiónButton.addActionListener(e -> {
            frame.dispose();
            new InterfazCuenta();
        });

        volverButton.addActionListener(e -> {
            frame.dispose();
            new InterfazPrincipal(cliente);
        });
    }





    public JPanel getInterfazPrincipal() {
        return InterfazPrincipal;
    }
}
