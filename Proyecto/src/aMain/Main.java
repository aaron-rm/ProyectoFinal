package aMain;

import javax.swing.*;
import java.awt.*;


public class Main {


    private JPanel JPanelInicio;
    private JButton iniciarButton;
    private JLabel logoUTP;
    private JLabel logoFISC;
    private JLabel textoSuperior;
    private JTextArea UNIVERSIDADTECNOLÓGICADEPANAMÁTextArea;

    public Main(){
        iniciarButton.addActionListener(ActionListener->{

        });



        ImageIcon iconFisc = new ImageIcon(getClass().getResource("/images/FISC logo.png"));
        ImageIcon iconUTP = new ImageIcon(getClass().getResource("/images/UTP logo.png"));
        logoFISC.setIcon(new ImageIcon(iconFisc.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        logoUTP.setIcon(new ImageIcon(iconUTP.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
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
