package bInterfaz;


import cSistema.aUsuario.Cliente;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class InterfazPrincipal extends JFrame{

    private JButton instragramButton;
    private JButton whatsAppButton;
    private JPanel InterfazPrincipal;
    private JLabel empresaLOGO;
    private JButton productosButton;
    private JButton serviciosButton;
    private JButton cerrarSesiónButton;
    private JButton salirButton;
    private final int ICON_SCALE = 30;
    private boolean sesionIniciada=false;
    private Cliente cliente;

    public InterfazPrincipal (Cliente cliente){
        //frame principal
        JFrame frame = new JFrame("\uD835\uDE4E\uD835\uDE65\uD835\uDE5A\uD835\uDE5A\uD835\uDE59\uD835\uDE47\uD835\uDE56\uD835\uDE57 | Detailing, Pulidos y Más");
        frame.setVisible(true);
        frame.setContentPane(getInterfazPrincipal());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(720,480);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        ImageIcon iconEmpresa = new ImageIcon(getClass().getResource("/images/SpeedLab LOGO.png"));
        frame.setIconImage(iconEmpresa.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH));

        //botones interfaz
        empresaLOGO.setIcon(new ImageIcon(iconEmpresa.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
        ImageIcon iconServicios = new ImageIcon(getClass().getResource("/images/calendario.png"));
        ImageIcon iconProductos = new ImageIcon(getClass().getResource("/images/productos.png"));
        serviciosButton.setIcon(new ImageIcon(iconServicios.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH)));
        productosButton.setIcon(new ImageIcon(iconProductos.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH)));




        ImageIcon iconUsuario = new ImageIcon(getClass().getResource("/images/usuario.png"));
        cerrarSesiónButton.setIcon(new ImageIcon(iconUsuario.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH)));
        cerrarSesiónButton.addActionListener(e -> {
            frame.dispose();
            new InterfazCuenta();
        });



        serviciosButton.addActionListener(ActionListener->{
            frame.dispose();
            new InterfazServicios(cliente);


        });

        productosButton.addActionListener(ActionListener->{
            frame.dispose();
            new InterfazProductos(cliente);


        });

        //botones de redes sociales
        //iconos de redes sociales
        ImageIcon iconWssp = new ImageIcon(getClass().getResource("/images/wssp LOGO.png"));
        ImageIcon iconIg = new ImageIcon(getClass().getResource("/images/ig LOGO.png"));
        instragramButton.setIcon(new ImageIcon(iconIg.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH)));
        whatsAppButton.setIcon(new ImageIcon(iconWssp.getImage().getScaledInstance(ICON_SCALE, ICON_SCALE,Image.SCALE_SMOOTH)));

        instragramButton.addActionListener(ActionListener->{
            try {
                URI googleUri = new URI("https://www.instagram.com/spdlabs/");
                Desktop.getDesktop().browse(googleUri);

            } catch (URISyntaxException | IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al abrir Google: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        whatsAppButton.addActionListener(ActionListener->{
            try{
                URI wsspUri = new URI("https://wa.me/64330646");
                Desktop.getDesktop().browse(wsspUri);

            } catch (URISyntaxException | IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al abrir Google: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        salirButton.addActionListener(e -> {
            System.exit(0);
        });
    }


    public JPanel getInterfazPrincipal() {
        return InterfazPrincipal;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
