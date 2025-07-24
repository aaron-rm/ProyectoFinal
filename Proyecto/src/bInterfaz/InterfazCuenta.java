package bInterfaz;

import cSistema.aUsuario.Cliente;

import javax.swing.*;
import java.awt.*;

public class InterfazCuenta extends JFrame{
    private final int ICON_SCALE = 30;
    private JPanel InterfazPrincipal;
    private JTextField usuarioTextField;
    private JTextField contraseñaTextField;
    private JButton limpiarCamposButton;
    private JButton crearCuentaButton;
    private JButton iniciarSesiónButton;
    private JButton salirButton;


    public InterfazCuenta(){
        //frame principal
        JFrame frame = new JFrame("\uD835\uDE4E\uD835\uDE65\uD835\uDE5A\uD835\uDE5A\uD835\uDE59\uD835\uDE47\uD835\uDE56\uD835\uDE57 | Iniciar Sesión");
        frame.setVisible(true);
        frame.setContentPane(getInterfazPrincipal());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(720,480);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        ImageIcon iconEmpresa = new ImageIcon(getClass().getResource("/images/SpeedLab LOGO.png"));
        frame.setIconImage(iconEmpresa.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE, Image.SCALE_SMOOTH));



        iniciarSesiónButton.addActionListener(e -> {
            //iniciar sesion


            JOptionPane.showMessageDialog(this,"Sesión Iniciada");
            Cliente cliente = new Cliente();
            frame.dispose();
            new InterfazPrincipal(cliente);
        });

        limpiarCamposButton.addActionListener(e -> {
            //vaciar los campos
            usuarioTextField.setText("");
            contraseñaTextField.setText("");
        });

        salirButton.addActionListener(e -> {
           System.exit(0);
        });

        crearCuentaButton.addActionListener(e -> {
            //crear una cuenta
            new InterfazCrearCuenta();
        });

    }





    public JPanel getInterfazPrincipal() {
        return InterfazPrincipal;
    }

}

