package bInterfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazProductos {
    private int iconScale = 30;
    private JPanel InterfazPrincipal;

    public InterfazProductos(){
        //frame principal
        JFrame frame = new JFrame("\uD835\uDE4E\uD835\uDE65\uD835\uDE5A\uD835\uDE5A\uD835\uDE59\uD835\uDE47\uD835\uDE56\uD835\uDE57 | Productos");
        frame.setVisible(true);
        frame.setContentPane(getInterfazPrincipal());
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(720,480);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        ImageIcon iconEmpresa = new ImageIcon(getClass().getResource("/images/SpeedLab LOGO.png"));
        frame.setIconImage(iconEmpresa.getImage().getScaledInstance(iconScale,iconScale, Image.SCALE_SMOOTH));



    }





    public JPanel getInterfazPrincipal() {
        return InterfazPrincipal;
    }
}
