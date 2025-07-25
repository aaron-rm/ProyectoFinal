package bInterfaz;

import cSistema.aUsuario.Cliente;
import cSistema.aUsuario.Cuenta;

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
    private Cuenta usuario;

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
            Cliente clienteEjemplo = new Cliente("ID de ejemplo","Usuario de Ejemplo",11111,"correo@gmail.com");
            Cuenta cuentaEjmeplo = new Cuenta("usuario","1234",clienteEjemplo);

            try {
                String user = usuarioTextField.getText().trim();
                String contrasenia = contraseñaTextField.getText().trim();

                if (user.matches("") || contrasenia.matches("")){
                    throw new RuntimeException("Rellene todos los datos");
                }else if (user.matches(cuentaEjmeplo.getIdCuenta()) && contrasenia.matches(cuentaEjmeplo.getPassword())){
                    JOptionPane.showMessageDialog(this,"Sesión Iniciada con cuenta de ejemplo");
                    usuario = cuentaEjmeplo;
                }else if (user.matches(usuario.getIdCuenta()) && contrasenia.matches(usuario.getPassword())){
                    JOptionPane.showMessageDialog(this,"Bienvenido "+usuario.cliente.getNombre());
                }else {
                    throw new RuntimeException("No se ha encontrado ninguna cuenta");
                }

                JOptionPane.showMessageDialog(this,"Sesión Iniciada");
                frame.dispose();
                new InterfazPrincipal(usuario);


            }catch (NullPointerException exception){
                System.out.println("1");
                JOptionPane.showMessageDialog(null,"No existe esta cuenta");
            }
            catch (RuntimeException exception){
                System.out.println("2");
                JOptionPane.showMessageDialog(null,exception.getMessage());
            }
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
            InterfazCrearCuenta cuenta = new InterfazCrearCuenta(frame);
            cuenta.setVisible(true);

            boolean estado = cuenta.getEstado();
            if(estado){
                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Deseas iniciar sesión con la cuenta creada?",
                        "Iniciar Sesión",
                        JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    usuario = cuenta.getCuenta();
                    new InterfazPrincipal(usuario);
                }else usuario = cuenta.getCuenta();
            }


        });

    }





    public JPanel getInterfazPrincipal() {
        return InterfazPrincipal;
    }

}

