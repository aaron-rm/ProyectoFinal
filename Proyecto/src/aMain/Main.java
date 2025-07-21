package aMain;

import bInterfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;


//Aaron Remarchuk   8-1042-134
//Luis King         8-1017-548
//Edwin Rodriguez   8-975-208
//Kevin Kakiyama    8-1025-1743

public class Main extends JFrame {


    private JPanel JPanelInicio;
    private JButton iniciarButton;
    private JLabel logoUTP;
    private JLabel logoFISC;
    private JButton salirButton;
    private JLabel txtLABEL;
    private JLabel textoSuperior;

    public Main(){

        //ir a la pantalla principal
        iniciarButton.addActionListener(ActionListener->{

            new InterfazPrincipal();

        });

        salirButton.addActionListener(ActionListener->{
            System.exit(0);
        });


        ImageIcon iconFisc = new ImageIcon(getClass().getResource("/images/FISC logo.png"));
        ImageIcon iconUTP = new ImageIcon(getClass().getResource("/images/UTP logo.png"));
        logoFISC.setIcon(new ImageIcon(iconFisc.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        logoUTP.setIcon(new ImageIcon(iconUTP.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Proyecto Final");
        frame.setVisible(true);
        frame.setContentPane(new Main().getJPanelInicio());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(720,480);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
    }

    private JPanel getJPanelInicio() {
        return JPanelInicio;
    }
}
