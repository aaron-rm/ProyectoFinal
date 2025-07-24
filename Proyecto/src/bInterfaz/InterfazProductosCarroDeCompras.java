package bInterfaz;

import cSistema.bProductos.Carrito;

import javax.swing.*;
import java.awt.*;

public class InterfazProductosCarroDeCompras {
    private final int ICON_SCALE = 30;
    private JButton cerrarSesiónButton;
    private JButton volverButton;
    private JPanel InterfazPrincipal;
    private JButton vaciarCarritoButton;
    private JButton realizarPedidoButton;
    private JTextArea resumenCarrito;


    public InterfazProductosCarroDeCompras(Carrito carrito) {
        //frame principal
        JFrame frame = new JFrame("\uD835\uDE4E\uD835\uDE65\uD835\uDE5A\uD835\uDE5A\uD835\uDE59\uD835\uDE47\uD835\uDE56\uD835\uDE57 | Carro de Compras");
        frame.setVisible(true);
        frame.setContentPane(getInterfazPrincipal());
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(720,480);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        ImageIcon iconEmpresa = new ImageIcon(getClass().getResource("/images/SpeedLab LOGO.png"));
        frame.setIconImage(iconEmpresa.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE, Image.SCALE_SMOOTH));

        resumenCarrito.setText(carrito.imprimirCarrito());

        volverButton.addActionListener(e -> {
           frame.dispose();
        });

        ImageIcon iconUsuario = new ImageIcon(getClass().getResource("/images/usuario.png"));
        cerrarSesiónButton.setIcon(new ImageIcon(iconUsuario.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH)));
        cerrarSesiónButton.addActionListener(e -> {
            frame.dispose();
            new InterfazCuenta();
        });

        vaciarCarritoButton.addActionListener(e -> {
            carrito.vaciarCarrito();
            resumenCarrito.setText(carrito.imprimirCarrito());
            JOptionPane.showMessageDialog(null, "Carrito Vaciado con Éxito");
        });


        realizarPedidoButton.addActionListener(e -> {
            carrito.vaciarCarrito();
            resumenCarrito.setText(carrito.imprimirCarrito());
            JOptionPane.showMessageDialog(null, "Compra Realizada con Éxito");
        });


    }


    public JPanel getInterfazPrincipal() {
        return InterfazPrincipal;
    }
}
